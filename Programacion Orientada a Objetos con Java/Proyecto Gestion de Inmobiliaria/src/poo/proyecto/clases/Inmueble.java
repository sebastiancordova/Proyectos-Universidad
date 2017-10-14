package poo.proyecto.clases;


public abstract class Inmueble implements Cloneable {

    private double superficie;
    private int precio;
    private String tipo;
    private int numero;
    private int piso;
    private String estado;
    private Cliente cliente;

    public Inmueble(int numero, double superficie, int precio, String tipo, int piso, String estado) {
        this.superficie = superficie;
        this.precio = precio;
        this.tipo = tipo;
        this.piso = piso;
        this.estado = estado;
        this.numero = numero;
    }

    public Inmueble clone() throws CloneNotSupportedException {
        return (Inmueble) super.clone();
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean esPosibleEliminar() {
        return cliente == null;
    }

    public abstract void mostrarError(String mensaje);

    public abstract String getTitulo();

//    public boolean vender (Cliente cliente) {
//        if(getEstado().equalsIgnoreCase("disponible")) {
//            setEstado("Vendido");
//            setCliente(cliente);
//            return true;
//        } else {
//            return false;
//        }
//    }
    
    public void eliminarVenta() {
        setEstado("Disponible");
        setCliente(null);
    }
}
