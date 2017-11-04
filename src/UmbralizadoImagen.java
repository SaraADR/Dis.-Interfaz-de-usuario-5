
import java.awt.Graphics;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UmbralizadoImagen extends javax.swing.JFrame {

 
    public UmbralizadoImagen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImagen = new PanelImagen();
        menuPadre = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuItemAbrir = new javax.swing.JMenuItem();
        menuItemGuardar = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenu();
        menuUmbral = new javax.swing.JMenuItem();
        menuRevertir = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        menuAcercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Umbralizado de imagenes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout panelImagenLayout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(panelImagenLayout);
        panelImagenLayout.setHorizontalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );
        panelImagenLayout.setVerticalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        menuArchivo.setText("Archivo");

        menuItemAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuItemAbrir.setText("Abrir");
        menuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAbrirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemAbrir);

        menuItemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuItemGuardar.setText("Guardar");
        menuItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGuardarActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemGuardar);

        menuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuSalir);

        menuPadre.add(menuArchivo);

        menuEditar.setText("Editar");

        menuUmbral.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        menuUmbral.setText("Seleccionar Umbral");
        menuUmbral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUmbralActionPerformed(evt);
            }
        });
        menuEditar.add(menuUmbral);

        menuRevertir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        menuRevertir.setText("Revertir cambios");
        menuRevertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRevertirActionPerformed(evt);
            }
        });
        menuEditar.add(menuRevertir);

        menuPadre.add(menuEditar);

        menuAyuda.setText("Ayuda");

        menuAcercade.setText("Acerca de");
        menuAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAcercadeActionPerformed(evt);
            }
        });
        menuAyuda.add(menuAcercade);

        menuPadre.add(menuAyuda);

        setJMenuBar(menuPadre);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAbrirActionPerformed
        JFileChooser fc = new JFileChooser();
        anadirFiltros(fc);
        int res = fc.showOpenDialog(null);
        if(res == JFileChooser.APPROVE_OPTION){
            try{
                repaint();
                img = new Imagen(fc.getSelectedFile());
                panelImagen.setImagen(img);
                Graphics g = panelImagen.getGraphics();
                panelImagen.paintComponent(g);
            }catch(NullPointerException ex){
                JOptionPane.showMessageDialog(panelImagen,"Imagen no válida",
                            "Fallo al abrir",ERROR_MESSAGE);
            }
            
        }
        
    }//GEN-LAST:event_menuItemAbrirActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        confirmacionSalida();
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGuardarActionPerformed
        JFileChooser fc = new JFileChooser(".");      
        anadirFiltros(fc); 
        if(fc.showSaveDialog(null)==fc.APPROVE_OPTION){
            String ruta = fc.getSelectedFile().getAbsolutePath();
            if(new File (ruta).exists()){
                int res = JOptionPane.showConfirmDialog(panelImagen, 
                        "El archivo ya existe ¿desea sobrescribirlo?", 
                        "Arhivo encontrado",WARNING_MESSAGE);
                if(res==JOptionPane.YES_OPTION){
                    try{
                        img.saveImagen(ruta);
                    }catch(NullPointerException e){
                        JOptionPane.showMessageDialog(panelImagen, 
                                "No hay ninguna imagen que guardar",
                                "Fallo al guardar",ERROR_MESSAGE);
                    } 
                }
            }else{
                try{
                    img.saveImagen(ruta);
                }catch(NullPointerException e){
                    JOptionPane.showMessageDialog(panelImagen, 
                            "No hay ninguna imagen que guardar",
                            "Fallo al guardar",ERROR_MESSAGE);
                } 
            }
        }
    }//GEN-LAST:event_menuItemGuardarActionPerformed

    private void menuUmbralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUmbralActionPerformed
        String res = (String) JOptionPane.showInputDialog(rootPane,
                "Introduzca el umbral a aplicar en la imagen",
                "Umbral:",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null, //String[] combobox con las posibles opciones
                "0");
        try{
            if(res != null){
                img.umbralizar(Integer.parseInt(res));
                panelImagen.paintComponent(panelImagen.getGraphics());
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(panelImagen, 
                            "El valor del umbral debe ser numérico",
                            "Error umbral",ERROR_MESSAGE);   
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(panelImagen, 
                            "No hay imagen a la que aplicar el umbral",
                            "Error umbral",ERROR_MESSAGE);   
        }
    }//GEN-LAST:event_menuUmbralActionPerformed

    private void menuAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAcercadeActionPerformed
        JOptionPane.showMessageDialog(rootPane, 
                "Programa creado por Cristina Benlliure Jiménez y "
                + "Sara Arribas del Rosario");
    }//GEN-LAST:event_menuAcercadeActionPerformed

    private void menuRevertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRevertirActionPerformed
        int res = JOptionPane.showConfirmDialog(rootPane,
                "¿Deseas volver a la imagen sin umbralizar?",
                         "Restaurar imagen",
                         JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION){
            repaint();
            img.restore();
            panelImagen.paintComponent(panelImagen.getGraphics());
         }
    }//GEN-LAST:event_menuRevertirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        confirmacionSalida();
    }//GEN-LAST:event_formWindowClosing
    
    private void anadirFiltros(JFileChooser aux){
        aux.addChoosableFileFilter(new FileNameExtensionFilter("Ficheros png","png"));
        aux.addChoosableFileFilter(new FileNameExtensionFilter("Ficheros gif","gif"));
        aux.addChoosableFileFilter(new FileNameExtensionFilter("Ficheros jpg, jpeg","jpg","jpeg"));
        aux.addChoosableFileFilter(new FileNameExtensionFilter("Ficheros bnp, wbnp","bnp","wbnp")); 
    }
    
    private void confirmacionSalida(){
        int res = JOptionPane.showConfirmDialog(rootPane,
                "¿Estas seguro que quieres salir?",
                         "Salir",
                         JOptionPane.YES_NO_OPTION);
        if(res== JOptionPane.YES_OPTION){
            System.exit(0);
        } 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UmbralizadoImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UmbralizadoImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UmbralizadoImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UmbralizadoImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UmbralizadoImagen().setVisible(true);
            }
        });
    }
    //Variables
    private Imagen img;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem menuAcercade;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuEditar;
    private javax.swing.JMenuItem menuItemAbrir;
    private javax.swing.JMenuItem menuItemGuardar;
    private javax.swing.JMenuBar menuPadre;
    private javax.swing.JMenuItem menuRevertir;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JMenuItem menuUmbral;
    private PanelImagen panelImagen;
    // End of variables declaration//GEN-END:variables
}
