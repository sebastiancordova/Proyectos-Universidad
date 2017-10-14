package poo.proyecto.frames;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import poo.proyecto.clases.ListaDepartamento;

public class AgregarDepartamentoFrame extends javax.swing.JFrame {

    private ListaDepartamento departamentos;
    public int x, y;

    public AgregarDepartamentoFrame(ListaDepartamento departamentos) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.departamentos = departamentos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPiso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSuperficie = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboCocina = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        comboBanos = new javax.swing.JComboBox<>();
        comboDormitorios = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        comboTipo = new javax.swing.JComboBox<>();
        jLabelFondo = new javax.swing.JLabel();
        jLabelMover = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Departamento");
        setUndecorated(true);
        setOpacity(0.95F);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Número Departamento");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 9, -1, -1));

        txtNumero.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtNumero.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 38, 167, -1));

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Piso");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 9, -1, -1));

        txtPiso.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtPiso.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 38, 167, -1));

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setText("Tipo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 9, -1, -1));

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setText("Superficie");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 82, -1, -1));

        txtSuperficie.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtSuperficie.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtSuperficie, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 111, 167, -1));

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 153));
        jLabel5.setText("Precio (UF)");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 82, -1, -1));

        txtPrecio.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 111, 167, -1));

        jLabel6.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 153));
        jLabel6.setText("Tipo Cocina");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 82, -1, -1));

        comboCocina.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        comboCocina.setForeground(new java.awt.Color(0, 51, 153));
        comboCocina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Americana", "Normal" }));
        getContentPane().add(comboCocina, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 111, 167, -1));

        jLabel8.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 153));
        jLabel8.setText("Cantidad Dormitorios");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 155, -1, -1));

        comboBanos.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        comboBanos.setForeground(new java.awt.Color(0, 51, 153));
        comboBanos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        getContentPane().add(comboBanos, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 185, 167, -1));

        comboDormitorios.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        comboDormitorios.setForeground(new java.awt.Color(0, 51, 153));
        comboDormitorios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        getContentPane().add(comboDormitorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 185, 167, -1));

        jLabel9.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 153));
        jLabel9.setText("Cantidad Baños");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 155, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(120, 204, 255));
        btnAgregar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(204, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 184, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(120, 204, 255));
        btnCancelar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(204, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 184, -1, -1));

        comboTipo.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        comboTipo.setForeground(new java.awt.Color(0, 51, 153));
        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G" }));
        getContentPane().add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 38, 200, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        jLabelFondo.setPreferredSize(new java.awt.Dimension(604, 249));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
        getContentPane().add(jLabelMover, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 600, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String numero, superficie, precio, tipo, piso, banos, dormitorios, tipoCocina;
        numero = txtNumero.getText();
        superficie = txtSuperficie.getText();
        precio = txtPrecio.getText();
        tipo = comboTipo.getItemAt(comboTipo.getSelectedIndex());
        piso = txtPiso.getText();
        banos = comboBanos.getItemAt(comboBanos.getSelectedIndex());
        dormitorios = comboDormitorios.getItemAt(comboDormitorios.getSelectedIndex());
        tipoCocina = comboCocina.getItemAt(comboCocina.getSelectedIndex());

        if (faltanDatos(numero, superficie, precio, tipo, piso, banos, dormitorios, tipoCocina)) {
            if (this.departamentos.agregar(numero, superficie, precio, tipo, piso, banos, dormitorios, tipoCocina)) {
                JOptionPane.showMessageDialog(new JFrame(), "Se agrego correctamente", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "No se pudo agregar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Debe ingresar todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jLabelMoverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMoverMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabelMoverMousePressed

    private void jLabelMoverMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMoverMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabelMoverMouseDragged

    public boolean faltanDatos(String numero, String superficie, String precio, String tipo, String piso, String numeroBanos, String numeroDormitorios, String tipoCocina) {
        if (numero.isEmpty()
                || superficie.isEmpty()
                || precio.isEmpty()
                || tipo.isEmpty()
                || piso.isEmpty()
                || numeroBanos.isEmpty()
                || numeroDormitorios.isEmpty()
                || tipoCocina.isEmpty()
                || piso.isEmpty()) {
            return false;
        }
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> comboBanos;
    private javax.swing.JComboBox<String> comboCocina;
    private javax.swing.JComboBox<String> comboDormitorios;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelMover;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPiso;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSuperficie;
    // End of variables declaration//GEN-END:variables
}
