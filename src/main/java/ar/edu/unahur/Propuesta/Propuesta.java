package ar.edu.unahur.Propuesta;

public interface Propuesta {
    public String descripcion();
    public Double calcularPrecio();
    public Integer cantidadDeServicios();
    public Boolean incluyeServicio(String nombreServicio);
}
