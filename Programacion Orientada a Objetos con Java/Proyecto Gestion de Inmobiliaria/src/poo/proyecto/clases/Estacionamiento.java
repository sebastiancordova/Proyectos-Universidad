package poo.proyecto.clases;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Estacionamiento extends Inmueble {
    private String techado;
   
    public Estacionamiento(int numero, double superficie, int precio, String tipo, int piso, String techado) {
        super(numero, superficie, precio, tipo, piso, "Disponible");
        this.techado=techado;
    }
    
    public void setDatos(int numero, double superficie, int precio, String tipo, int piso, String techado){
        setNumero(numero);
        setSuperficie(superficie);
        setPrecio(precio);
        setTipo(tipo);
        setPiso(piso);
        setTechado(techado);
    }

   
    public String getTechado() {
        return techado;
    }

    public void setTechado(String techado) {
        this.techado = techado;
    }

    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(new JFrame(), mensaje, "Error Estacionamiento", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public String getTitulo() {
        return "Estacionamiento";
    }
    
}