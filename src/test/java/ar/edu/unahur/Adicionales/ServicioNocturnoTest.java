package ar.edu.unahur.Adicionales;

import ar.edu.unahur.Propuesta.Menu;
import ar.edu.unahur.Propuesta.Propuesta;
import ar.edu.unahur.Propuesta.Servicio;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioNocturnoTest {

    @Test
    void dadoUnServicioNocturnoCombinadoConMozos_alConsultarLaPropuesta_respetaElOrden() {
        Propuesta mozosAntes = new ServicioNocturno(
                new MozosAdicionales(menuParrillero()));
        Propuesta nocturnoAntes = new MozosAdicionales(
                new ServicioNocturno(menuParrillero()));

        List<Object> resultados = List.of(
                mozosAntes.calcularPrecio(), mozosAntes.descripcion(),
                nocturnoAntes.calcularPrecio(), nocturnoAntes.descripcion());

        assertEquals(List.of(
                432000.0,
                "Menú Parrillero + Mozos adicionales + Servicio nocturno",
                428400.0,
                "Menú Parrillero + Servicio nocturno + Mozos adicionales"), resultados);
    }

    private Menu menuParrillero() {
        Menu menu = new Menu("Menú Parrillero", 10.0);
        menu.agregarPropuesta(new Servicio("Mesa de entradas", 80000.0));
        menu.agregarPropuesta(new Servicio("Parrillada completa", 240000.0));
        menu.agregarPropuesta(new Servicio("Mesa dulce", 60000.0));
        return menu;
    }
}
