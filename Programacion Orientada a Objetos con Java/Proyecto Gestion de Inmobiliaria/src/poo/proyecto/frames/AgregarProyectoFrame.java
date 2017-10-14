package poo.proyecto.frames;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import poo.proyecto.clases.ListaProyecto;

public class AgregarProyectoFrame extends JFrame {

    private ListaProyecto proyectos;
    public int x, y;

    public AgregarProyectoFrame(ListaProyecto proyectos) {
        initComponents();
        setLocationRelativeTo(null);
        this.proyectos = proyectos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombreProyecto = new javax.swing.JTextField();
        jLabelName = new javax.swing.JLabel();
        jLabelEtapa = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        opcionEtapa = new javax.swing.JComboBox<>();
        jLabelDireccion = new javax.swing.JLabel();
        txtDireccionProyecto = new javax.swing.JTextField();
        jLabelRegion = new javax.swing.JLabel();
        opcionRegion = new javax.swing.JComboBox<>();
        jButtonSalir = new javax.swing.JButton();
        jLabelMover = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Proyecto");
        setUndecorated(true);
        setOpacity(0.95F);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreProyecto.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtNombreProyecto.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtNombreProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 270, -1));

        jLabelName.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(0, 51, 153));
        jLabelName.setText("Nombre del Proyecto");
        getContentPane().add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 244, -1));

        jLabelEtapa.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabelEtapa.setForeground(new java.awt.Color(0, 51, 153));
        jLabelEtapa.setText("Etapa");
        getContentPane().add(jLabelEtapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 140, -1));

        btnAgregar.setBackground(new java.awt.Color(102, 204, 255));
        btnAgregar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(204, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 110, 30));

        opcionEtapa.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        opcionEtapa.setForeground(new java.awt.Color(0, 51, 153));
        opcionEtapa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En Verde", "Entrega Inmediata", "En Blanco" }));
        getContentPane().add(opcionEtapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 270, -1));

        jLabelDireccion.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabelDireccion.setForeground(new java.awt.Color(0, 51, 153));
        jLabelDireccion.setText("Dirección");
        getContentPane().add(jLabelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 270, -1));

        txtDireccionProyecto.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtDireccionProyecto.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtDireccionProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 270, -1));

        jLabelRegion.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabelRegion.setForeground(new java.awt.Color(0, 51, 153));
        jLabelRegion.setText("Region");
        getContentPane().add(jLabelRegion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 270, -1));

        opcionRegion.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        opcionRegion.setForeground(new java.awt.Color(0, 51, 153));
        opcionRegion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I Región", "II Región", "III Región", "IV Región", "V Región", "VI Región", "VII Región", "VIII Región", "IX Región", "X Región", "XI Región", "XII Región", "XIII Región", "", "XIV Región", "Región Metropolitana" }));
        getContentPane().add(opcionRegion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 270, -1));

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/x32-salir.png"))); // NOI18N
        jButtonSalir.setBorderPainted(false);
        jButtonSalir.setContentAreaFilled(false);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 50, 40));

        jLabelMover.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabelMoverMouseDragged(evt);
            }
        });
        jLabelMover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelMoverMousePressed(evt);
            }
        });
        getContentPane().add(jLabelMover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        jLabelFondo.setPreferredSize(new java.awt.Dimension(585, 223));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String etapa = opcionEtapa.getItemAt(opcionEtapa.getSelectedIndex());
        String nombreProyecto = txtNombreProyecto.getText();
        String direccionProyecto = txtDireccionProyecto.getText();
        String regionProyecto = opcionRegion.getItemAt(opcionRegion.getSelectedIndex());
        if (estaVacio(etapa, nombreProyecto, direccionProyecto, regionProyecto)) {
            if (this.proyectos.agregar(nombreProyecto, etapa, direccionProyecto, regionProyecto)) {
                JOptionPane.showMessageDialog(new JFrame(), "Se agrego correctamente", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Debe ingresar todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    public boolean estaVacio(String etapa, String nombreProyecto, String direccionProyecto, String regionProyecto) {
        if (etapa.isEmpty()
                || nombreProyecto.isEmpty()
                || direccionProyecto.isEmpty()
                || regionProyecto.isEmpty()) {
            return false;
        }
        return true;
    }

    private void jLabelMoverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMoverMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabelMoverMousePressed

    private void jLabelMoverMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMoverMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabelMoverMouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelEtapa;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelMover;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelRegion;
    private javax.swing.JComboBox<String> opcionEtapa;
    private javax.swing.JComboBox<String> opcionRegion;
    private javax.swing.JTextField txtDireccionProyecto;
    private javax.swing.JTextField txtNombreProyecto;
    // End of variables declaration//GEN-END:variables
}
