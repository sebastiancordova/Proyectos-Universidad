package poo.proyecto.clases;

import java.util.ArrayList;

public class ListaColeccion {

    private ArrayList coleccion = new ArrayList();
    private int actual = -1;

    public boolean agregar(Object objeto) {
        //verifico que el objeto no este en la lista
        for (int i = 0; i < coleccion.size(); i++) {
            if (coleccion.get(i) == objeto) {
                return false;
            }
        }
        if (actual < 0) {
            actual++;
        }
        coleccion.add(actual, objeto);
        return true;
    }

    public void siguiente() {
        //if(actual<clientes.size())
        actual++;
    }

    public Object valorActual() {
        if (actual > -1 && actual < coleccion.size()) {
            return coleccion.get(actual);
        } else {
            return null;
        }
    }

    public boolean finDeLista() {
        return (actual >= coleccion.size());
    }

    public void fijarAlInicio() {
        if (coleccion.size() > 0) {
            actual = 0;
        }
    }

    public Object[] toArray() {
        if (coleccion.size() < 1) {
            return null;
        }
        Object[] arr = new Object[coleccion.size()];
        for (int i = 0; i < coleccion.size(); i++) {
            arr[i] = coleccion.get(i);
        }
        return arr;
    }
    
    public boolean eliminar(Object o){
        for(int i=0;i < coleccion.size(); i++){
            if(coleccion.get(i).equals(o)){
                coleccion.remove(o);
                return true;
            }
        }
        return false;
    }
    
    
    
    public int dimension(){
        return coleccion.size();
    }

}
