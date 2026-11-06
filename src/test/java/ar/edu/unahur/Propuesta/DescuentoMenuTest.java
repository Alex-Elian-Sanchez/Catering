package ar.edu.unahur.Propuesta;

import ar.edu.unahur.obj2.catering.Excepciones.DescuentoInvalidoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DescuentoMenuTest {

    @Test
    void dadoUnMenuConDescuentoNegativo_alCrearlo_lanzaDescuentoInvalidoException() {
        Executable creacion = () -> new Menu("Menú inválido", -1.0);

        assertThrows(DescuentoInvalidoException.class, creacion);
    }

    @Test
    void dadoUnMenuConDescuentoMayorACien_alCrearlo_lanzaDescuentoInvalidoException() {
        Executable creacion = () -> new Menu("Menú inválido", 101.0);

        assertThrows(DescuentoInvalidoException.class, creacion);
    }

    @Test
    void dadoUnMenuConDescuentoCien_alConsultarDescuento_devuelveCien() {
        Menu menu = new Menu("Menú de cortesía", 100.0);

        Double descuento = menu.getDescuento();

        assertEquals(100.0, descuento, 0.001);
    }
}
