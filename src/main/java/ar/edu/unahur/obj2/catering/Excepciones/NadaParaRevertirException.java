package ar.edu.unahur.obj2.catering.Excepciones;

public class NadaParaRevertirException extends RuntimeException {

    public NadaParaRevertirException() {
        super("No hay modificaciones para revertir");
    }
}
