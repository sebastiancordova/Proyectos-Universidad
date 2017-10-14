package poo.proyecto;

import poo.proyecto.clases.ListaClientes;
import poo.proyecto.clases.ListaProyecto;
import poo.proyecto.paneles.ClientesPanel;
import poo.proyecto.paneles.ProyectosPanel;
import poo.proyecto.paneles.ReporteDos;
import poo.proyecto.paneles.ReportesPanel;

public class VentanaPrincipal extends javax.swing.JFrame {

    private ListaProyecto proyectos;
    private ListaClientes clientes;
    public int x,y;

    public VentanaPrincipal(ListaClientes clientes,ListaProyecto proyectos){
        initComponents();
        setLocationRelativeTo(null);

        this.proyectos = proyectos;
        this.clientes = clientes;
        
        cargarBaseDeDatos(); // Cargamos con datos aleatorios

        // Paneles 1er Nivel
        // ListaProyecto
        ProyectosPanel proyectosPanel = new ProyectosPanel(proyectos, clientes);
        // ListaClientes
        ClientesPanel clientesPanel = new ClientesPanel(clientes);
        // Reportes
        ReportesPanel reportesPanel = new ReportesPanel(proyectos);
        ReporteDos reporteDos = new ReporteDos(proyectos);

        tab.addTab("Proyectos", proyectosPanel);
        tab.addTab("Clientes", clientesPanel);
        tab.addTab("Reporte 1", reportesPanel);
        tab.addTab("Reporte 2", reporteDos);
    }

    private void cargarBaseDeDatos()  {
        
        clientes.cargarDatos();
        proyectos.cargarDatos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        tab = new javax.swing.JTabbedPane();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/x32-salir.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 40, 40));

        jLabelTitulo.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 51, 153));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Sistema de Gestión Inmobiliaria");
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
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 810, 70));
        getContentPane().add(tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 840, 380));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 891, 475));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clientes.guardarDatos();
        proyectos.guardarDatos();
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabelTituloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTituloMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabelTituloMouseDragged

    private void jLabelTituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTituloMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabelTituloMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JTabbedPane tab;
    // End of variables declaration//GEN-END:variables

}
