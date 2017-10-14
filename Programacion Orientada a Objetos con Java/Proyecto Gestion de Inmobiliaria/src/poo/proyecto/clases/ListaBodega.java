package poo.proyecto.clases;

import org.jdom2.Element;

public class ListaBodega extends ListaInmueble {
    public ListaBodega() {
        super();
    }
    
     public boolean agregar(String numero, String superficie, String precio, String tipo, String piso) {
       
        double dSuperficie;
        int nNumero;
        int nPiso;
        int nPecio;
        try{
            dSuperficie = Double.parseDouble(superficie);
            nNumero = Integer.parseInt(numero);
            nPiso = Integer.parseInt(piso);
            nPecio = Integer.parseInt(precio);
            }
        catch(NumberFormatException e){
            return false;
        }
        
        // Valido que no exista la bodega. 
        for (Inmueble obj : listado){ 
            Bodega bodega = (Bodega) obj;
            if (bodega.getNumero() == nNumero) {
                bodega.mostrarError("Ya existe esta bodega");
                return false;
            }
        }
        this.listado.add(new Bodega(nNumero, dSuperficie, nPecio, tipo, nPiso));
        return true;
    }
    
     
     
    public boolean agregar(Bodega bodega) {
        this.listado.add(bodega);
        return true;
    }
    
    
    
    public boolean editar(String numero, String superficie, String precio, String tipo, String piso, String estado){
        // valido que los datos no sean vacios
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
            if(((Bodega)inmueble).getNumero() == dnumero ){
                ((Bodega)inmueble).setSuperficie(dSuperficie);
                ((Bodega)inmueble).setPrecio(nPrecio);
                ((Bodega)inmueble).setPiso(nPiso);
                ((Bodega)inmueble).setTipo(tipo);
                return true;
            }
        }
        return false;
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
            Bodega curr = (Bodega) currInmueble;
            Element proyecto = new Element("bodega");
            proyecto.addContent(new Element("numero").setText(String.valueOf(curr.getNumero())));
            proyecto.addContent(new Element("superficie").setText(String.valueOf(curr.getSuperficie())));
            proyecto.addContent(new Element("precio").setText(String.valueOf(curr.getPrecio())));
            proyecto.addContent(new Element("tipo").setText(curr.getTipo()));
            proyecto.addContent(new Element("piso").setText(String.valueOf(curr.getPiso())));
            root.addContent(proyecto);
        }
    }
    
    
    
    public Object[][] getModelData() {
        int cantidadBodegas = listado.size();
        Object[][] obj = new Object[cantidadBodegas][6];
        int contador = 0;
        for (Inmueble bodega : listado) {
            obj[contador][0] = bodega.getNumero();
            obj[contador][1] = bodega.getPiso();
            obj[contador][2] = bodega.getPrecio();
            obj[contador][3] = bodega.getEstado();
            obj[contador][4] = bodega.getSuperficie();
            obj[contador][5] = bodega.getTipo();
            contador++;
        }
        return obj;
    }

}

