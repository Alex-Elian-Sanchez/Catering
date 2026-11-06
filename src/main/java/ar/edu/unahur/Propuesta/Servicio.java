package ar.edu.unahur.Propuesta;
import ar.edu.unahur.obj2.catering.Excepciones.PrecioNegativoException;
public class Servicio implements Propuesta {
    private String nombre;
    private Double precio;

    public Servicio(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = validarPrecio(precio);
    }

    public String descripcion() {
        return nombre;
    }

    public Double validarPrecio(Double precio) {
        if (precio < 0) {
            throw new PrecioNegativoException();
        }
        return precio;
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
        return this.nombre.equals(nombreServicio);
    }
}
