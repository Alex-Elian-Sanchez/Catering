package ar.edu.unahur.Modificaciones;

import ar.edu.unahur.Propuesta.Menu;
import ar.edu.unahur.obj2.catering.Excepciones.PropuestaNoIncluidaException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuitarPropuestaTest {

    @Test
    void dadaUnaQuitaDeMesaDulce_alAplicarlaYRevertirla_recuperaElPrecioOriginal() {
        EscenariosCarta carta = new EscenariosCarta();
        Modificacion quita = new QuitarPropuesta(carta.menu, carta.mesaDulce);
        List<Double> precios = new ArrayList<>();

        quita.aplicar();
        precios.add(carta.menu.calcularPrecio());
        quita.revertir();
        precios.add(carta.menu.calcularPrecio());

        assertEquals(List.of(288000.0, 342000.0), precios);
    }

    @Test
    void dadoUnServicioIncluidoIndirectamente_alQuitarloDelMenuExterior_lanzaExcepcion() {
        EscenariosCarta carta = new EscenariosCarta();
        Menu exterior = new Menu("Evento Completo", 20.0);
        exterior.agregarPropuesta(carta.menu);
        Modificacion quita = new QuitarPropuesta(exterior, carta.mesaDulce);

        Executable aplicacion = () -> quita.aplicar();

        assertThrows(PropuestaNoIncluidaException.class, aplicacion);
    }
}
