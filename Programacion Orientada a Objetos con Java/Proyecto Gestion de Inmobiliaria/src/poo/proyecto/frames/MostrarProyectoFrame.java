package poo.proyecto.frames;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import poo.proyecto.clases.ListaClientes;
import poo.proyecto.clases.Proyecto;
import poo.proyecto.clases.ListaProyecto;
import poo.proyecto.paneles.BodegasPanel;
import poo.proyecto.paneles.DepartamentosPanel;
import poo.proyecto.paneles.EstacionamientosPanel;

public class MostrarProyectoFrame extends javax.swing.JFrame {

    private ListaClientes clientes;
    private Proyecto proyecto;
    private ListaProyecto proyectos;
    private DepartamentosPanel departamentosPanel;
    private BodegasPanel bodegasPanel;
    private EstacionamientosPanel estacionamientosPanel;
    public int x, y;

    public MostrarProyectoFrame(Proyecto proyecto, ListaProyecto proyectos, ListaClientes clientes) {
        initComponents();
        setLocationRelativeTo(null);
        this.proyecto = proyecto;
        this.proyectos = proyectos;
        this.clientes = clientes;

        // Paneles
        departamentosPanel = new DepartamentosPanel(this.proyecto.getDepartamentos(), this.clientes);
        bodegasPanel = new BodegasPanel(this.proyecto.getBodegas());
        estacionamientosPanel = new EstacionamientosPanel(this.proyecto.getEstacionamientos(), this.clientes);

        tab.addTab("Departamentos", departamentosPanel);
        tab.addTab("Bodegas", bodegasPanel);
        tab.addTab("Estacionamientos", estacionamientosPanel);

        cargarDatosProyecto();

        selectRegion.setEnabled(false);
        txtDireccion.setEnabled(false);
        selectEtapa.setEnabled(false);
        btnGuardar.setVisible(false);
    }

    private void cargarDatosProyecto() {
        tituloProyecto.setText(this.proyecto.getNombre());
        txtDireccion.setText(this.proyecto.getDireccion());
        selectEtapa.getModel().setSelectedItem(this.proyecto.getEtapa());
        selectRegion.getModel().setSelectedItem(this.proyecto.getRegion());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        selectRegion = new javax.swing.JComboBox<>();
        selectEtapa = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        tituloProyecto = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrar Proyecto");
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 161, 910, 310));

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Etapa");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Región");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setText("Dirección");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 191, -1));

        btnEditar.setBackground(new java.awt.Color(102, 204, 255));
        btnEditar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(204, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 90, -1));

        btnGuardar.setBackground(new java.awt.Color(102, 204, 255));
        btnGuardar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(204, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));

        selectRegion.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        selectRegion.setForeground(new java.awt.Color(0, 51, 153));
        selectRegion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I Región", "II Región", "III Región", "IV Región", "V Región", "VI Región", "VII Región", "VIII Región", "IX Región", "X Región", "XI Región", "XII Región", "XIII Región", "", "XIV Región", "Región Metropolitana" }));
        getContentPane().add(selectRegion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 191, 28));

        selectEtapa.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        selectEtapa.setForeground(new java.awt.Color(0, 51, 153));
        selectEtapa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En Verde", "Entrega Inmediata", "En Blanco" }));
        getContentPane().add(selectEtapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 31, 191, -1));

        btnEliminar.setBackground(new java.awt.Color(102, 204, 255));
        btnEliminar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(204, 255, 255));
        btnEliminar.setText("Eliminar Proyecto");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 170, -1));

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/x32-salir.png"))); // NOI18N
        jButtonSalir.setBorderPainted(false);
        jButtonSalir.setContentAreaFilled(false);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 40, 40));

        tituloProyecto.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        tituloProyecto.setForeground(new java.awt.Color(0, 51, 153));
        tituloProyecto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloProyecto.setText("Título Proyecto");
        tituloProyecto.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tituloProyectoMouseDragged(evt);
            }
        });
        tituloProyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tituloProyectoMousePressed(evt);
            }
        });
        getContentPane().add(tituloProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 850, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        jLabelFondo.setPreferredSize(new java.awt.Dimension(952, 499));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        tituloProyecto.setVisible(false);
        txtDireccion.setEnabled(true);
        selectEtapa.setEnabled(true);
        selectRegion.setEnabled(true);
        btnEditar.setVisible(false);
        btnGuardar.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        String nombreBuscar = tituloProyecto.getText();
        String direccion = txtDireccion.getText();
        String etapa = selectEtapa.getItemAt(selectEtapa.getSelectedIndex());
        String region = selectRegion.getItemAt(selectRegion.getSelectedIndex());

            if (this.proyectos.editar(nombreBuscar, etapa, direccion, region)) {
                cargarDatosProyecto();
                txtDireccion.setEnabled(false);
                selectEtapa.setEnabled(false);
                selectRegion.setEnabled(false);
                btnEditar.setVisible(true);
                btnGuardar.setVisible(false);
                tituloProyecto.setVisible(true);
            }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el proyecto?", "Atención", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            if (this.proyectos.eliminar(this.proyecto.getNombre())) {
                dispose();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void tituloProyectoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tituloProyectoMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_tituloProyectoMousePressed

    private void tituloProyectoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tituloProyectoMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_tituloProyectoMouseDragged

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JComboBox<String> selectEtapa;
    private javax.swing.JComboBox<String> selectRegion;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JLabel tituloProyecto;
    private javax.swing.JTextField txtDireccion;
    // End of variables declaration//GEN-END:variables
}
