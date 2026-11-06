package ar.edu.unahur.Adicionales;

import ar.edu.unahur.Propuesta.Propuesta;
import ar.edu.unahur.Propuesta.Servicio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdicionalesTest {

    @Test
    void dadoUnAdicionalSobreUnServicio_alContarServicios_conservaLaCantidad() {
        Propuesta adicional = new ServicioNocturno(
                new MozosAdicionales(new Servicio("Mesa dulce", 60000.0)));

        Integer cantidad = adicional.cantidadDeServicios();

        assertEquals(Integer.valueOf(1), cantidad);
    }

    @Test
    void dadoUnAdicionalSobreUnServicio_alConsultarDescripcion_agregaSuNombre() {
        Propuesta adicional = new MozosAdicionales(
                new Servicio("Mesa dulce", 60000.0));

        String descripcion = adicional.descripcion();

        assertEquals("Mesa dulce + Mozos adicionales", descripcion);
    }

    @Test
    void dadoUnAdicionalSobreUnServicio_alBuscarElServicioOriginal_loIncluye() {
        Propuesta adicional = new MozosAdicionales(
                new Servicio("Mesa dulce", 60000.0));

        Boolean incluido = adicional.incluyeServicio("Mesa dulce");

        assertTrue(incluido);
    }
}
