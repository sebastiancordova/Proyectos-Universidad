package poo.proyecto.clases;

public class RutValidoException extends Exception {

    public RutValidoException(String mensaje) {
        super("Excepcion capturada: "+mensaje);
    }

}
