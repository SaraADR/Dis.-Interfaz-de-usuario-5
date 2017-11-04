import boofcv.alg.filter.binary.GThresholdImageOps;
import boofcv.core.image.ConvertImage;
import boofcv.gui.binary.VisualizeBinaryData;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.struct.image.GrayU8;
import boofcv.struct.image.Planar;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Imagen {
    private double imageHeight;
    private double imageWidth;
    private File img;
    private BufferedImage imgUmbral;
    private String name;
    //ImageIO soporta jpeg,png,gif,bnp,wbnp
    String extension = ".png .jpeg .gif .bnp .wbnp .jpg";

    public Imagen(File f) {
        try {
            this.img = f;
            this.imgUmbral = ImageIO.read(f);
            this.imageHeight=imgUmbral.getHeight();
            this.imageWidth=imgUmbral.getWidth();
            this.name= 	f.getName();
        } catch (IOException ex) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public void saveImagen(String ruta){
        try {
            String ext = ruta.substring(ruta.lastIndexOf(".")+1,ruta.length()).toLowerCase();
            if(extension.contains(ext)){
                File outputfile = new File(ruta);
                ImageIO.write(imgUmbral, ext, outputfile);
            } else {
                File outputfile = new File(ruta + ".png");
                ImageIO.write(imgUmbral, "png", outputfile);
            }  
        } catch (IOException e) {}
    }
            
    public BufferedImage getBufferedImage(){
        return imgUmbral;
    }
    public double getHeigth(){
        return imageHeight;
    }
    public double getWidth(){
        return imageWidth;
    }
    public void restore(){
        try {
            imgUmbral = ImageIO.read(img);
        } catch (IOException ex) {}
    }
    
     
    public void ajustar(double panelHeight, double panelWidth ) throws java.lang.NullPointerException{
        double ih = imageHeight;
        double iw = imageWidth;
        if(ih==iw){ //si la imagen es cuadrada
            if(panelHeight>panelWidth){ 
                imageHeight=panelWidth;
                imageWidth=panelWidth;
            }else{
                imageHeight=panelHeight;
                imageWidth=panelHeight;
            }
        } else if((ih>panelHeight) || (iw>panelWidth)){ 
            //la imagen es mayor hay que reducir
            if(ih>iw){
                imageWidth = iw/(ih/panelHeight);
                imageHeight = panelHeight;
            }else if(ih<iw){
                imageHeight = ih/(iw/panelWidth);
                imageWidth = panelWidth;
            }
        }else{
            //la imagen es menor
            if(ih>iw){
                imageWidth = iw*(panelHeight/ih);
                imageHeight = panelHeight;
            }else if(ih<iw){
                imageHeight = ih*(panelWidth/iw);
                imageWidth = panelWidth;
            }            
        }
    }
    
    public void umbralizar(int umbral) {
        // convierte la imagen en color BufferedImage en formato de la librería BoofCV
        Planar<GrayU8> imagenColor = ConvertBufferedImage.convertFromPlanar(imgUmbral,null, true, GrayU8.class);
        
        // crea dos imágenes en niveles de grises
        GrayU8 imagenGris = new GrayU8(imgUmbral.getWidth(), imgUmbral.getHeight());
        GrayU8 imagenUmbralizada = new GrayU8(imgUmbral.getWidth(), imgUmbral.getHeight());
        // Convierte a niveles de gris la imagen de entrada
        ConvertImage.average(imagenColor,imagenGris);
        // umbraliza la imagen: 
        // ‐ píxeles con nivel de gris > umbral se ponen a 1
        // ‐ píxeles con nivel de gris <= umbra se ponen a 0
        GThresholdImageOps.threshold(imagenGris, imagenUmbralizada, umbral, false);
        // se devuelve la imagen umbralizada en formato BufferedImage
        imgUmbral = VisualizeBinaryData.renderBinary(imagenUmbralizada, false, null);
    }
}
