package ar.edu.unahur.obj2.catering.Excepciones;

public class PrecioNegativoException extends RuntimeException {
    public PrecioNegativoException() {
        super("El precio no puede ser negativo");
    }
}
