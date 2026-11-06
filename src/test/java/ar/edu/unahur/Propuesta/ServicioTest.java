package ar.edu.unahur.Propuesta;

import ar.edu.unahur.obj2.catering.Excepciones.PrecioNegativoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ServicioTest {

    @Test
    void dadoUnServicio_alCalcularPrecio_devuelveElPrecioInformado() {
        Servicio servicio = new Servicio("Mesa dulce", 60000.0);

        Double precio = servicio.calcularPrecio();

        assertEquals(60000.0, precio, 0.001);
    }

    @Test
    void dadoUnServicio_alConsultarDescripcion_devuelveSuNombre() {
        Servicio servicio = new Servicio("Mesa dulce", 60000.0);

        String descripcion = servicio.descripcion();

        assertEquals("Mesa dulce", descripcion);
    }

    @Test
    void dadoUnServicio_alContarServicios_devuelveUno() {
        Servicio servicio = new Servicio("Mesa dulce", 60000.0);

        Integer cantidad = servicio.cantidadDeServicios();

        assertEquals(Integer.valueOf(1), cantidad);
    }

    @Test
    void dadoUnServicio_alBuscarSuNombre_loIncluye() {
        Servicio servicio = new Servicio("Mesa dulce", 60000.0);

        Boolean incluido = servicio.incluyeServicio("Mesa dulce");

        assertTrue(incluido);
    }

    @Test
    void dadoUnServicio_alBuscarOtroNombre_noLoIncluye() {
        Servicio servicio = new Servicio("Mesa dulce", 60000.0);

        Boolean incluido = servicio.incluyeServicio("DJ y sonido");

        assertFalse(incluido);
    }

    @Test
    void dadoUnServicioConPrecioNegativo_alCrearlo_lanzaPrecioNegativoException() {
        Executable creacion = () -> new Servicio("Mesa dulce", -1.0);

        assertThrows(PrecioNegativoException.class, creacion);
    }

    @Test
    void dadoUnServicioConPrecioCero_alCrearlo_aceptaElPrecio() {
        Servicio servicio = new Servicio("Cortesía", 0.0);

        Double precio = servicio.calcularPrecio();

        assertEquals(0.0, precio, 0.001);
    }
}
