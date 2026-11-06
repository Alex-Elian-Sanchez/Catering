package ar.edu.unahur.Modificaciones;

import ar.edu.unahur.obj2.catering.Excepciones.PropuestaNoIncluidaException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GestorCartaTest {

    @Test
    void dadaLaSecuenciaInmediata_alAplicarlaYRevertirla_respetaLosPreciosEsperados() {
        EscenariosCarta carta = new EscenariosCarta();
        GestorCarta gestor = new GestorCarta();
        List<Double> precios = new ArrayList<>();
        precios.add(carta.menu.calcularPrecio());

        for (Modificacion modificacion : carta.modificacionesIniciales()) {
            gestor.aplicar(modificacion);
            precios.add(carta.menu.calcularPrecio());
        }
        for (Integer cantidad = 0; cantidad < 3; cantidad++) {
            gestor.revertirUltima();
            precios.add(carta.menu.calcularPrecio());
        }

        assertEquals(List.of(
                342000.0, 432000.0, 450000.0, 396000.0,
                450000.0, 432000.0, 342000.0), precios);
    }

    @Test
    void dadoUnLoteValido_alAplicarloYRevertirlo_deshaceCadaCambioPorSeparado() {
        EscenariosCarta carta = new EscenariosCarta();
        GestorCarta gestor = new GestorCarta();
        List<Double> precios = new ArrayList<>();

        gestor.aplicarLote(carta.modificacionesIniciales());
        precios.add(carta.menu.calcularPrecio());
        for (Integer cantidad = 0; cantidad < 3; cantidad++) {
            gestor.revertirUltima();
            precios.add(carta.menu.calcularPrecio());
        }

        assertEquals(List.of(396000.0, 450000.0, 432000.0, 342000.0), precios);
    }

    @Test
    void dadoUnLoteFallido_alAplicarlo_restauraLosPreciosYConservaElHistorialPrevio() {
        EscenariosCarta carta = new EscenariosCarta();
        GestorCarta gestor = new GestorCarta();
        gestor.aplicar(new AgregarPropuesta(carta.menu, carta.fotografo));
        List<Modificacion> lote = List.of(
                new ActualizarPrecio(carta.parrillada, 260000.0),
                new QuitarPropuesta(carta.menu, carta.fotografo),
                new QuitarPropuesta(carta.menu, carta.fotografo));
        List<Double> precios = new ArrayList<>();

        try {
            gestor.aplicarLote(lote);
        } catch (PropuestaNoIncluidaException excepcion) {
            precios.add(carta.menu.calcularPrecio());
            precios.add(carta.parrillada.calcularPrecio());
            gestor.revertirUltima();
            precios.add(carta.menu.calcularPrecio());
        }

        assertEquals(List.of(432000.0, 240000.0, 342000.0), precios);
    }

}
