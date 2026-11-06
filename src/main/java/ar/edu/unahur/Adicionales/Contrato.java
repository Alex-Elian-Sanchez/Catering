package ar.edu.unahur.Adicionales;

import ar.edu.unahur.Propuesta.Propuesta;

public class Contrato {
    private final String cliente;
    private final Double importe;
    private final String descripcion;

    public Contrato(String cliente, Propuesta propuesta) {
        this.cliente = cliente;
        this.importe = propuesta.calcularPrecio();
        this.descripcion = propuesta.descripcion();
    }

    public String getCliente() {
        return cliente;
    }

    public Double getImporte() {
        return importe;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
