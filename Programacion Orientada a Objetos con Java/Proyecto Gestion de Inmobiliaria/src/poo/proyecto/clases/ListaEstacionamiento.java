package poo.proyecto.clases;

import org.jdom2.Element;

public class ListaEstacionamiento extends ListaInmueble {
    public ListaEstacionamiento() {
        super();
    }
    
    public boolean agregar(String numero, String superficie, String precio, String tipo, String piso, String techado) {
       
        double dSuperficie;
        int nNumero;
        int nPiso;
        int nPecio;
        try{
            dSuperficie = Double.parseDouble(superficie);
            nNumero = Integer.parseInt(numero);
            nPiso = Integer.parseInt(piso);
            nPecio = Integer.parseInt(precio);
        }catch(NumberFormatException e){
            return false;
        }
        
        // Valido que no exista el estacionamiento. El tipo y el piso no se deben repetir
        for (Inmueble e : listado){
            if (e.getNumero() == nNumero) {
                ((Estacionamiento )e).mostrarError("Ya existe este estacionamiento");
                return false;
            }
        }
        // double superficie, int precio, int tipo, int piso, String estado, string techado
        this.listado.add(new Estacionamiento(nNumero, dSuperficie, nPecio, tipo, nPiso, techado));
        return true;
    }
    
    public boolean agregar(Estacionamiento estacionamiento) {
        this.listado.add(estacionamiento);
        return true;
    }
    
    
    public boolean editar( String numero, String superficie, String precio, String tipo, String piso, String techado) {
        int dnumero;
        double dSuperficie;
        int nPiso;
        int nPrecio;
        try{
            dnumero = Integer.parseInt(numero);
            dSuperficie = Double.parseDouble(superficie);
            nPiso = Integer.parseInt(piso);
            nPrecio = Integer.parseInt(precio);
        }catch(NumberFormatException e){
            return false;
        } 
        for (Inmueble inmueble : listado) {
            if(((Estacionamiento)inmueble).getNumero() == dnumero ){
                ((Estacionamiento)inmueble).setSuperficie(dSuperficie);
                ((Estacionamiento)inmueble).setPrecio(nPrecio);
                ((Estacionamiento)inmueble).setPiso(nPiso);
                ((Estacionamiento)inmueble).setTipo(tipo);
                ((Estacionamiento)inmueble).setTechado(techado);
                return true;
            }
        }
        return true;
    }
    
    
    public boolean eliminar(int numero){
        for (Inmueble inmueble : listado) {
            if( inmueble.getNumero() == numero  && inmueble.getCliente()==null){
                this.listado.remove(inmueble);
                return true;
            }
        }
            return false;
    }
    
    public void generarElemento(Element root) {
        for (Inmueble currInmueble : listado) {
            Estacionamiento curr = (Estacionamiento) currInmueble;
            Element proyecto = new Element("estacionamiento");
            proyecto.addContent(new Element("numero").setText(String.valueOf(curr.getNumero())));
            proyecto.addContent(new Element("superficie").setText(String.valueOf(curr.getSuperficie())));
            proyecto.addContent(new Element("precio").setText(String.valueOf(curr.getPrecio())));
            proyecto.addContent(new Element("tipo").setText(curr.getTipo()));
            proyecto.addContent(new Element("piso").setText(String.valueOf(curr.getPiso())));
            proyecto.addContent(new Element("techado").setText(String.valueOf(curr.getTechado())));
            root.addContent(proyecto);
        }
    }
    
     
    public Object[][] getModelData() {
        int cantidadProyectos = listado.size();
        
        Object[][] obj = new Object[cantidadProyectos][6];
        int contador = 0;
        for (Inmueble inmueble : listado) {
            obj[contador][0] = inmueble.getNumero();
            obj[contador][1] = inmueble.getPiso();
            obj[contador][2] = inmueble.getPrecio();
            obj[contador][3] = inmueble.getEstado();
            obj[contador][4] = inmueble.getSuperficie();
            obj[contador][5] = ((Estacionamiento) inmueble).getTechado();
            contador++;
        }
        return obj;
    }
}
