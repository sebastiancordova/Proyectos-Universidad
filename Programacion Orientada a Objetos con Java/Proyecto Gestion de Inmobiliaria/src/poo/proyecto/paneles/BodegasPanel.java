package poo.proyecto.paneles;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import poo.proyecto.clases.ListaBodega;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import poo.proyecto.clases.Bodega;
import poo.proyecto.clases.Inmueble;
import poo.proyecto.frames.AgregarBodegaFrame;
import poo.proyecto.frames.MostrarBodegaFrame;

public class BodegasPanel extends JPanel {

    private ListaBodega bodegas;
    
    public BodegasPanel(ListaBodega bodegas) {
        initComponents();
        this.bodegas = bodegas;
        jTable1.setColumnSelectionAllowed(false);
        jTable1.setRowSelectionAllowed(true);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jTable1.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if(!e.getValueIsAdjusting()) {
                if (jTable1.getSelectedRow() == -1)
                    return;
                
                int numeroBodega = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
                System.out.println(numeroBodega);
                // Busco la bodega
                Bodega bodegaSeleccionada = (Bodega) this.bodegas.buscarPorNumero(numeroBodega);
                // Si es que existe la bodega la muestro,
                // Si no, muestro un error
                if (bodegaSeleccionada != null){
                    MostrarBodegaFrame frame = new MostrarBodegaFrame(bodegaSeleccionada, this.bodegas);
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
                    JOptionPane.showMessageDialog(new JFrame(), "No existe la Bodega", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        actualizarTabla();
    }
    
    //Acá lleno matriz con valores de las bodegas existentes.
    private void actualizarTabla() {
        jTable1.setModel(new DefaultTableModel(this.bodegas.getModelData(), new String [] { "Número", "Piso", "Precio", "Estado", "Superficie", "Tipo"}){
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
        jTable1 = new javax.swing.JTable();
        botonAgregar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 51, 153));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 860, 230));

        botonAgregar.setBackground(new java.awt.Color(120, 204, 255));
        botonAgregar.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        botonAgregar.setForeground(new java.awt.Color(204, 255, 255));
        botonAgregar.setText("Agregar Bodega");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        jLabelFondo.setPreferredSize(new java.awt.Dimension(906, 296));
        add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        AgregarBodegaFrame frame = new AgregarBodegaFrame(this.bodegas);
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
    }//GEN-LAST:event_botonAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
