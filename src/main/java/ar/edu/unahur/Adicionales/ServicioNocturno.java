package ar.edu.unahur.Adicionales;

import ar.edu.unahur.Propuesta.Propuesta;

public class ServicioNocturno extends Adicionales {

    public ServicioNocturno(Propuesta propuesta) {
        super(propuesta, "Servicio nocturno");
    }

    @Override
    public Double calcularPrecio() {
        return propuesta.calcularPrecio() * 1.20;
    }
}
