package ar.edu.unahur.Adicionales;

import ar.edu.unahur.Propuesta.Propuesta;

public class MozosAdicionales extends Adicionales {

    public MozosAdicionales(Propuesta propuesta) {
        super(propuesta, "Mozos adicionales");
    }

    @Override
    public Double calcularPrecio() {
        return propuesta.calcularPrecio() + 18000.0;
    }
}
