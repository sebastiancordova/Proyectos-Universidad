package poo.proyecto.frames;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import poo.proyecto.clases.ListaEstacionamiento;

public class AgregarEstacionamientoFrame extends javax.swing.JFrame {

    private ListaEstacionamiento estacionamientos;
    public int x, y;

    public AgregarEstacionamientoFrame(ListaEstacionamiento estacionamientos) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.estacionamientos = estacionamientos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPiso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtSuperficie = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboTechado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();
        jLabelMover = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Estacionamiento");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Número Estacionamiento");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 9, 160, -1));

        txtNumero.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtNumero.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 38, 160, -1));

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Piso");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 9, 172, -1));

        txtPiso.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtPiso.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 38, 160, -1));

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setText("Tipo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 9, 160, -1));

        comboTipo.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        comboTipo.setForeground(new java.awt.Color(0, 51, 153));
        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G" }));
        getContentPane().add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 38, 160, -1));

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setText("Superficie");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 160, 20));

        txtSuperficie.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtSuperficie.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtSuperficie, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 114, 160, -1));

        txtPrecio.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 114, 160, -1));

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 153));
        jLabel5.setText("Precio (UF)");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 160, 20));

        comboTechado.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        comboTechado.setForeground(new java.awt.Color(0, 51, 153));
        comboTechado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Si" }));
        getContentPane().add(comboTechado, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 111, 163, -1));

        jLabel6.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 153));
        jLabel6.setText("Techado");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 82, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(120, 204, 255));
        btnAgregar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(204, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(120, 204, 255));
        btnCancelar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(204, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        jLabelFondo.setPreferredSize(new java.awt.Dimension(549, 220));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabelMover.setText("jLabel7");
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
        getContentPane().add(jLabelMover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String numero = txtNumero.getText();
        String superficie = txtSuperficie.getText();
        String precio = txtPrecio.getText();
        String tipo = comboTipo.getItemAt(comboTipo.getSelectedIndex());
        String piso = txtPiso.getText();
        String techado = comboTechado.getItemAt(comboTechado.getSelectedIndex());
        if (faltanDatos(numero, superficie, precio, tipo, piso, techado)) {
            if (this.estacionamientos.agregar(numero,superficie,precio,tipo,piso,techado)){
                JOptionPane.showMessageDialog(new JFrame(), "Se agrego correctamente", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        } else
             JOptionPane.showMessageDialog(new JFrame(), "Debe ingresar todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jLabelMoverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMoverMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabelMoverMousePressed

    private void jLabelMoverMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMoverMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabelMoverMouseDragged

    public boolean faltanDatos(String numero, String superficie, String precio, String tipo, String piso, String techado) {
        if (superficie.isEmpty()
                || precio.isEmpty()
                || tipo.isEmpty()
                || piso.isEmpty()
                || techado.isEmpty()
                || numero.isEmpty()) {
            return false;
        }
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> comboTechado;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelMover;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPiso;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSuperficie;
    // End of variables declaration//GEN-END:variables
}
