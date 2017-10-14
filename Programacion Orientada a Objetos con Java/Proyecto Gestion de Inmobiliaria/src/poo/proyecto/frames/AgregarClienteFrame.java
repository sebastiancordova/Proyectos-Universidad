package poo.proyecto.frames;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import poo.proyecto.clases.ColeccionClientes;
import poo.proyecto.clases.ListaClientes;
import poo.proyecto.clases.RutValidoException;
import poo.proyecto.clases.UsuarioValidoException;

public class AgregarClienteFrame extends JFrame {

    private ListaClientes clientes;
    private int x, y;

    public AgregarClienteFrame(ListaClientes clientes) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.clientes = clientes;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        txtDigito = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabelMover = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Cliente");
        setUndecorated(true);
        setOpacity(0.95F);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Rut");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        txtRut.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtRut.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 170, -1));

        txtNombre.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 238, -1));

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Nombre Completo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setText("Dirección");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 230, -1));

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setText("Email");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txtEmail.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 230, -1));

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 153));
        jLabel5.setText("Telefono");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        txtTelefono.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 230, -1));

        btnAgregar.setBackground(new java.awt.Color(102, 204, 255));
        btnAgregar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(204, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 140, 30));

        txtDigito.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtDigito.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtDigito, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 42, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("-");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 20, 20));

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
        getContentPane().add(jLabelMover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 30));

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/x32-salir.png"))); // NOI18N
        jButtonSalir.setBorderPainted(false);
        jButtonSalir.setContentAreaFilled(false);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 40, 40));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String rut = txtRut.getText();
        String digVerificador = txtDigito.getText();
        String nombre = txtNombre.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();

        if (estaVacio(rut, digVerificador, nombre, direccion, telefono, email)) {
            if(nombre.charAt(0)>64 && telefono.charAt(0)<64){
            try {
                if (ListaClientes.validarRut(rut, digVerificador.charAt(0))) {
                    if (this.clientes.agregar(nombre, rut, digVerificador, direccion, telefono, email)) {
                        JOptionPane.showMessageDialog(new JFrame(), "Se agrego correctamente", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Ya existe un cliente con este rut", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (RutValidoException r) {
                JOptionPane.showMessageDialog(new JFrame(), "Debe ingresar un rut valido", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(r.getMessage());
            }
            }else
                JOptionPane.showMessageDialog(new JFrame(), "Debe ingresar un formato valido", "Error", JOptionPane.ERROR_MESSAGE);
        
            txtRut.setText("");
            txtDigito.setText("");
        }


    }//GEN-LAST:event_btnAgregarActionPerformed

    // Metodo que valida que ninguno de los campos estén vacíos
    public boolean estaVacio(String nombreCliente, String rutCliente, String digVerificador, String direccion, String telefono, String email) {

        if (nombreCliente.isEmpty()
                || rutCliente.isEmpty()
                || digVerificador.isEmpty()
                || direccion.isEmpty()
                || telefono.isEmpty()
                || email.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Debe ingresar todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
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

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelMover;
    private javax.swing.JTextField txtDigito;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRut;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
