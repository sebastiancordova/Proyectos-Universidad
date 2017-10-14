package poo.proyecto.frames;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import poo.proyecto.clases.ListaClientes;
import poo.proyecto.clases.Estacionamiento;
import poo.proyecto.clases.ListaEstacionamiento;
import poo.proyecto.clases.Inmueble;

public class MostrarEstacionamientoFrame extends javax.swing.JFrame {

    private Estacionamiento estacionamiento;
    private ListaEstacionamiento estacionamientos;
    private ListaClientes clientes;
    public int x, y;

    public MostrarEstacionamientoFrame(Estacionamiento estacionamiento, ListaEstacionamiento estacionamientos, ListaClientes clientes) {
        initComponents();

        setLocationRelativeTo(null);
        setResizable(false);
        setTitle(estacionamiento.getTitulo());

        this.estacionamientos = estacionamientos;
        this.estacionamiento = estacionamiento;
        this.clientes = clientes;
        // deshabilito los campos
        deshabilitar();
        // cargo los datos
        cargarDatos();

    }

    private void cargarDatos() {
        txtNumero.setText(String.valueOf(this.estacionamiento.getNumero()));
        txtPiso.setText(String.valueOf(this.estacionamiento.getPiso()));
        txtPrecio.setText(String.valueOf(this.estacionamiento.getPrecio()));
        txtSuperficie.setText(String.valueOf(this.estacionamiento.getSuperficie()));

        comboTechado.getModel().setSelectedItem(String.valueOf(this.estacionamiento.getTechado()));
        comboTipo.getModel().setSelectedItem(String.valueOf(this.estacionamiento.getTipo()));

        txtEstado.setText(this.estacionamiento.getEstado());
        if (this.estacionamiento.getEstado().equalsIgnoreCase("disponible")) {
            txtEstado.setForeground(Color.BLUE);
            labelCliente.setVisible(false);
            labelClienteRut.setVisible(false);
            labelClienteNombre.setVisible(false);
            labelRut.setVisible(false);
            btnVender.setVisible(true);
            btnEliminarVenta.setVisible(false);
        } else {
            txtEstado.setForeground(Color.red);
            labelCliente.setVisible(true);
            labelClienteRut.setVisible(true);
            labelClienteNombre.setVisible(true);
            labelRut.setVisible(true);
            labelClienteRut.setText(this.estacionamiento.getCliente().getRut() + "-" + this.estacionamiento.getCliente().getDigVerificador());
            labelClienteNombre.setText(this.estacionamiento.getCliente().getNombre());
            btnVender.setVisible(false);
            btnEliminarVenta.setVisible(true);
        }

    }

    private void deshabilitar() {
        txtNumero.setEnabled(false);
        txtPiso.setEnabled(false);
        txtPrecio.setEnabled(false);
        txtSuperficie.setEnabled(false);
        comboTechado.setEnabled(false);
        comboTipo.setEnabled(false);

        btnEditar.setEnabled(true);
        btnEditar.setVisible(true);

        btnVender.setEnabled(true);

        btnGuardar.setEnabled(false);
        btnGuardar.setVisible(false);
    }

    private void habilitar() {
        txtNumero.setEnabled(false);
        txtPiso.setEnabled(true);
        txtPrecio.setEnabled(true);
        txtSuperficie.setEnabled(true);
        comboTechado.setEnabled(true);
        comboTipo.setEnabled(true);

        btnVender.setEnabled(false);

        btnEditar.setEnabled(false);
        btnEditar.setVisible(false);

        btnGuardar.setEnabled(true);
        btnGuardar.setVisible(true);

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
        jLabel5 = new javax.swing.JLabel();
        txtSuperficie = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboTechado = new javax.swing.JComboBox<>();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnVender = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtEstado = new javax.swing.JLabel();
        btnEliminarVenta = new javax.swing.JButton();
        labelCliente = new javax.swing.JLabel();
        labelClienteNombre = new javax.swing.JLabel();
        labelRut = new javax.swing.JLabel();
        labelClienteRut = new javax.swing.JLabel();
        jLabelMover = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrar Estacionamiento");
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(624, 358));
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
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 9, 160, -1));

        txtPiso.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtPiso.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 38, 160, -1));

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setText("Tipo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 9, 160, -1));

        comboTipo.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        comboTipo.setForeground(new java.awt.Color(0, 51, 153));
        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G" }));
        getContentPane().add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 38, 160, -1));

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setText("Superficie");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 82, 160, -1));

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 153));
        jLabel5.setText("Precio (UF)");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 82, 160, -1));

        txtSuperficie.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtSuperficie.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtSuperficie, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 111, 160, -1));

        txtPrecio.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 111, 160, -1));

        jLabel6.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 153));
        jLabel6.setText("Techado");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 82, 160, -1));

        comboTechado.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        comboTechado.setForeground(new java.awt.Color(0, 51, 153));
        comboTechado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        getContentPane().add(comboTechado, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 111, 160, -1));

        btnEditar.setBackground(new java.awt.Color(102, 204, 255));
        btnEditar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(204, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 90, -1));

        btnGuardar.setBackground(new java.awt.Color(102, 204, 255));
        btnGuardar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(204, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, -1, -1));

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 153));
        jLabel7.setText("Estado");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 155, -1, -1));

        btnVender.setBackground(new java.awt.Color(102, 204, 255));
        btnVender.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnVender.setForeground(new java.awt.Color(204, 255, 255));
        btnVender.setText("Vender");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });
        getContentPane().add(btnVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(102, 204, 255));
        btnEliminar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(204, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, -1, -1));

        txtEstado.setFont(new java.awt.Font("Cambria", 0, 36)); // NOI18N
        txtEstado.setForeground(new java.awt.Color(0, 51, 153));
        txtEstado.setText("Estado");
        getContentPane().add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 184, 200, -1));

        btnEliminarVenta.setBackground(new java.awt.Color(102, 204, 255));
        btnEliminarVenta.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnEliminarVenta.setForeground(new java.awt.Color(204, 255, 255));
        btnEliminarVenta.setText("Eliminar Venta");
        btnEliminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        labelCliente.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelCliente.setForeground(new java.awt.Color(0, 51, 153));
        labelCliente.setText("Cliente");
        getContentPane().add(labelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 60, -1));

        labelClienteNombre.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelClienteNombre.setForeground(new java.awt.Color(0, 51, 153));
        labelClienteNombre.setText("Nombre Cliente");
        getContentPane().add(labelClienteNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 540, -1));

        labelRut.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelRut.setForeground(new java.awt.Color(0, 51, 153));
        labelRut.setText("Rut");
        getContentPane().add(labelRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 45, -1));

        labelClienteRut.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelClienteRut.setForeground(new java.awt.Color(0, 51, 153));
        labelClienteRut.setText("Rut Cliente");
        getContentPane().add(labelClienteRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 540, -1));

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
        getContentPane().add(jLabelMover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 30));

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/x32-salir.png"))); // NOI18N
        jButtonSalir.setBorderPainted(false);
        jButtonSalir.setContentAreaFilled(false);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 40, -1));

        jLabelFondo.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabelFondo.setForeground(new java.awt.Color(0, 51, 153));
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        jLabelFondo.setPreferredSize(new java.awt.Dimension(624, 358));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        habilitar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String numero = txtNumero.getText();
        String superficie = txtSuperficie.getText();
        String precio = txtPrecio.getText();
        String tipo = comboTipo.getItemAt(comboTipo.getSelectedIndex());
        String piso = txtPiso.getText();
        String techado = comboTechado.getItemAt(comboTechado.getSelectedIndex());

        if (faltanDatos(superficie, precio, tipo, piso, techado)) {
            if (this.estacionamientos.editar(numero, superficie, precio, tipo, piso, techado)) {
                cargarDatos();
                deshabilitar();
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Debe ingresar todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el departamento?", "Atención", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            if (this.estacionamientos.eliminar(this.estacionamiento.getNumero())) {
                JOptionPane.showMessageDialog(new JFrame(), "Se eliminó correctamente", "Error", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "No es posible eliminar ya que está vendido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVentaActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la venta?", "Atención", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            this.estacionamiento.eliminarVenta();
            cargarDatos();
        }
    }//GEN-LAST:event_btnEliminarVentaActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        VenderInmuebleFrame frame = new VenderInmuebleFrame((Inmueble) estacionamiento, clientes);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
                cargarDatos();
            }
        });
        frame.setVisible(true);
    }//GEN-LAST:event_btnVenderActionPerformed

    private void jLabelMoverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMoverMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabelMoverMousePressed

    private void jLabelMoverMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMoverMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabelMoverMouseDragged

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    public boolean faltanDatos(String superficie, String precio, String tipo, String piso, String techado) {
        if (superficie.isEmpty()
                || precio.isEmpty()
                || tipo.isEmpty()
                || piso.isEmpty()
                || techado.isEmpty()) {
            return false;
        }
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarVenta;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVender;
    private javax.swing.JComboBox<String> comboTechado;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelMover;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelClienteNombre;
    private javax.swing.JLabel labelClienteRut;
    private javax.swing.JLabel labelRut;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPiso;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSuperficie;
    // End of variables declaration//GEN-END:variables
}
