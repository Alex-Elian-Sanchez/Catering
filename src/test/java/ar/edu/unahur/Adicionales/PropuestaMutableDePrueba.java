package ar.edu.unahur.Adicionales;

import ar.edu.unahur.Propuesta.Propuesta;

class PropuestaMutableDePrueba implements Propuesta {

    private String nombre;
    private Double precio;

    PropuestaMutableDePrueba(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    void cambiarNombre(String nombre) {
        this.nombre = nombre;
    }

    void cambiarPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String descripcion() {
        return nombre;
    }

    @Override
    public Double calcularPrecio() {
        return precio;
    }

    @Override
    public Integer cantidadDeServicios() {
        return 1;
    }

    @Override
    public Boolean incluyeServicio(String nombreServicio) {
        return nombre.equals(nombreServicio);
    }
}
