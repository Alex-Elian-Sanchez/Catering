package ar.edu.unahur.Modificaciones;

import ar.edu.unahur.Propuesta.Menu;
import ar.edu.unahur.Propuesta.Servicio;

import java.util.List;

class EscenariosCarta {

    final Servicio parrillada = new Servicio("Parrillada completa", 240000.0);
    final Servicio mesaDulce = new Servicio("Mesa dulce", 60000.0);
    final Servicio fotografo = new Servicio("Fotógrafo", 100000.0);
    final Menu menu = new Menu("Menú Parrillero", 10.0);

    EscenariosCarta() {
        menu.agregarPropuesta(new Servicio("Mesa de entradas", 80000.0));
        menu.agregarPropuesta(parrillada);
        menu.agregarPropuesta(mesaDulce);
    }

    List<Modificacion> modificacionesIniciales() {
        return List.of(
                new AgregarPropuesta(menu, fotografo),
                new ActualizarPrecio(parrillada, 260000.0),
                new QuitarPropuesta(menu, mesaDulce));
    }

}
