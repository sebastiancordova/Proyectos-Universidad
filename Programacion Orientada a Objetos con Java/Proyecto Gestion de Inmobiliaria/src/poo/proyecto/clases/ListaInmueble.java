package poo.proyecto.clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public abstract class ListaInmueble {
    protected ArrayList<Inmueble> listado;
    
    public ListaInmueble() {
        this.listado = new ArrayList<Inmueble>();
    }
    

    public int getCantidadVendida() {
        int contador = 0;
        for (Inmueble inmueble : listado){ 
            if (inmueble.getEstado().equalsIgnoreCase("Vendido")) {
                contador++;
            }
        }
        return contador;
    }

    public int getCantidad() {
        return listado.size();
    }
    
    public Inmueble buscarPorNumero(int numero) {
        for (Inmueble inmueble : listado){ 
            if (inmueble.getNumero() == numero) {
                return inmueble;
            }
        }
        return null;
    }
    
    
    
}
