package poo.proyecto.frames;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import poo.proyecto.clases.ListaBodega;

public class AgregarBodegaFrame extends javax.swing.JFrame {

    private ListaBodega bodegas;
    public int x, y;

    public AgregarBodegaFrame(ListaBodega bodegas) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.bodegas = bodegas;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtSuperficie = new javax.swing.JTextField();
        txtPiso = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        comboTipo = new javax.swing.JComboBox<>();
        botonAgregar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jLabelMover = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Numero Bodega");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Piso");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setText("Superficie");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 90, -1));

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setText("Precio (UF)");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 153));
        jLabel5.setText("Tipo");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        txtNumero.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtNumero.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 150, -1));

        txtSuperficie.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtSuperficie.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtSuperficie, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 150, -1));

        txtPiso.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtPiso.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 40, 150, -1));

        txtPrecio.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 150, -1));

        comboTipo.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        comboTipo.setForeground(new java.awt.Color(0, 51, 153));
        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G" }));
        getContentPane().add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 150, -1));

        botonAgregar.setBackground(new java.awt.Color(102, 204, 255));
        botonAgregar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        botonAgregar.setForeground(new java.awt.Color(204, 255, 255));
        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 110, -1));

        botonCancelar.setBackground(new java.awt.Color(102, 204, 255));
        botonCancelar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(204, 255, 255));
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 120, 110, -1));

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
        getContentPane().add(jLabelMover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        String numero = txtNumero.getText();
        String superficie = txtSuperficie.getText();
        String precio = txtPrecio.getText();
        String tipo = comboTipo.getItemAt(comboTipo.getSelectedIndex());
        String piso = txtPiso.getText();
        if (faltanDatos(numero, superficie, precio, tipo, piso)) {
            if (this.bodegas.agregar(numero,superficie,precio,tipo,piso)){
                JOptionPane.showMessageDialog(new JFrame(), "Se agrego correctamente", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }else
            JOptionPane.showMessageDialog(new JFrame(), "Debe ingresar todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void jLabelMoverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMoverMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabelMoverMousePressed

    private void jLabelMoverMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMoverMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabelMoverMouseDragged

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed
 
    public boolean faltanDatos(String numero, String superficie, String precio, String tipo, String piso) {
        if (superficie.isEmpty()
                || precio.isEmpty()
                || tipo.isEmpty()
                || piso.isEmpty()
                || numero.isEmpty()) {
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelMover;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPiso;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSuperficie;
    // End of variables declaration//GEN-END:variables
}
