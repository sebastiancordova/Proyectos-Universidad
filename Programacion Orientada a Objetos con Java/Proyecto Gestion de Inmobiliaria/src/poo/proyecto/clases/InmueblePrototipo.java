
package poo.proyecto.clases;

import java.util.HashMap;

public class InmueblePrototipo {
    private HashMap<String, Inmueble> prototipos=new HashMap<String, Inmueble>();
    
    public InmueblePrototipo(){
        Departamento d=new Departamento(0,0,0,"A",0,0,0,"Americana");
        Bodega b=new Bodega(0,0,0,"A",0);
        Estacionamiento e=new Estacionamiento(0,0,0,"A",0,"Si");
        prototipos.put("depa",d);
        prototipos.put("bodega",b);
        prototipos.put("est",e);
    }
    
    public Object prototipo(String tipo) throws CloneNotSupportedException{
        return prototipos.get(tipo).clone();
    }
}
