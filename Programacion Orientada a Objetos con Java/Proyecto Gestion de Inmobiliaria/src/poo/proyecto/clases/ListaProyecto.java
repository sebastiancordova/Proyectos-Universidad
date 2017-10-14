package poo.proyecto.clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class ListaProyecto implements ManipularDatos {

    private ArrayList<Proyecto> listado;

    public ListaProyecto() {
        this.listado = new ArrayList<Proyecto>();
    }

    public void cargarDatos() {
        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(Ruta.ARCHIVO_XML_PROYECTOS);
        try {

            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build(xmlFile);
            //Se obtiene la raiz 'proyectos'
            Element rootNode = document.getRootElement();
            //Se obtiene la lista de hijos de la raiz 'proyectos'
            List listaPrycto = rootNode.getChildren("proyecto");
            //Se recorre la lista de hijos de 'proyecto'
            for (int i = 0; i < listaPrycto.size(); i++) {
                //Se obtiene el elemento 'cliente'
                Element proyecto = (Element) listaPrycto.get(i);

                //Se obtienen los valores que estan entre los tags '<proyecto></proyecto>'
                String nombre = proyecto.getChildTextTrim("nombre");
                String etapa = proyecto.getChildTextTrim("etapa");
                String direccion = proyecto.getChildTextTrim("direccion");
                String region = proyecto.getChildTextTrim("region");

                //Se crea un proyecto con lo valores cargados
                Proyecto proy = new Proyecto(nombre, etapa, direccion, region);

                //Se obtiene una lista de hijos de la raiz 'departamento'
                List listaDpto = proyecto.getChildren("departamento");
                //se recorre la lista de hijos de 'departamento'

                InmueblePrototipo pro = new InmueblePrototipo();
                for (int j = 0; j < listaDpto.size(); j++) {
                    Element departamento = (Element) listaDpto.get(j);

                    //Se obtienen los valores que estan entre los tags '<departamento></departamento>'
                    int numero = Integer.parseInt(departamento.getChildTextTrim("numero"));
                    double superficie = Double.parseDouble(departamento.getChildTextTrim("superficie"));
                    int precio = Integer.parseInt(departamento.getChildTextTrim("precio"));
                    String tipo = departamento.getChildTextTrim("tipo");
                    int piso = Integer.parseInt(departamento.getChildTextTrim("piso"));
                    int numeroBanos = Integer.parseInt(departamento.getChildTextTrim("numeroBanos"));
                    int numeroDormitorios = Integer.parseInt(departamento.getChildTextTrim("numeroDormitorios"));
                    String tipoCocina = departamento.getChildTextTrim("tipoCocina");

                    Departamento depa = (Departamento) pro.prototipo("depa");
                    depa.setDatos(numero, superficie, precio, tipo, piso, numeroBanos, numeroDormitorios, tipoCocina);
                    proy.agregarDepartamento(depa);
                }

                List listaEst = proyecto.getChildren("estacionamiento");
                for (int k = 0; k < listaEst.size(); k++) {

                    Element estacionamiento = (Element) listaEst.get(k);

                    int numero = Integer.parseInt(estacionamiento.getChildTextTrim("numero"));
                    double superficie = Double.parseDouble(estacionamiento.getChildTextTrim("superficie"));
                    int precio = Integer.parseInt(estacionamiento.getChildTextTrim("precio"));
                    String tipo = estacionamiento.getChildTextTrim("tipo");
                    int piso = Integer.parseInt(estacionamiento.getChildTextTrim("piso"));
                    String techado = estacionamiento.getChildTextTrim("techado");

                    Estacionamiento esta = (Estacionamiento) pro.prototipo("est");
                    esta.setDatos(numero, superficie, precio, tipo, piso, techado);
                    proy.agregarEstacionamiento(esta);
                }

                List listaBdga = proyecto.getChildren("bodega");
                for (int l = 0; l < listaBdga.size(); l++) {

                    Element bodega = (Element) listaBdga.get(l);

                    int numero = Integer.parseInt(bodega.getChildTextTrim("numero"));
                    double superficie = Double.parseDouble(bodega.getChildTextTrim("superficie"));
                    int precio = Integer.parseInt(bodega.getChildTextTrim("precio"));
                    String tipo = bodega.getChildTextTrim("tipo");
                    int piso = Integer.parseInt(bodega.getChildTextTrim("piso"));

                    Bodega bdga = (Bodega) pro.prototipo("bodega");
                    bdga.setDatos(numero, superficie, precio, tipo, piso);
                    proy.agregarBodega(bdga);
                }
                listado.add(proy);
            }
        } catch (JDOMException ex) {
            Logger.getLogger(ListaProyecto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListaProyecto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ListaProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean agregar(String nombre, String etapa, String direccion, String region) {

        // Valido que no exista el proyecto
        for (Proyecto p : listado) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                JOptionPane.showMessageDialog(new JFrame(), "Ya existe un proyecto con este nombre", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        this.listado.add(new Proyecto(nombre, etapa, direccion, region));
        return true;
    }

    public boolean editar(String nombreBuscar, String etapa, String direccion, String region) {
        for (Proyecto p : listado) {
            if (p.getNombre().equals(nombreBuscar)) {
                p.setEtapa(etapa);
                p.setDireccion(direccion);
                p.setRegion(region);

                return true;
            }
        }
        return false;
    }

    public void agregar(Proyecto proyecto) {
        this.listado.add(proyecto);
    }

    public Object[][] getModelData() {
        int cantidadProyectos = listado.size();

        Object[][] obj = new Object[cantidadProyectos][7];
        int contador = 0;
        for (Proyecto proyecto : listado) {
            obj[contador][0] = proyecto.getNombre();
            obj[contador][1] = proyecto.getEtapa();
            obj[contador][2] = proyecto.getDireccion();
            obj[contador][3] = proyecto.getRegion();
            obj[contador][4] = proyecto.getCantidadDepartamentos();
            obj[contador][5] = proyecto.getCantidadBodegas();
            obj[contador][6] = proyecto.getCantidadEstacionamientos();
            contador++;
        }
        return obj;
    }

    public boolean eliminar(String nombreProyecto) {
        Iterator<Proyecto> it = this.listado.iterator();
        while (it.hasNext()) {
            Proyecto p = it.next();
            if (p.getNombre().equalsIgnoreCase(nombreProyecto) && p.esPosibleEliminar()) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public Proyecto buscarPorNombre(String nombreProyecto) {
        for (Proyecto p : listado) {
            if (p.getNombre().equalsIgnoreCase(nombreProyecto)) {
                return p;
            }
        }
        return null;
    }

    /* REPORTES*/
    // Retorna el proyecto con más departamentos vendidos
    // Si no hay ventas en ningún proyecto retorna null
    public Proyecto masDepartamentosVendidos() {

        Proyecto proyectoMasVendido = null;
        int cantidadDepartamentosVendidosMax = 0;
        int cantidadActual = 0;
        for (Proyecto p : listado) {
            cantidadActual = p.getCantidadDepartamentosVendidos();
            if (cantidadActual > cantidadDepartamentosVendidosMax) {
                proyectoMasVendido = p;
                cantidadDepartamentosVendidosMax = cantidadActual;
            }
        }
        return proyectoMasVendido;
    }

    // Más departamentos vendidos por region
    // Acá se usa sobrecarga del metodo anterior para buscar solo en una region
    public Proyecto masDepartamentosVendidos(String region) {

        Proyecto proyectoMasVendido = null;
        int cantidadDepartamentosVendidosMax = 0;
        int cantidadActual = 0;
        for (Proyecto p : listado) {
            cantidadActual = p.getCantidadDepartamentosVendidos(region);
            if (cantidadActual > cantidadDepartamentosVendidosMax) {
                proyectoMasVendido = p;
                cantidadDepartamentosVendidosMax = cantidadActual;
            }
        }
        return proyectoMasVendido;
    }

    // Muestra los departamentos bajo las 2000 uf
    public ArrayList<Departamento> departamentosConSubsidio() {
        ArrayList<Departamento> conSubsidio = new ArrayList<Departamento>();
        for (Proyecto proyecto : listado) {
            ArrayList<Departamento> proyectoConSubsidio = proyecto.getDepartamentosConSubsidio();
            for (Departamento dep : proyectoConSubsidio) {
                conSubsidio.add(dep);
            }
        }
        return conSubsidio;
    }

    public String getNombreProyecto(int pos) {
        for (int i = 0; i < listado.size(); i++) {
            if (i == pos) {
                return listado.get(i).getNombre();
            }
        }
        return null;
    }

    public int getCantidad() {
        return this.listado.size();
    }

    public Proyecto buscar(String nombreProyecto) {
        for (Proyecto p : listado) {
            if (p.getNombre().equalsIgnoreCase(nombreProyecto)) {
                return p;
            }
        }
        return null;
    }

    public void guardarDatos() {
        Element clientes = new Element("proyectos");
        Document doc = new Document(clientes);
        for (Proyecto currProyecto : listado) {
            Element proyecto = new Element("proyecto");
            proyecto.addContent(new Element("nombre").setText(currProyecto.getNombre()));
            proyecto.addContent(new Element("etapa").setText(currProyecto.getEtapa()));
            proyecto.addContent(new Element("direccion").setText(currProyecto.getDireccion()));
            proyecto.addContent(new Element("region").setText(currProyecto.getRegion()));

            // genero los elementos de los departamentos
            currProyecto.getDepartamentos().generarElemento(proyecto);
            currProyecto.getBodegas().generarElemento(proyecto);
            currProyecto.getEstacionamientos().generarElemento(proyecto);

            doc.getRootElement().addContent(proyecto);
        }

        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        try {
            xmlOutput.output(doc, new FileWriter(Ruta.ARCHIVO_XML_PROYECTOS));
        } catch (IOException ex) {
            Logger.getLogger(ListaProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
