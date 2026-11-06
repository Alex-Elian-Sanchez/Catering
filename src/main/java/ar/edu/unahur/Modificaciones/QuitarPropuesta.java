package ar.edu.unahur.Modificaciones;

import ar.edu.unahur.Propuesta.Menu;
import ar.edu.unahur.Propuesta.Propuesta;

public class QuitarPropuesta implements Modificacion {

    private final Menu menu;
    private final Propuesta propuesta;

    public QuitarPropuesta(Menu menu, Propuesta propuesta) {
        this.menu = menu;
        this.propuesta = propuesta;
    }

    @Override
    public void aplicar() {
        menu.quitarPropuesta(propuesta);
    }

    @Override
    public void revertir() {
        menu.agregarPropuesta(propuesta);
    }
}
