package ar.edu.unahur.Propuesta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CantidadServiciosMenuTest {

    @Test
    void dadoUnMenuParrillero_alContarServicios_devuelveTres() {
        Menu menu = EscenariosMenu.menuParrillero();

        Integer cantidad = menu.cantidadDeServicios();

        assertEquals(Integer.valueOf(3), cantidad);
    }

    @Test
    void dadoUnMenuQueContieneOtrosMenus_alContarServicios_sumaLosDeTodosLosNiveles() {
        Menu menu = EscenariosMenu.eventoCompleto();

        Integer cantidad = menu.cantidadDeServicios();

        assertEquals(Integer.valueOf(6), cantidad);
    }
}
