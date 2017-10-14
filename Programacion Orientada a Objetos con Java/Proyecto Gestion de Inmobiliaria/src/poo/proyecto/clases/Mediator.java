
package poo.proyecto.clases;

/**
 * @class Mediator

 */
public class Mediator {
    private Cliente cliente;
    private Inmueble inmueble;

    public Mediator() {
       
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }
    
    public boolean vender(){
        if(inmueble.getEstado().equalsIgnoreCase("disponible")) {
            inmueble.setEstado("Vendido");
            inmueble.setCliente(cliente);
            return true;
        } else {
            return false;
        }
    } 
}
