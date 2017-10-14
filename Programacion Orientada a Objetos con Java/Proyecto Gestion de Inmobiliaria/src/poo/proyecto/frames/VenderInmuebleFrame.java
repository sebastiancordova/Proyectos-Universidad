package poo.proyecto.frames;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import poo.proyecto.clases.Cliente;
import poo.proyecto.clases.ListaClientes;
import poo.proyecto.clases.Inmueble;
import poo.proyecto.clases.Mediator;

public class VenderInmuebleFrame extends javax.swing.JFrame {

    private Inmueble inmueble;
    private ListaClientes clientes;
    public int x,y;
    
    public VenderInmuebleFrame(Inmueble inmueble, ListaClientes clientes) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.inmueble = inmueble;
        this.clientes = clientes;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtRut = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vender");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Ingresar Rut Cliente (Sin DV)");
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 9, 350, -1));

        btnGuardar.setBackground(new java.awt.Color(102, 204, 255));
        btnGuardar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(204, 255, 255));
        btnGuardar.setText("Vender");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        txtRut.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtRut.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 39, 340, -1));

        jButtonCancelar.setBackground(new java.awt.Color(102, 204, 255));
        jButtonCancelar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(204, 255, 255));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        jLabelFondo.setPreferredSize(new java.awt.Dimension(373, 121));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Cliente cliente = this.clientes.buscarPorRut(txtRut.getText());
        
        if (cliente == null) {
            JOptionPane.showMessageDialog(new JFrame(), "No existe el cliente", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            Mediator mediador = new Mediator();
            mediador.setCliente(cliente);
            mediador.setInmueble(inmueble);
            if (mediador.vender()){
                JOptionPane.showMessageDialog(new JFrame(), "Se vendió a "+cliente.getNombre(), "Exito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else
                JOptionPane.showMessageDialog(new JFrame(), "El inmueble ya no está disponible", "Error", JOptionPane.ERROR_MESSAGE);
        } 

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabel1MouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
}
