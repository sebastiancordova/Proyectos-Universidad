package poo.proyecto.clases;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Cliente {
    
    private String nombre;
    private String rut;
    private String digVerificador;
    private String direccion;
    private String telefono;
    private String email;
    
    public Cliente(String nombre, String rut, String digVerificador, String direccion, String telefono, String email) {
        this.rut = rut;
        this.digVerificador = digVerificador;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setDigVerificador(String digVerificador) {
        this.digVerificador = digVerificador;
    }

    public String getDigVerificador() {
        return digVerificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
