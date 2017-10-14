package poo.proyecto.frames;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import poo.proyecto.clases.ListaClientes;

public class EliminarClienteFrame extends JFrame {
    
    private ListaClientes clientes;
    public int x,y;
    
    public EliminarClienteFrame(ListaClientes clientes) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.clientes = clientes;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminar = new javax.swing.JButton();
        rutCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar Cliente");
        setUndecorated(true);
        setOpacity(0.95F);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setBackground(new java.awt.Color(102, 204, 255));
        btnEliminar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(204, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 80, 30));

        rutCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutClienteActionPerformed(evt);
            }
        });
        getContentPane().add(rutCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 180, 30));

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Ingrese Rut del cliente (sin dv):");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 370, 40));

        btnCancelar.setBackground(new java.awt.Color(102, 204, 255));
        btnCancelar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(204, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 80, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String rut = rutCliente.getText();
        if (this.clientes.eliminar(rut)) {
            dispose();
        } else{
            JOptionPane.showMessageDialog(new JFrame(), "No existe un cliente con este rut", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void rutClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rutClienteActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabel1MouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JTextField rutCliente;
    // End of variables declaration//GEN-END:variables
}
