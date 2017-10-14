package poo.proyecto;

import poo.proyecto.clases.ListaClientes;
import poo.proyecto.clases.ListaProyecto;

public class GestionInmobiliaria {

    public static void main(String args[]) {
        ListaClientes clientes = new ListaClientes();
        ListaProyecto proyectos = new ListaProyecto();

        VentanaLogin ventana;
        ventana = new VentanaLogin(clientes, proyectos);
        ventana.setVisible(true);

    }
}
