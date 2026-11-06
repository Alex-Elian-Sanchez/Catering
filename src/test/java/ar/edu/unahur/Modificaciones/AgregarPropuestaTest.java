package ar.edu.unahur.Modificaciones;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgregarPropuestaTest {

    @Test
    void dadoUnAgregadoDeFotografo_alAplicarloYRevertirlo_recuperaElPrecioOriginal() {
        EscenariosCarta carta = new EscenariosCarta();
        Modificacion agregado = new AgregarPropuesta(carta.menu, carta.fotografo);
        List<Double> precios = new ArrayList<>();

        agregado.aplicar();
        precios.add(carta.menu.calcularPrecio());
        agregado.revertir();
        precios.add(carta.menu.calcularPrecio());

        assertEquals(List.of(432000.0, 342000.0), precios);
    }
}
