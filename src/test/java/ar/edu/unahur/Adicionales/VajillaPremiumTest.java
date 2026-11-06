package ar.edu.unahur.Adicionales;

import ar.edu.unahur.Propuesta.Propuesta;
import ar.edu.unahur.Propuesta.Servicio;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VajillaPremiumTest {

    @Test
    void dadoUnBrindisConDosVajillas_alConsultarLaPropuesta_sumaAmbosAdicionales() {
        Propuesta propuesta = new VajillaPremium(
                new VajillaPremium(new Servicio("Brindis de bienvenida", 50000.0)));

        List<Object> resultado = List.of(
                propuesta.calcularPrecio(), propuesta.descripcion());

        assertEquals(List.of(
                74000.0,
                "Brindis de bienvenida + Vajilla premium + Vajilla premium"), resultado);
    }
}
