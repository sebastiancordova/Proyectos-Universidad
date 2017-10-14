package poo.proyecto.frames;

import poo.proyecto.clases.ListaDepartamento;

public class DescuentoDepartamentoFrame extends javax.swing.JFrame {

    private ListaDepartamento departamentos;
    public int x,y;
    
    public DescuentoDepartamentoFrame(ListaDepartamento departamentos) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.departamentos = departamentos;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtDescuento = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aplicar Descuento Masivo Departamentos");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("% Descuento");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
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
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 440, 30));

        jButton1.setBackground(new java.awt.Color(102, 204, 255));
        jButton1.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 255, 255));
        jButton1.setText("Aplicar Descuento");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 170, -1));

        txtDescuento.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtDescuento.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 40, 140, -1));

        jButtonCancelar.setBackground(new java.awt.Color(102, 204, 255));
        jButtonCancelar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(204, 255, 255));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 110, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        jLabelFondo.setPreferredSize(new java.awt.Dimension(467, 104));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.departamentos.aplicarDescuentoMasivo(txtDescuento.getText())) {
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JTextField txtDescuento;
    // End of variables declaration//GEN-END:variables
}
