package poo.proyecto.clases;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Departamento extends Inmueble {
    
    private int numeroBanos;
    private int numeroDormitorios;
    private String tipoCocina;
    
    public Departamento(int numero, double superficie, int precio, String tipo, int piso, int numeroBanos, int numeroDormitorios, String tipoCocina) {
        super(numero, superficie, precio, tipo, piso, "Disponible");
        this.numeroBanos=numeroBanos;
        this.numeroDormitorios=numeroDormitorios;
        this.tipoCocina=tipoCocina;
    }

    public void setDatos(int numero, double superficie, int precio, String tipo, int piso, int numeroBanos, int numeroDormitorios, String tipoCocina){
        setNumero(numero);
        setSuperficie(superficie);
        setPrecio(precio);
        setTipo(tipo);
        setPiso(piso);
        setNumeroBanos(numeroBanos);
        setNumeroDormitorios(numeroDormitorios);
        setTipoCocina(tipoCocina);
    }
    
    
    public int getNumeroBanos() {
        return numeroBanos;
    }

    public void setNumeroBanos(int numeroBanos) {
        this.numeroBanos = numeroBanos;
    }

    public int getNumeroDormitorios() {
        return numeroDormitorios;
    }

    public void setNumeroDormitorios(int numeroDormitorios) {
        this.numeroDormitorios = numeroDormitorios;
    }

    public String getTipoCocina() {
        return tipoCocina;
    }

    public void setTipoCocina(String tipoCocina) {
        this.tipoCocina = tipoCocina;
    }

    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(new JFrame(), mensaje, "Error Departamento", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public String getTitulo() {
        return "Departamento";
    }
}
