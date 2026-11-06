package ar.edu.unahur.Adicionales;

import ar.edu.unahur.Propuesta.Propuesta;

public class VajillaPremium extends Adicionales {

    public VajillaPremium(Propuesta propuesta) {
        super(propuesta, "Vajilla premium");
    }

    @Override
    public Double calcularPrecio() {
        return propuesta.calcularPrecio() + 12000.0;
    }
}
