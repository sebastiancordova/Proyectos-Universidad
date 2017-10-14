package poo.proyecto.clases;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Proyecto {
    private String nombre;
    private String etapa;
    private String direccion;
    private String region;
    
    private ListaDepartamento departamentos;
    private ListaBodega bodegas;
    private ListaEstacionamiento estacionamientos;

    public Proyecto(String nombre, String etapa, String direccion, String region) {
        this.nombre = nombre;
        this.etapa = etapa;
        this.direccion = direccion;
        this.region = region;
        this.departamentos = new ListaDepartamento();
        this.bodegas = new ListaBodega();
        this.estacionamientos = new ListaEstacionamiento();
    }
    
//    // Métodos
//    public boolean editar(String etapa, String direccion, String region) {
//        // valido que el nombre o la direccion no sean vacios
//        if (
//            etapa.isEmpty() ||
//            direccion.isEmpty = etapa;
//        this.direccion = direccion;
//        this.region = region;
//        return true;
//    }
    
    public int getCantidadDepartamentos() {
        return this.departamentos.getCantidad();
    }
    
    public int getCantidadBodegas() {
        return this.bodegas.getCantidad();
    }
    
    public int getCantidadEstacionamientos() {
        return this.estacionamientos.getCantidad();
    }
    
    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public ListaDepartamento getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(ListaDepartamento departamentos) {
        this.departamentos = departamentos;
    }

    public ListaBodega getBodegas() {
        return bodegas;
    }

    public void setBodegas(ListaBodega bodegas) {
        this.bodegas = bodegas;
    }

    public ListaEstacionamiento getEstacionamientos() {
        return estacionamientos;
    }

    public void setEstacionamientos(ListaEstacionamiento estacionamientos) {
        this.estacionamientos = estacionamientos;
    }

    public int getCantidadDepartamentosVendidos() {
        return this.departamentos.getCantidadVendida();
    }

    public int getCantidadDepartamentosVendidos(String region) {
        // Retorno la cantidad solamente si es que el proyecto es de la region
        if (region.equalsIgnoreCase(this.getRegion())) {
            return this.departamentos.getCantidadVendida();
        }else {
            return 0;
        }
    }

    // Solamente se puede eliminar un proyecto si no posee ventas
    public boolean esPosibleEliminar() {
        if (this.departamentos.getCantidadVendida() > 0){
            JOptionPane.showMessageDialog(new JFrame(), "No es posible eliminar el proyecto ya que posee departamentos vendidos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if (this.bodegas.getCantidadVendida() > 0){
            JOptionPane.showMessageDialog(new JFrame(), "No es posible eliminar el proyecto ya que posee bodegas vendidas", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if (this.estacionamientos.getCantidadVendida() > 0){
            JOptionPane.showMessageDialog(new JFrame(), "No es posible eliminar el proyecto ya que posee estacionamientos vendidos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else
            return true;
        
    }

    public boolean agregarDepartamento(Departamento departamento) {
        return this.departamentos.agregar(departamento);
    }
    public boolean agregarBodega(Bodega bodega) {
        return this.bodegas.agregar(bodega);
    }
    public boolean agregarEstacionamiento(Estacionamiento est) {
        return this.estacionamientos.agregar(est);
    }
    
    public ArrayList<Departamento> getDepartamentosConSubsidio() {
        return this.departamentos.listarConSubsidio();
    }
    
}
