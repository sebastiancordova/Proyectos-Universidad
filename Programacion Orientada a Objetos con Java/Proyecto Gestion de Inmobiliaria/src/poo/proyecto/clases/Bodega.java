package poo.proyecto.clases;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Bodega extends Inmueble{
    
    public Bodega(int numero, double superficie, int precio, String tipo, int piso) {
        super(numero, superficie, precio, tipo, piso, "Disponible");
    }
    
    public void setDatos(int numero, double superficie, int precio, String tipo, int piso){
        setNumero(numero);
        setSuperficie(superficie);
        setPrecio(precio);
        setTipo(tipo);
        setPiso(piso);
    }


    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(new JFrame(), mensaje, "Error Departamento", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public String getTitulo() {
        return "Bodega";
    }
}

