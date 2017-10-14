package poo.proyecto.paneles;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import poo.proyecto.clases.ListaClientes;
import poo.proyecto.frames.AgregarProyectoFrame;
import poo.proyecto.clases.Proyecto;
import poo.proyecto.clases.ListaProyecto;
import poo.proyecto.frames.MostrarProyectoFrame;

public class ProyectosPanel extends JPanel {
    
    private ListaProyecto proyectos;
    private ListaClientes clientes;
    
    public ProyectosPanel(ListaProyecto proyectos, ListaClientes clientes) {
        initComponents();
        
        this.proyectos = proyectos;
        this.clientes = clientes;
        
        jTable.setColumnSelectionAllowed(false);
        jTable.setRowSelectionAllowed(true);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jTable.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if(!e.getValueIsAdjusting() /* El evento se llamaba dos veces */) {
                if (jTable.getSelectedRow() == -1)
                    return;
                
                String nombreProyecto = jTable.getValueAt(jTable.getSelectedRow(), 0).toString();
                System.out.println(nombreProyecto);
                // Busco el proyecto
                Proyecto proyectoSeleccionado = this.proyectos.buscarPorNombre(nombreProyecto);
                // Si es que existe el proyecto lo muestro,
                // Sino, muestro un error
                if (proyectoSeleccionado != null){
                    MostrarProyectoFrame frame = new MostrarProyectoFrame(proyectoSeleccionado, this.proyectos, this.clientes);
                    frame.addWindowListener(new WindowListener() {
                        @Override
                        public void windowOpened(WindowEvent e) {}
                        @Override
                        public void windowClosing(WindowEvent e){}
                        @Override
                        public void windowIconified(WindowEvent e){}
                        @Override
                        public void windowDeiconified(WindowEvent e){}
                        @Override
                        public void windowActivated(WindowEvent e){}
                        @Override
                        public void windowDeactivated(WindowEvent e){}
                        @Override
                        public void windowClosed(WindowEvent e) {
                            actualizarTabla();
                        }
                    });
                    frame.setVisible(true);
                } else
                    JOptionPane.showMessageDialog(new JFrame(), "No existe el Proyecto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        actualizarTabla();
    }
    
    private void actualizarTabla() 
    {
        jTable.setModel(new DefaultTableModel(this.proyectos.getModelData(), new String [] { "Proyecto", "Etapa", "Dirección", "Región", "N° Departamentos", "N° Bodegas", "N° Estacionamientos"})
        {
            @Override
            public boolean isCellEditable(int row, int col) 
            {
                return false;
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregarProyecto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabelFondo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(753, 404));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregarProyecto.setBackground(new java.awt.Color(102, 204, 255));
        btnAgregarProyecto.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnAgregarProyecto.setForeground(new java.awt.Color(204, 255, 255));
        btnAgregarProyecto.setText("Agregar Proyecto");
        btnAgregarProyecto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAgregarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProyectoActionPerformed(evt);
            }
        });
        add(btnAgregarProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 30));

        jTable.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jTable.setForeground(new java.awt.Color(0, 51, 153));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Proyecto", "Etapa", "N° Departamentos", "Eliminar", "Mostrar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setColumnSelectionAllowed(true);
        jTable.setGridColor(new java.awt.Color(0, 153, 153));
        jTable.setSelectionBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setViewportView(jTable);
        jTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setResizable(false);
            jTable.getColumnModel().getColumn(1).setResizable(false);
            jTable.getColumnModel().getColumn(2).setResizable(false);
            jTable.getColumnModel().getColumn(3).setResizable(false);
            jTable.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 790, 270));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        jLabelFondo.setRequestFocusEnabled(false);
        add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 350));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProyectoActionPerformed
        AgregarProyectoFrame frame = new AgregarProyectoFrame(this.proyectos);
        frame.addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent e) {}
            public void windowClosing(WindowEvent e){}
            public void windowIconified(WindowEvent e){}
            public void windowDeiconified(WindowEvent e){}
            public void windowActivated(WindowEvent e){}
            public void windowDeactivated(WindowEvent e){}
            @Override
            public void windowClosed(WindowEvent e) {
                actualizarTabla();
            }
        });
        frame.setVisible(true);
    }//GEN-LAST:event_btnAgregarProyectoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProyecto;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
