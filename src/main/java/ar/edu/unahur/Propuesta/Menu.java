package ar.edu.unahur.Propuesta;
import ar.edu.unahur.obj2.catering.Excepciones.DescuentoInvalidoException;
import ar.edu.unahur.obj2.catering.Excepciones.PropuestaNoIncluidaException;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Propuesta {
    private String nombre;
    private Double descuento;
    private List<Propuesta> propuestas;

    public Menu(String nombre, Double descuento) {
        this.nombre = nombre;
        this.descuento = validarDescuento(descuento);
        this.propuestas = new ArrayList<>();
    }
    
    public Double validarDescuento(Double descuento) {
        if (descuento < 0 || descuento > 100) {
            throw new DescuentoInvalidoException();
        }
        return descuento;
    }
    
    public Double getDescuento() {
        return descuento;
    }
    
    public void agregarPropuesta(Propuesta propuesta) {
        propuestas.add(propuesta);
    }
    
    public void quitarPropuesta(Propuesta propuesta) {
        if (!propuestas.contains(propuesta)) {
            throw new PropuestaNoIncluidaException();
        }
        propuestas.remove(propuesta);
    }


    @Override
    public String descripcion() {
        return nombre;
    }
    
    @Override
    public Double calcularPrecio() {
        return propuestas.stream().mapToDouble(Prop -> Prop.calcularPrecio()).sum() * (1 - descuento / 100);
    }
    
    @Override
    public Integer cantidadDeServicios() {
        return propuestas.stream().mapToInt(Prop -> Prop.cantidadDeServicios()).sum();
    }
    
    @Override
    public Boolean incluyeServicio(String nombreServicio) {
        return propuestas.stream().anyMatch(Prop -> Prop.incluyeServicio(nombreServicio));
    }
    
}
