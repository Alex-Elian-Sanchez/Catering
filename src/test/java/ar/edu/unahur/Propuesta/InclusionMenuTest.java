package ar.edu.unahur.Propuesta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InclusionMenuTest {

    @Test
    void dadoUnMenuParrillero_alBuscarParrilladaCompleta_laIncluye() {
        Menu menu = EscenariosMenu.menuParrillero();

        Boolean incluido = menu.incluyeServicio("Parrillada completa");

        assertTrue(incluido);
    }

    @Test
    void dadoUnMenuParrillero_alBuscarDjYSonido_noLoIncluye() {
        Menu menu = EscenariosMenu.menuParrillero();

        Boolean incluido = menu.incluyeServicio("DJ y sonido");

        assertFalse(incluido);
    }

    @Test
    void dadoUnMenuQueContieneOtrosMenus_alBuscarDjYSonido_loIncluye() {
        Menu menu = EscenariosMenu.eventoCompleto();

        Boolean incluido = menu.incluyeServicio("DJ y sonido");

        assertTrue(incluido);
    }

    @Test
    void dadoUnMenuQueContieneOtrosMenus_alBuscarFotografo_noLoIncluye() {
        Menu menu = EscenariosMenu.eventoCompleto();

        Boolean incluido = menu.incluyeServicio("Fotógrafo");

        assertFalse(incluido);
    }
}
