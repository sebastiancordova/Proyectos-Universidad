package poo.proyecto.paneles;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import poo.proyecto.clases.ListaClientes;
import poo.proyecto.clases.Estacionamiento;
import poo.proyecto.clases.ListaEstacionamiento;
import poo.proyecto.clases.Inmueble;
import poo.proyecto.frames.AgregarEstacionamientoFrame;
import poo.proyecto.frames.MostrarEstacionamientoFrame;

public class EstacionamientosPanel extends JPanel {

    private ListaEstacionamiento estacionamientos;
    private ListaClientes clientes;
    
    public EstacionamientosPanel(ListaEstacionamiento estacionamientos, ListaClientes clientes) {
        initComponents();
        this.estacionamientos = estacionamientos;
        this.clientes = clientes;
        
        jTable.setColumnSelectionAllowed(false);
        jTable.setRowSelectionAllowed(true);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jTable.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if(!e.getValueIsAdjusting() /* El evento se llamaba dos veces */) {
                if (jTable.getSelectedRow() == -1)
                    return;
                
                String numeroDepartamento = jTable.getValueAt(jTable.getSelectedRow(), 0).toString();
                System.out.println(numeroDepartamento);
                // Busco el proyecto
                Estacionamiento estacionamientoSeleccionado = (Estacionamiento) this.estacionamientos.buscarPorNumero(Integer.parseInt(numeroDepartamento));
                // Si es que existe el proyecto lo muestro,
                // Sino, muestro un error
                if (estacionamientoSeleccionado != null){
                    MostrarEstacionamientoFrame frame = new MostrarEstacionamientoFrame(estacionamientoSeleccionado, this.estacionamientos, this.clientes);
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
                    JOptionPane.showMessageDialog(new JFrame(), "No existe el Estacionamiento", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        actualizarTabla();
    }
    
    private void actualizarTabla() {
        jTable.setModel(new DefaultTableModel(this.estacionamientos.getModelData(), new String [] { "Número", "Piso", "Precio", "Estado", "Superficie", "Techado"}){
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregarEstacionamiento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabelFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregarEstacionamiento.setBackground(new java.awt.Color(120, 204, 255));
        btnAgregarEstacionamiento.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnAgregarEstacionamiento.setForeground(new java.awt.Color(204, 255, 255));
        btnAgregarEstacionamiento.setText("Agregar Estacionamiento");
        btnAgregarEstacionamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEstacionamientoActionPerformed(evt);
            }
        });
        add(btnAgregarEstacionamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 9, -1, -1));

        jTable.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jTable.setForeground(new java.awt.Color(0, 51, 153));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 47, 870, 233));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        jLabelFondo.setPreferredSize(new java.awt.Dimension(906, 296));
        add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarEstacionamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEstacionamientoActionPerformed
        AgregarEstacionamientoFrame frame = new AgregarEstacionamientoFrame(this.estacionamientos);
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
    }//GEN-LAST:event_btnAgregarEstacionamientoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEstacionamiento;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
