package poo.proyecto.clases;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jdom2.Element;

public class ListaDepartamento extends ListaInmueble {

    public ListaDepartamento() {
        super();
    }

    // Este metodo agrega un departamento
    // Los parametros son string para poder validar que no estén vacíos
    public boolean agregar(String numero, String superficie, String precio, String tipo, String piso, String numeroBanos, String numeroDormitorios, String tipoCocina) {
        // valido que el nombre o la direccion no sean vacios
        double dSuperficie;
        int nNumero;
        int nPiso;
        int nNumeroBanos;
        int nNumeroDormitorios;
        int nPecio;
        try {
            dSuperficie = Double.parseDouble(superficie);
            nNumero = Integer.parseInt(numero);
            nPiso = Integer.parseInt(piso);
            nNumeroBanos = Integer.parseInt(numeroBanos);
            nNumeroDormitorios = Integer.parseInt(numeroDormitorios);
            nPecio = Integer.parseInt(precio);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Debe ingresar en formato correctos los números", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Valido que no exista el departamento. El tipo y el piso no se deben repetir
        for (Inmueble d : listado) {
            if (d.getNumero() == nNumero) {
                ((Departamento) d).mostrarError("Ya existe este departamento");
                return false;
            }
        }
        // double superficie, int precio, int tipo, int piso, String estado, int numeroBanos, int numeroDormitorios, String tipoCocina
        this.listado.add(new Departamento(nNumero, dSuperficie, nPecio, tipo, nPiso, nNumeroBanos, nNumeroDormitorios, tipoCocina));
        return true;
    }
    
    public boolean editar(String numero, String superficie, String precio, String tipo, String piso, String numeroBanos, String numeroDormitorios, String tipoCocina) {
        // valido que los datos no sean vacios
        int dnumero;
        double dSuperficie;
        int nPiso;
        int nPrecio;
        int nNumeroBanos;
        int nNumeroDormitorios;
        Departamento departamento;
        try{
            dnumero = Integer.parseInt(numero);
            dSuperficie = Double.parseDouble(superficie);
            nPiso = Integer.parseInt(piso);
            nPrecio = Integer.parseInt(precio);
            nNumeroBanos = Integer.parseInt(numeroBanos);
            nNumeroDormitorios = Integer.parseInt(numeroDormitorios);
        }catch(NumberFormatException e){
//            mostrarError("Debe ingresar en formato correctos los números");
            return false;
        }
        for (Inmueble inmueble : listado) {
            if(((Departamento)inmueble).getNumero() == dnumero ){
                ((Departamento)inmueble).setSuperficie(dSuperficie);
                ((Departamento)inmueble).setPrecio(nPrecio);
                ((Departamento)inmueble).setPiso(nPiso);
                ((Departamento)inmueble).setTipo(tipo);
                ((Departamento)inmueble).setNumeroBanos(nNumeroBanos);
                ((Departamento)inmueble).setNumeroDormitorios(nNumeroDormitorios);
                ((Departamento)inmueble).setTipoCocina(tipoCocina);
                return true;
            }
        }
        return false;
    }
    
    
    public boolean eliminar(int numero){
        for (Inmueble inmueble : listado) {
            if((((Departamento)inmueble).getNumero() == numero ) && ((Departamento)inmueble).getCliente()==null){
                this.listado.remove(inmueble);
                return true;
            }
        }
            return false;
    }

    public boolean agregar(Departamento departamento) {
        this.listado.add(departamento);
        return true;
    }

    public ArrayList<Departamento> listarConSubsidio() {
        ArrayList<Departamento> conSubsidio = new ArrayList<Departamento>();

        for (Inmueble departamento : listado) {
            if (departamento.getPrecio() <= 2000 && departamento.getEstado().equalsIgnoreCase("disponible")) {
                conSubsidio.add((Departamento) departamento);
            }
        }

        return conSubsidio;
    }

    public boolean aplicarDescuentoMasivo(String descuento) {
        int nDescuento;
        try {
            nDescuento = Integer.parseInt(descuento);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Debe ingresar el descuento en formato correcto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (nDescuento < 1 || nDescuento > 99) {
            JOptionPane.showMessageDialog(new JFrame(), "El % descuento debe ser mayor a 1% y menor que 99%", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Para cada departamento le hago un descuento
        for (Inmueble inmueble : listado) {
            int precio_antiguo = inmueble.getPrecio();
            System.out.println("Precio normal " + precio_antiguo);
            double nuevo_precio = (precio_antiguo - precio_antiguo * (((double) nDescuento / 100)));
            System.out.println("Precio descuento " + nuevo_precio);
            inmueble.setPrecio((int) nuevo_precio);
        }
        JOptionPane.showMessageDialog(new JFrame(), "Se ha aplicado el descuento con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    
    public void generarElemento(Element root) {
        for (Inmueble currInmueble : listado) {
            Departamento curr = (Departamento) currInmueble;
            Element proyecto = new Element("departamento");
            proyecto.addContent(new Element("numero").setText(String.valueOf(curr.getNumero())));
            proyecto.addContent(new Element("superficie").setText(String.valueOf(curr.getSuperficie())));
            proyecto.addContent(new Element("precio").setText(String.valueOf(curr.getPrecio())));
            proyecto.addContent(new Element("tipo").setText(curr.getTipo()));
            proyecto.addContent(new Element("piso").setText(String.valueOf(curr.getPiso())));
            proyecto.addContent(new Element("numeroBanos").setText(String.valueOf(curr.getNumeroBanos())));
            proyecto.addContent(new Element("numeroDormitorios").setText(String.valueOf(curr.getNumeroDormitorios())));
            proyecto.addContent(new Element("tipoCocina").setText(curr.getTipoCocina()));
            root.addContent(proyecto);
        }
    }
    
    
    public Object[][] getModelData() {
        int cantidadProyectos = listado.size();
        Object[][] obj = new Object[cantidadProyectos][8];
        int contador = 0;
        for (Inmueble departamento : listado) {
            obj[contador][0] = departamento.getNumero();
            obj[contador][1] = departamento.getPiso();
            obj[contador][2] = departamento.getPrecio();
            obj[contador][3] = departamento.getEstado();
            obj[contador][4] = departamento.getSuperficie();
            obj[contador][5] = ((Departamento) departamento).getNumeroDormitorios();
            obj[contador][6] = ((Departamento) departamento).getNumeroBanos();
            obj[contador][7] = ((Departamento) departamento).getTipoCocina();
            contador++;
        }
        return obj;
    }
}
