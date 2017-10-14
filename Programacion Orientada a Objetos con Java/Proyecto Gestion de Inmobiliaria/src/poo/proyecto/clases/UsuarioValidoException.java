package poo.proyecto.clases;

public class UsuarioValidoException extends Exception {

    public UsuarioValidoException(String mensaje) {
        super("Excepcion capturada: "+mensaje);
    }

}
