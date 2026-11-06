package ar.edu.unahur.obj2.catering.Excepciones;

public class DescuentoInvalidoException extends RuntimeException {
    public DescuentoInvalidoException() {
        super("El descuento no puede ser negativo");
    }
}
