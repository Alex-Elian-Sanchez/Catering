package ar.edu.unahur.Propuesta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DescripcionMenuTest {

    @Test
    void dadoUnMenuParrillero_alConsultarDescripcion_devuelveSuNombre() {
        Menu menu = EscenariosMenu.menuParrillero();

        String descripcion = menu.descripcion();

        assertEquals("Menú Parrillero", descripcion);
    }
}
