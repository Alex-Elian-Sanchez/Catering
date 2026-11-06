package ar.edu.unahur.Modificaciones;

import ar.edu.unahur.obj2.catering.Excepciones.NadaParaRevertirException;

import java.util.ArrayList;
import java.util.List;

public class GestorCarta {
    private final List<Modificacion> historial = new ArrayList<>();

    public void aplicar(Modificacion modificacion) {
        modificacion.aplicar();
        historial.add(modificacion);
    }

    public void revertirUltima() {
        if (historial.isEmpty()) {
            throw new NadaParaRevertirException();
        }
        Modificacion modificacion = historial.get(historial.size() - 1);
        modificacion.revertir();
        historial.remove(historial.size() - 1);
    }

    public void aplicarLote(List<Modificacion> modificaciones) {
        List<Modificacion> aplicadas = new ArrayList<>();
        try {
            for (Modificacion modificacion : modificaciones) {
                modificacion.aplicar();
                aplicadas.add(modificacion);
            }
        } catch (RuntimeException excepcion) {
            revertirLote(aplicadas);
            throw excepcion;
        }
        historial.addAll(aplicadas);
    }

    private void revertirLote(List<Modificacion> aplicadas) {
        for (Integer posicion = aplicadas.size() - 1; posicion >= 0; posicion--) {
            Modificacion modificacion = aplicadas.get(posicion);
            modificacion.revertir();
        }
    }
}
