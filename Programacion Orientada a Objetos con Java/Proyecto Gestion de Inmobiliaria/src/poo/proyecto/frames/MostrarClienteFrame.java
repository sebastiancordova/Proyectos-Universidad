package poo.proyecto.frames;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import poo.proyecto.clases.Cliente;
import poo.proyecto.clases.ListaClientes;
import poo.proyecto.clases.RutValidoException;

public class MostrarClienteFrame extends javax.swing.JFrame {

    private ListaClientes clientes;
    private Cliente cliente;
    public int x, y;

    public MostrarClienteFrame(ListaClientes clientes, Cliente cliente) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.cliente = cliente;
        this.clientes = clientes;

        cargarDatosCliente();
        nombreCliente.setEnabled(false);
        rutCliente.setEnabled(false);
        digVerificador.setEnabled(false);
        direccionCliente.setEnabled(false);
        fonoCliente.setEnabled(false);
        mailCliente.setEnabled(false);
        btnGuardar.setVisible(false);
    }

    private void cargarDatosCliente() {
        nombreCliente.setText(this.cliente.getNombre());
        rutCliente.setText(this.cliente.getRut());
        digVerificador.setText(this.cliente.getDigVerificador());
        direccionCliente.setText(this.cliente.getDireccion());
        fonoCliente.setText(this.cliente.getTelefono());
        mailCliente.setText(this.cliente.getEmail());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rutCliente = new javax.swing.JTextField();
        direccionCliente = new javax.swing.JTextField();
        fonoCliente = new javax.swing.JTextField();
        mailCliente = new javax.swing.JTextField();
        nombreCliente = new javax.swing.JTextField();
        jLabelTitulo = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        digVerificador = new javax.swing.JTextField();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrar Cliente");
        setUndecorated(true);
        setOpacity(0.95F);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Rut:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 70, 30));

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Direccion:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, 30));

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setText("Telefono:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 70, 30));

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setText("Email:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 70, 30));

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 153));
        jLabel5.setText("Nombre:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 70, 30));

        rutCliente.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        rutCliente.setForeground(new java.awt.Color(0, 0, 102));
        rutCliente.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(rutCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 300, -1));

        direccionCliente.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        direccionCliente.setForeground(new java.awt.Color(0, 0, 102));
        getContentPane().add(direccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 350, -1));

        fonoCliente.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        fonoCliente.setForeground(new java.awt.Color(0, 0, 102));
        getContentPane().add(fonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 350, -1));

        mailCliente.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        mailCliente.setForeground(new java.awt.Color(0, 0, 102));
        getContentPane().add(mailCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 350, -1));

        nombreCliente.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        nombreCliente.setForeground(new java.awt.Color(0, 0, 102));
        getContentPane().add(nombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 350, -1));

        jLabelTitulo.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 51, 153));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Datos Cliente");
        jLabelTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelTitulo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabelTituloMouseDragged(evt);
            }
        });
        jLabelTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelTituloMousePressed(evt);
            }
        });
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 400, 30));

        btnEditar.setBackground(new java.awt.Color(102, 204, 255));
        btnEditar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(204, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 100, -1));

        btnGuardar.setBackground(new java.awt.Color(102, 204, 255));
        btnGuardar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(204, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 101, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("-");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 20, 10));

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/x32-salir.png"))); // NOI18N
        jButtonSalir.setBorderPainted(false);
        jButtonSalir.setContentAreaFilled(false);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 40, 40));

        digVerificador.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        digVerificador.setForeground(new java.awt.Color(0, 0, 102));
        getContentPane().add(digVerificador, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 30, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 513, 317));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        nombreCliente.setEnabled(true);
        rutCliente.setEnabled(true);
        digVerificador.setEnabled(true);
        direccionCliente.setEnabled(true);
        fonoCliente.setEnabled(true);
        mailCliente.setEnabled(true);
        btnEditar.setVisible(false);
        btnGuardar.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombre = nombreCliente.getText();
        String rut = rutCliente.getText();
        String dig = digVerificador.getText();
        String direccion = direccionCliente.getText();
        String fono = fonoCliente.getText();
        String mail = mailCliente.getText();

        if (faltanDatos(nombre, rut, dig, direccion, fono, mail)) {
            try {
                if (ListaClientes.validarRut(rut, dig.charAt(0))) {
                    if (clientes.editar(nombre, rut, dig, direccion, fono, mail)) {
                        nombreCliente.setEnabled(false);
                        rutCliente.setEnabled(false);
                        digVerificador.setEnabled(false);
                        direccionCliente.setEnabled(false);
                        fonoCliente.setEnabled(false);
                        mailCliente.setEnabled(false);
                        btnEditar.setVisible(true);
                        btnGuardar.setVisible(false);
                    }
                }
            } catch (RutValidoException r) {
                JOptionPane.showMessageDialog(new JFrame(), "Debe ingresar un rut valido", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(r.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Debe ingresar todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jLabelTituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTituloMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabelTituloMousePressed

    private void jLabelTituloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTituloMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabelTituloMouseDragged

    public boolean faltanDatos(String nombreCliente, String rutCliente, String digVerificador, String direccion, String telefono, String email) {

        if (nombreCliente.isEmpty()
                || rutCliente.isEmpty()
                || digVerificador.isEmpty()
                || direccion.isEmpty()
                || telefono.isEmpty()
                || email.isEmpty()) {
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField digVerificador;
    private javax.swing.JTextField direccionCliente;
    private javax.swing.JTextField fonoCliente;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JTextField mailCliente;
    private javax.swing.JTextField nombreCliente;
    private javax.swing.JTextField rutCliente;
    // End of variables declaration//GEN-END:variables
}
