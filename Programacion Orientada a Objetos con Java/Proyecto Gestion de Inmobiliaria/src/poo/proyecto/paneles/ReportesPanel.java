package poo.proyecto.paneles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import poo.proyecto.clases.ListaProyecto;
import poo.proyecto.clases.Proyecto;

public class ReportesPanel extends javax.swing.JPanel {

    private ListaProyecto proyectos;
    
    public ReportesPanel(ListaProyecto proyectos) {
        initComponents();
        this.proyectos = proyectos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProyectoConMasDepartamentosVendidos = new javax.swing.JButton();
        comboRegion = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReporte = new javax.swing.JTextArea();
        jLabelFondo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(767, 767));
        setPreferredSize(new java.awt.Dimension(860, 370));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProyectoConMasDepartamentosVendidos.setBackground(new java.awt.Color(102, 204, 255));
        btnProyectoConMasDepartamentosVendidos.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnProyectoConMasDepartamentosVendidos.setForeground(new java.awt.Color(204, 255, 255));
        btnProyectoConMasDepartamentosVendidos.setText("Generar");
        btnProyectoConMasDepartamentosVendidos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnProyectoConMasDepartamentosVendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProyectoConMasDepartamentosVendidosActionPerformed(evt);
            }
        });
        add(btnProyectoConMasDepartamentosVendidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 90, 30));

        comboRegion.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        comboRegion.setForeground(new java.awt.Color(51, 0, 153));
        comboRegion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "I Región", "II Región", "III Región", "IV Región", "V Región", "VI Región", "VII Región", "VIII Región", "IX Región", "X Región", "XI Región", "XII Región", "XIII Región", "", "XIV Región", "Región Metropolitana" }));
        add(comboRegion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 200, -1));

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Proyectos con más departamentos vendidos");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 860, -1));

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Seleccionar Region");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        txtReporte.setEditable(false);
        txtReporte.setColumns(20);
        txtReporte.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtReporte.setForeground(new java.awt.Color(0, 51, 102));
        txtReporte.setRows(5);
        txtReporte.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 255), new java.awt.Color(0, 51, 204)));
        txtReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(txtReporte);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 820, 230));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        jLabelFondo.setPreferredSize(new java.awt.Dimension(499, 245));
        add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 370));
    }// </editor-fold>//GEN-END:initComponents

    private void btnProyectoConMasDepartamentosVendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProyectoConMasDepartamentosVendidosActionPerformed
        String filtroRegion = comboRegion.getItemAt(comboRegion.getSelectedIndex());
        
        if (filtroRegion.equalsIgnoreCase("Todos")) {
            Proyecto proyecto = this.proyectos.masDepartamentosVendidos();
            if (proyecto == null) {
                JOptionPane.showMessageDialog(new JFrame(), "No se han registrado ventas en los departamentos", "Error", JOptionPane.ERROR_MESSAGE);
                txtReporte.setText("");
            }else{
                String msg = "El proyecto con más departamentos vendidos es: \n\n";
                msg += proyecto.getNombre() + "\n";
                msg += proyecto.getEtapa()+ "\n";
                msg += proyecto.getDireccion()+ "\n";
                msg += proyecto.getRegion()+ "\n\n";
                msg += "Posee " + proyecto.getCantidadDepartamentosVendidos() + " Departamentos vendidos de un total de " + proyecto.getCantidadDepartamentos();
                txtReporte.setText(msg);
                
                PrintStream fileStream;
                try {
                    fileStream = new PrintStream(new File("reporte.txt"));
                    fileStream.println("El proyecto con más departamentos vendidos es:");                
                    fileStream.println(proyecto.getNombre());                
                    fileStream.println(proyecto.getEtapa());                
                    fileStream.println(proyecto.getDireccion());                
                    fileStream.println(proyecto.getRegion());                
                    fileStream.println("Posee " + proyecto.getCantidadDepartamentosVendidos() + " Departamentos vendidos de un total de " + proyecto.getCantidadDepartamentos());
                    fileStream.close();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "No se puede escribir el archivo de reportes", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else {
            Proyecto proyecto = this.proyectos.masDepartamentosVendidos(filtroRegion);
            if (proyecto == null) {
                JOptionPane.showMessageDialog(new JFrame(), "No se han registrado ventas en los departamentos para esta region", "Error", JOptionPane.ERROR_MESSAGE);
                txtReporte.setText("");
            }else{
                String msg = "El proyecto con más departamentos en vendidos es: \n\n";
                msg += proyecto.getNombre() + "\n";
                msg += proyecto.getEtapa()+ "\n";
                msg += proyecto.getDireccion()+ "\n";
                msg += proyecto.getRegion()+ "\n\n";
                msg += "Posee " + proyecto.getCantidadDepartamentosVendidos() + " Departamentos vendidos de un total de " + proyecto.getCantidadDepartamentos();
                txtReporte.setText(msg);
            }
        }
        
    }//GEN-LAST:event_btnProyectoConMasDepartamentosVendidosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProyectoConMasDepartamentosVendidos;
    private javax.swing.JComboBox<String> comboRegion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtReporte;
    // End of variables declaration//GEN-END:variables
}
