package poo.proyecto;

import poo.proyecto.clases.Ruta;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import poo.proyecto.clases.ListaClientes;
import poo.proyecto.clases.ListaProyecto;
import poo.proyecto.clases.UsuarioValidoException;

public class VentanaLogin extends JFrame {

    private ListaClientes clientes;
    private ListaProyecto proyectos;
    
    public VentanaLogin(ListaClientes clientes, ListaProyecto proyectos) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.clientes = clientes;
        this.proyectos = proyectos;

    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("poo/proyecto/imagenes/logo.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabelIcono = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButtonSesion = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        jButton1.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/x32-salir.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 0, 30, -1));

        jLabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/1477036716_vector_65_02.png"))); // NOI18N
        getContentPane().add(jLabelIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 130, -1));

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Usuario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Contraseña:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jTextFieldUser.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldUser.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        getContentPane().add(jTextFieldUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 180, -1));

        jPasswordField1.setBackground(new java.awt.Color(204, 255, 255));
        jPasswordField1.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 180, -1));

        jButtonSesion.setBackground(new java.awt.Color(102, 204, 255));
        jButtonSesion.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jButtonSesion.setForeground(new java.awt.Color(204, 255, 255));
        jButtonSesion.setText("Iniciar Sesion");
        jButtonSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSesionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 160, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo/proyecto/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 398));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSesionActionPerformed
        String user = jTextFieldUser.getText();
        String pass = jPasswordField1.getText();
        if (existeUsuario(user, pass)) {
            VentanaPrincipal frame = new VentanaPrincipal(clientes,proyectos);
            frame.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Usuario o Clave erronea", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButtonSesionActionPerformed

    public boolean existeUsuario(String user, String pass) {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(Ruta.ARCHIVO_XML_USUARIOS);

        try {

            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build(xmlFile);
            //Se obtiene la raiz 'usuarios'
            Element rootNode = document.getRootElement();
            //Se obtiene la lista de hijos de la raiz 'usuarios'
            List list = rootNode.getChildren("usuario");
            //Se recorre la lista de hijos de 'usuarios'

            for (int i = 0; i < list.size(); i++) {
                //Se obtiene el elemento 'usuario'

                Element cliente = (Element) list.get(i);

                //Se obtienen los valores que estan entre los tags '<usuario></usuario>'
                String nombre = cliente.getChildTextTrim("nombre");
                String password = cliente.getChildTextTrim("pass");
                try {
                    if (nombre.equals(user) && password.equals(pass)) {
                        return true;
                    } else if (i + 1 == list.size()) {
                        throw new UsuarioValidoException("Usuario o Password incorrecto");
                    }
                } catch (UsuarioValidoException e) {
                    System.err.println(e.getMessage());
//                    e.printStackTrace();
                }
            }

        } catch (JDOMException ex) {
            Logger.getLogger(VentanaLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VentanaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables
}
