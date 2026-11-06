package ar.edu.unahur.Modificaciones;

import ar.edu.unahur.Adicionales.Contrato;
import ar.edu.unahur.obj2.catering.Excepciones.PrecioNegativoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ActualizarPrecioTest {

    @Test
    void dadasDosActualizacionesCreadasAntesDeAplicarse_alRevertirlas_recuperaCadaPrecioAnterior() {
        EscenariosCarta carta = new EscenariosCarta();
        Modificacion primera = new ActualizarPrecio(carta.parrillada, 260000.0);
        Modificacion segunda = new ActualizarPrecio(carta.parrillada, 300000.0);
        List<Double> precios = new ArrayList<>();

        primera.aplicar();
        segunda.aplicar();
        precios.add(carta.parrillada.calcularPrecio());
        segunda.revertir();
        precios.add(carta.parrillada.calcularPrecio());
        primera.revertir();
        precios.add(carta.parrillada.calcularPrecio());

        assertEquals(List.of(300000.0, 260000.0, 240000.0), precios);
    }

    @Test
    void dadaUnaActualizacionNegativa_alAplicarla_lanzaPrecioNegativoException() {
        EscenariosCarta carta = new EscenariosCarta();
        Modificacion actualizacion = new ActualizarPrecio(carta.parrillada, -1.0);

        Executable aplicacion = () -> actualizacion.aplicar();

        assertThrows(PrecioNegativoException.class, aplicacion);
    }

    @Test
    void dadoUnContratoCreado_alActualizarLaCarta_conservaElImporteAcordado() {
        EscenariosCarta carta = new EscenariosCarta();
        Contrato contrato = new Contrato("Lucía", carta.menu);
        Modificacion actualizacion = new ActualizarPrecio(carta.parrillada, 260000.0);

        actualizacion.aplicar();
        List<Double> importes = List.of(
                carta.menu.calcularPrecio(), contrato.getImporte());

        assertEquals(List.of(360000.0, 342000.0), importes);
    }
}
