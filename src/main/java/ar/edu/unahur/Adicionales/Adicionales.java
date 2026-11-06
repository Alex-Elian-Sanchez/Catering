package ar.edu.unahur.Adicionales;

import ar.edu.unahur.Propuesta.Propuesta;

public abstract class Adicionales implements Propuesta {

    protected final Propuesta propuesta;
    private final String nombre;

    protected Adicionales(Propuesta propuesta, String nombre) {
        this.propuesta = propuesta;
        this.nombre = nombre;
    }

    @Override
    public String descripcion() {
        return propuesta.descripcion() + " + " + nombre;
    }

    @Override
    public Integer cantidadDeServicios() {
        return propuesta.cantidadDeServicios();
    }

    @Override
    public Boolean incluyeServicio(String nombreServicio) {
        return propuesta.incluyeServicio(nombreServicio);
    }
}
