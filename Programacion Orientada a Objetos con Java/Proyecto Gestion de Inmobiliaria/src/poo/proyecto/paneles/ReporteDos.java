package poo.proyecto.paneles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import poo.proyecto.clases.Departamento;
import poo.proyecto.clases.Proyecto;
import poo.proyecto.clases.ListaProyecto;

public class ReporteDos extends javax.swing.JPanel {

    private ListaProyecto proyectos;

    public ReporteDos(ListaProyecto proyectos) {
        initComponents();
        this.proyectos = proyectos;

        iniciarCombo();
    }

    private void iniciarCombo() {

        String[] opciones = new String[this.proyectos.getCantidad()];
        int cont = 0;

        for (int i = 0; i < this.proyectos.getCantidad(); i++) {
            opciones[cont] = this.proyectos.getNombreProyecto(cont);
            cont++;
        }
        comboProyecto.setModel(new javax.swing.DefaultComboBoxModel<>(opciones));
    }

    private void mostrarReporte() {
        txtOutput.setText("");
        String nombreProyecto = comboProyecto.getItemAt(comboProyecto.getSelectedIndex());
        Proyecto proyecto = proyectos.buscar(nombreProyecto);
        ArrayList<Departamento> departamentos = proyecto.getDepartamentosConSubsidio();
        String msg = "Los departamentos que aplican al Subsidio y que actualmente están disponibles son: \n\n";
        msg += "Para el Proyecto: " + proyecto.getNombre() + "\n";

        if (departamentos.size() == 0) {
            msg += "No hay departamentos\n";
        } else {
            for (Departamento dep : departamentos) {
                msg += " - Departamento N° " + dep.getNumero() + ",  N° Baños : " + dep.getNumeroBanos() + ", N° Dormitorios: " + dep.getNumeroDormitorios() + "\n";
            }
        }
        txtOutput.setText(msg);

        // Escribo el archivo
        PrintStream fileStream;
        try {
            fileStream = new PrintStream(new File("reporte2.txt"));
            fileStream.println("Los departamentos que aplican al Subsidio y que actualmente están disponibles son:");
            fileStream.println("Para el Proyecto: " + proyecto.getNombre() + "");
            if (departamentos.size() == 0) {
                fileStream.println("No hay departamentos");
            } else {
                for (Departamento dep : departamentos) {
                    fileStream.println(" - Departamento N° " + dep.getNumero() + ",  N° Baños : " + dep.getNumeroBanos() + ", N° Dormitorios: " + dep.getNumeroDormitorios() + "");
                }
            }
            fileStream.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "No se puede escribir el archivo de reportes", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        comboProyecto = new javax.swing.JComboBox<>();
        btnGenerar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(860, 370));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Departamentos con Subsidio");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 21, 850, 30));

        txtOutput.setColumns(20);
        txtOutput.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtOutput.setForeground(new java.awt.Color(0, 51, 102));
        txtOutput.setRows(5);
        txtOutput.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 255), new java.awt.Color(0, 51, 204)));
        jScrollPane1.setViewportView(txtOutput);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 820, 230));

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Seleccionar Proyecto");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        comboProyecto.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        comboProyecto.setForeground(new java.awt.Color(51, 0, 153));
        comboProyecto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(comboProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 199, -1));

        btnGenerar.setBackground(new java.awt.Color(102, 204, 255));
        btnGenerar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnGenerar.setForeground(new java.awt.Color(204, 255, 255));
        btnGenerar.setText("Generar");
        btnGenerar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 90, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 0, 1360, 680));
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        mostrarReporte();
    }//GEN-LAST:event_btnGenerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox<String> comboProyecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtOutput;
    // End of variables declaration//GEN-END:variables
}
