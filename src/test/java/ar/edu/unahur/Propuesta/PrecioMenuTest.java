package ar.edu.unahur.Propuesta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrecioMenuTest {

    @Test
    void dadoUnMenuParrillero_alCalcularPrecio_aplicaElDescuento() {
        Menu menu = EscenariosMenu.menuParrillero();

        Double precio = menu.calcularPrecio();

        assertEquals(342000.0, precio, 0.001);
    }

    @Test
    void dadoUnPackFiesta_alCalcularPrecio_aplicaElDescuento() {
        Menu menu = EscenariosMenu.packFiesta();

        Double precio = menu.calcularPrecio();

        assertEquals(256500.0, precio, 0.001);
    }

    @Test
    void dadoUnMenuVacio_alCalcularPrecio_devuelveCero() {
        Menu menu = new Menu("Menú vacío", 10.0);

        Double precio = menu.calcularPrecio();

        assertEquals(0.0, precio, 0.001);
    }

    @Test
    void dadoUnMenuConDescuentoCero_alCalcularPrecio_noDescuenta() {
        Menu menu = new Menu("Menú sin descuento", 0.0);
        menu.agregarPropuesta(new Servicio("Mesa dulce", 60000.0));

        Double precio = menu.calcularPrecio();

        assertEquals(60000.0, precio, 0.001);
    }

    @Test
    void dadoUnMenuQueContieneOtrosMenus_alCalcularPrecio_aplicaLosDescuentosPorNivel() {
        Menu menu = EscenariosMenu.eventoCompleto();

        Double precio = menu.calcularPrecio();

        assertEquals(518800.0, precio, 0.001);
    }
}
