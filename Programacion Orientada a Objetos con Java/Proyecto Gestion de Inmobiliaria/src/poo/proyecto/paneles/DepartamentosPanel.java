package poo.proyecto.paneles;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import poo.proyecto.clases.ListaClientes;
import poo.proyecto.clases.Departamento;
import poo.proyecto.clases.ListaDepartamento;
import poo.proyecto.clases.Inmueble;
import poo.proyecto.frames.AgregarDepartamentoFrame;
import poo.proyecto.frames.DescuentoDepartamentoFrame;
import poo.proyecto.frames.MostrarDepartamentoFrame;

public class DepartamentosPanel extends javax.swing.JPanel {
    
    private ListaDepartamento departamentos;
    private ListaClientes clientes;
    
    public DepartamentosPanel(ListaDepartamento departamentos, ListaClientes clientes) {
        initComponents();
        this.departamentos = departamentos;
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
                Departamento departamentoSeleccionado = (Departamento) this.departamentos.buscarPorNumero(Integer.parseInt(numeroDepartamento));
                // Si es que existe el proyecto lo muestro,
                // Sino, muestro un error
                if (departamentoSeleccionado != null){
                    MostrarDepartamentoFrame frame = new MostrarDepartamentoFrame(departamentoSeleccionado, this.departamentos, this.clientes);
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
                    JOptionPane.showMessageDialog(new JFrame(), "No existe el Departamento", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        actualizarTabla();
    }
    
    private void actualizarTabla() {
        jTable.setModel(new DefaultTableModel(this.departamentos.getModelData(), new String [] { "Número", "Piso", "Precio", "Estado", "Superficie", "N° Dormitorios", "N° Baños", "Tipo Cocina"}){
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        btnAgregarDepartamento = new javax.swing.JButton();
        btnDescuento = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 47, 870, 230));

        btnAgregarDepartamento.setBackground(new java.awt.Color(120, 204, 255));
        btnAgregarDepartamento.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnAgregarDepartamento.setForeground(new java.awt.Color(204, 255, 255));
        btnAgregarDepartamento.setText("Agregar Departamento");
        btnAgregarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDepartamentoActionPerformed(evt);
            }
        });
        add(btnAgregarDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 9, -1, -1));

        btnDescuento.setBackground(new java.awt.Color(120, 204, 255));
        btnDescuento.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnDescuento.setForeground(new java.awt.Color(204, 255, 255));
        btnDescuento.setText("Aplicar Descuento Masivo");
        btnDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescuentoActionPerformed(evt);
            }
        });
        add(btnDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        jLabelFondo.setPreferredSize(new java.awt.Dimension(700, 1600));
        add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 300));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDepartamentoActionPerformed
        AgregarDepartamentoFrame frame = new AgregarDepartamentoFrame(this.departamentos);
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
    }//GEN-LAST:event_btnAgregarDepartamentoActionPerformed

    private void btnDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescuentoActionPerformed
        DescuentoDepartamentoFrame frame = new DescuentoDepartamentoFrame(this.departamentos);
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
    }//GEN-LAST:event_btnDescuentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarDepartamento;
    private javax.swing.JButton btnDescuento;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
