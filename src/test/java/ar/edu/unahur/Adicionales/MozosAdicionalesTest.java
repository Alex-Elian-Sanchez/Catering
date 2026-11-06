package ar.edu.unahur.Adicionales;

import ar.edu.unahur.Propuesta.Propuesta;
import ar.edu.unahur.Propuesta.Servicio;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MozosAdicionalesTest {

    @Test
    void dadoUnServicioConMozos_alConsultarLaPropuesta_sumaElAdicional() {
        Propuesta propuesta = new MozosAdicionales(
                new Servicio("Brindis de bienvenida", 50000.0));

        List<Object> resultado = List.of(
                propuesta.calcularPrecio(), propuesta.descripcion());

        assertEquals(List.of(
                68000.0, "Brindis de bienvenida + Mozos adicionales"), resultado);
    }
}
