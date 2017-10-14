package poo.proyecto.frames;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import poo.proyecto.clases.Bodega;
import poo.proyecto.clases.ListaBodega;

public class MostrarBodegaFrame extends javax.swing.JFrame {

    private Bodega bodega;
    private ListaBodega bodegas;
    public int x, y;

    public MostrarBodegaFrame(Bodega bodega, ListaBodega bodegas) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle(bodega.getTitulo());
        this.bodega = bodega;
        this.bodegas = bodegas;

        cargarDatosBodega();
        txtNumero.setEnabled(false);
        txtPiso.setEnabled(false);
        txtSuperficie.setEnabled(false);
        txtPrecio.setEnabled(false);
        comboTipo.setEnabled(false);
        comboEstado.setEnabled(false);
        jButtonGuardar.setVisible(false);
    }

    private void cargarDatosBodega() {
        txtNumero.setText(Integer.toString(this.bodega.getNumero()));
        txtPiso.setText(Integer.toString(this.bodega.getPiso()));
        txtSuperficie.setText(Double.toString(this.bodega.getSuperficie()));
        txtPrecio.setText(Integer.toString(this.bodega.getPrecio()));
        comboTipo.getModel().setSelectedItem(this.bodega.getTipo());
        comboEstado.getModel().setSelectedItem(this.bodega.getEstado());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtSuperficie = new javax.swing.JTextField();
        txtPiso = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        comboEstado = new javax.swing.JComboBox<>();
        comboTipo = new javax.swing.JComboBox<>();
        jButtonEditar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabelMover = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Numero Bodega");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Piso");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setText("Superficie");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setText("Precio (UF)");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 153));
        jLabel5.setText("Estado");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 153));
        jLabel6.setText("Tipo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        txtNumero.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtNumero.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, -1));

        txtSuperficie.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtSuperficie.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtSuperficie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 150, -1));

        txtPiso.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtPiso.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 150, -1));

        txtPrecio.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 150, -1));

        comboEstado.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        comboEstado.setForeground(new java.awt.Color(0, 51, 153));
        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En Construcción", "Disponible", "Vendido" }));
        getContentPane().add(comboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 150, -1));

        comboTipo.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        comboTipo.setForeground(new java.awt.Color(0, 51, 153));
        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G" }));
        getContentPane().add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 150, -1));

        jButtonEditar.setBackground(new java.awt.Color(102, 204, 255));
        jButtonEditar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jButtonEditar.setForeground(new java.awt.Color(204, 255, 255));
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 100, -1));

        jButtonGuardar.setBackground(new java.awt.Color(102, 204, 255));
        jButtonGuardar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jButtonGuardar.setForeground(new java.awt.Color(204, 255, 255));
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 100, -1));

        jButtonEliminar.setBackground(new java.awt.Color(102, 204, 255));
        jButtonEliminar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(204, 255, 255));
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 100, -1));

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/x32-salir.png"))); // NOI18N
        jButtonSalir.setBorderPainted(false);
        jButtonSalir.setContentAreaFilled(false);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 40, 40));

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
        getContentPane().add(jLabelMover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 30));

        jLabelFondo.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabelFondo.setForeground(new java.awt.Color(0, 51, 153));
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        jLabelFondo.setPreferredSize(new java.awt.Dimension(568, 228));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        txtPiso.setEnabled(true);
        txtSuperficie.setEnabled(true);
        txtPrecio.setEnabled(true);
        comboTipo.setEnabled(true);
        comboEstado.setEnabled(true);
        jButtonEditar.setVisible(false);
        jButtonGuardar.setVisible(true);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        String numero = txtNumero.getText();
        String superficie = txtSuperficie.getText();
        String precio = txtPrecio.getText();
        String tipo = comboTipo.getItemAt(comboTipo.getSelectedIndex());
        String piso = txtPiso.getText();
        String estado = comboEstado.getItemAt(comboEstado.getSelectedIndex());

        if (faltanDatos(superficie, precio, tipo, piso, estado)) {
            if (bodegas.editar(numero,superficie, precio, tipo, piso, estado)) {
                txtPiso.setEnabled(false);
                txtSuperficie.setEnabled(false);
                txtPrecio.setEnabled(false);
                comboTipo.setEnabled(false);
                comboEstado.setEnabled(false);
                jButtonEditar.setVisible(true);
                jButtonGuardar.setVisible(false);
            }
        }else
            JOptionPane.showMessageDialog(new JFrame(), "Debe ingresar todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la bodega?", "Atención", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            if (this.bodegas.eliminar(this.bodega.getNumero())) {
                JOptionPane.showMessageDialog(new JFrame(), "Se eliminó correctamente", "Error", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }else
                JOptionPane.showMessageDialog(new JFrame(), "No es posible eliminar ya que está vendido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jLabelMoverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMoverMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabelMoverMousePressed

    private void jLabelMoverMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMoverMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabelMoverMouseDragged

    public boolean faltanDatos(String superficie, String precio, String tipo, String piso, String estado) {
        if (superficie.isEmpty()
                || precio.isEmpty()
                || tipo.isEmpty()
                || piso.isEmpty()
                || estado.isEmpty()) {
            return false;
        }
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonSalir;
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
