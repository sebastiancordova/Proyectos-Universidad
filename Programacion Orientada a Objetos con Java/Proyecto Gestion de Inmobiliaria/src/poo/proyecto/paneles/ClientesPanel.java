package poo.proyecto.paneles;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import poo.proyecto.clases.Cliente;
import poo.proyecto.clases.ListaClientes;
import poo.proyecto.frames.AgregarClienteFrame;
import poo.proyecto.frames.EliminarClienteFrame;
import poo.proyecto.frames.MostrarClienteFrame;

public class ClientesPanel extends javax.swing.JPanel {

    private ListaClientes clientes;

    public ClientesPanel(ListaClientes clientes) {
        initComponents();
        this.clientes = clientes;
        jTable1.setColumnSelectionAllowed(false);
        jTable1.setRowSelectionAllowed(true);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jTable1.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting() /* El evento se llamaba dos veces */) {
                if (jTable1.getSelectedRow() == -1) {
                    return;
                }
//                Guarda el rut del cliente (incluido el dv)  en un String 
                String runCliente = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
//                Se necesita el rut sin el dv, por lo tanto se crea un 2do String a partir 
//                del anterior, desde la posicion 0 hasta la posicion donde se encuentra el guion
                String rutCliente = runCliente.substring(0, runCliente.indexOf('-'));
                System.out.println(rutCliente);
//                Busco el cliente
                Cliente clienteSeleccionado = this.clientes.buscarPorRut(rutCliente);
//                Si es que existe el cliente lo muestro,
//                Sino, muestro un error
                if (clienteSeleccionado != null) {
                    MostrarClienteFrame frame = new MostrarClienteFrame(clientes, clienteSeleccionado);
                    frame.addWindowListener(new WindowListener() {
                        public void windowOpened(WindowEvent e) {
                        }

                        public void windowClosing(WindowEvent e) {
                        }

                        public void windowIconified(WindowEvent e) {
                        }

                        public void windowDeiconified(WindowEvent e) {
                        }

                        public void windowActivated(WindowEvent e) {
                        }

                        public void windowDeactivated(WindowEvent e) {
                        }

                        @Override
                        public void windowClosed(WindowEvent e) {
                            actualizarTabla();
                        }
                    });
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "No existe el Cliente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        actualizarTabla();
    }

    private void actualizarTabla() {
        jTable1.setModel(new DefaultTableModel(this.clientes.getModelData(), new String[]{"Nombre", "Rut", "Dirección", "Teléfono", "Email"}) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEliminarCliente = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregarCliente.setBackground(new java.awt.Color(120, 204, 255));
        btnAgregarCliente.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnAgregarCliente.setForeground(new java.awt.Color(204, 255, 255));
        btnAgregarCliente.setText("Agregar Cliente");
        btnAgregarCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });
        add(btnAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 30));

        jTable1.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 51, 153));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Rut", "Dirección", "Teléfono", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Nombre");
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Rut");
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Dirección");
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Teléfono");
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Email");
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 790, 270));

        btnEliminarCliente.setBackground(new java.awt.Color(120, 204, 255));
        btnEliminarCliente.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnEliminarCliente.setForeground(new java.awt.Color(204, 255, 255));
        btnEliminarCliente.setText("Eliminar Cliente");
        btnEliminarCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });
        add(btnEliminarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 150, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 370));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        AgregarClienteFrame frame = new AgregarClienteFrame(this.clientes);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
                actualizarTabla();
            }
        });
        frame.setVisible(true);
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        EliminarClienteFrame frame = new EliminarClienteFrame(this.clientes);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
                actualizarTabla();
            }
        });
        frame.setVisible(true);
    }//GEN-LAST:event_btnEliminarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
