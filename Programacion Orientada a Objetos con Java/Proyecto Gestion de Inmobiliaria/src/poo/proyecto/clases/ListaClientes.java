package poo.proyecto.clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class ListaClientes implements ManipularDatos {

    private ListaColeccion coleccionClientes;

    // Constructor
    public ListaClientes() {
        this.coleccionClientes = new ListaColeccion();
    }

    public void cargarDatos() {

        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(Ruta.ARCHIVO_XML_CLIENTES);
        try {
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build(xmlFile);
            //Se obtiene la raiz 'clientes'
            Element rootNode = document.getRootElement();
            //Se obtiene la lista de hijos de la raiz 'clientes'
            List list = rootNode.getChildren("cliente");
            coleccionClientes.fijarAlInicio();
            //Se recorre la lista de hijos de 'tables'
            for (int i = 0; i < list.size(); i++) {
                //Se obtiene el elemento 'cliente'
                Element cliente = (Element) list.get(i);

                //Se obtienen los valores que estan entre los tags '<cliente></cliente>'
                String rut = cliente.getChildTextTrim("rut");
                String codVerificador = cliente.getChildTextTrim("digVerificador");
                String nombre = cliente.getChildTextTrim("nombre");
                String direccion = cliente.getChildTextTrim("direccion");
                String telefono = cliente.getChildTextTrim("telefono");
                String email = cliente.getChildTextTrim("email");

                Cliente client = new Cliente(nombre, rut, codVerificador, direccion, telefono, email);
                coleccionClientes.agregar(client);
                coleccionClientes.siguiente();

            }
        } catch (JDOMException ex) {
            Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean agregar(String nombreCliente, String rutCliente, String digVerificador, String direccion, String telefono, String email) {
        // Valido que no exista un cliente con el mismo rut
        coleccionClientes.fijarAlInicio();
        while (!coleccionClientes.finDeLista()) {
            if (((Cliente) coleccionClientes.valorActual()).getRut().equalsIgnoreCase(rutCliente)) {
                return false;
            }
            coleccionClientes.siguiente();
        }

        // agrego el cliente a la coleccion
        agregar(new Cliente(nombreCliente, rutCliente, digVerificador, direccion, telefono, email));
        return true;
    }

    public boolean agregar(Cliente cliente) {
        coleccionClientes.agregar(cliente);
        return true;
    }

    public boolean eliminar(String rut) {
        coleccionClientes.fijarAlInicio();
        while (!coleccionClientes.finDeLista()) {
            if (((Cliente) coleccionClientes.valorActual()).getRut().equalsIgnoreCase(rut)) {
                coleccionClientes.eliminar(coleccionClientes.valorActual());
                return true;
            }
            coleccionClientes.siguiente();
        }
        return false;
    }

    public Cliente buscarPorRut(String rutCliente) {
        coleccionClientes.fijarAlInicio();
        while (!coleccionClientes.finDeLista()) {
            if (((Cliente) coleccionClientes.valorActual()).getRut().equalsIgnoreCase(rutCliente)) {
                return (Cliente) coleccionClientes.valorActual();
            }
            coleccionClientes.siguiente();
        }

        return null;
    }

    public static boolean validarRut(String rut, char dig) throws RutValidoException {
        int sumaRut = 0;
        int multiplo = 2;
        int resto;
        int caractRut;
        int digResultante;
        char digComparar;
        for (int i = rut.length() - 1; i >= 0; i--) {
            if (multiplo == 8) {
                multiplo = 2;
            }
            caractRut = Integer.parseInt(rut.charAt(i) + "");
            sumaRut = sumaRut + caractRut * multiplo;
            multiplo++;
        }
        resto = sumaRut % 11;
        digResultante = 11 - resto;
        if (digResultante == 10) {
            digComparar = 'k';
        } else if (digResultante == 11) {
            digComparar = '0';
        } else {
            digComparar = String.valueOf(digResultante).charAt(0);
        }

        if (digComparar == dig) {
            return true;
        } else {
            throw new RutValidoException("Rut no valido");
        }
    }

    public boolean editar(String nombreCliente, String rutCliente, String digVerificador, String direccion, String telefono, String email) {
        coleccionClientes.fijarAlInicio();
        while (!coleccionClientes.finDeLista()) {
            if (((Cliente) coleccionClientes.valorActual()).getRut().equalsIgnoreCase(rutCliente)) {
                ((Cliente) coleccionClientes.valorActual()).setRut(rutCliente);
                ((Cliente) coleccionClientes.valorActual()).setDigVerificador(digVerificador);
                ((Cliente) coleccionClientes.valorActual()).setNombre(nombreCliente);
                ((Cliente) coleccionClientes.valorActual()).setDireccion(direccion);
                ((Cliente) coleccionClientes.valorActual()).setTelefono(telefono);
                ((Cliente) coleccionClientes.valorActual()).setEmail(email);

                return true;
            }
            coleccionClientes.siguiente();
        }
        return false;
    }

    public Object[][] getModelData() {
        int cantidadProyectos = coleccionClientes.dimension();
        Object[][] obj = new Object[cantidadProyectos][5];
        int contador = 0;

        coleccionClientes.fijarAlInicio();
        while (!coleccionClientes.finDeLista()) {
            obj[contador][0] = ((Cliente) coleccionClientes.valorActual()).getNombre();
            obj[contador][1] = ((Cliente) coleccionClientes.valorActual()).getRut() + "-" + ((Cliente) coleccionClientes.valorActual()).getDigVerificador();
            obj[contador][2] = ((Cliente) coleccionClientes.valorActual()).getDireccion();
            obj[contador][3] = ((Cliente) coleccionClientes.valorActual()).getTelefono();
            obj[contador][4] = ((Cliente) coleccionClientes.valorActual()).getEmail();
            contador++;
            coleccionClientes.siguiente();
        }

        return obj;
    }

    public void guardarDatos() {
        Element clientes = new Element("clientes");
        Document doc = new Document(clientes);
        coleccionClientes.fijarAlInicio();
        while (!coleccionClientes.finDeLista()) {
            Cliente curr = (Cliente) coleccionClientes.valorActual();
            Element cliente = new Element("cliente");
            cliente.addContent(new Element("nombre").setText(curr.getNombre()));
            cliente.addContent(new Element("rut").setText(curr.getRut()));
            cliente.addContent(new Element("digVerificador").setText(curr.getDigVerificador()));
            cliente.addContent(new Element("direccion").setText(curr.getDireccion()));
            cliente.addContent(new Element("telefono").setText(curr.getTelefono()));
            cliente.addContent(new Element("email").setText(curr.getEmail()));
            doc.getRootElement().addContent(cliente);
            coleccionClientes.siguiente();
        }

        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        try {
            xmlOutput.output(doc, new FileWriter(Ruta.ARCHIVO_XML_CLIENTES));
        } catch (IOException ex) {
            Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
