package ar.edu.unahur.Modificaciones;

import ar.edu.unahur.Propuesta.Servicio;

public class ActualizarPrecio implements Modificacion {

    private final Servicio servicio;
    private final Double nuevoPrecio;
    private Double precioAnterior;

    public ActualizarPrecio(Servicio servicio, Double nuevoPrecio) {
        this.servicio = servicio;
        this.nuevoPrecio = nuevoPrecio;
    }

    @Override
    public void aplicar() {
        precioAnterior = servicio.calcularPrecio();
        servicio.actualizarPrecio(nuevoPrecio);
    }

    @Override
    public void revertir() {
        servicio.actualizarPrecio(precioAnterior);
    }
}
