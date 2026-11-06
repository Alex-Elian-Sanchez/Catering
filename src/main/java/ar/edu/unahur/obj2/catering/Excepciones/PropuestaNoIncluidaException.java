package ar.edu.unahur.obj2.catering.Excepciones;

public class PropuestaNoIncluidaException extends RuntimeException {

    public PropuestaNoIncluidaException() {
        super("La propuesta no es un componente directo del menú");
    }
}
