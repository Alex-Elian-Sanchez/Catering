package ar.edu.unahur.Propuesta;

class EscenariosMenu {

    static Menu menuParrillero() {
        Menu menu = new Menu("Menú Parrillero", 10.0);
        menu.agregarPropuesta(new Servicio("Mesa de entradas", 80000.0));
        menu.agregarPropuesta(new Servicio("Parrillada completa", 240000.0));
        menu.agregarPropuesta(new Servicio("Mesa dulce", 60000.0));
        return menu;
    }

    static Menu packFiesta() {
        Menu menu = new Menu("Pack Fiesta", 5.0);
        menu.agregarPropuesta(new Servicio("Barra de tragos", 150000.0));
        menu.agregarPropuesta(new Servicio("DJ y sonido", 120000.0));
        return menu;
    }

    static Menu eventoCompleto() {
        Menu menu = new Menu("Evento Completo", 20.0);
        menu.agregarPropuesta(menuParrillero());
        menu.agregarPropuesta(packFiesta());
        menu.agregarPropuesta(new Servicio("Brindis de bienvenida", 50000.0));
        return menu;
    }
}
