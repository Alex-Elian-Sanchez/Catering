package ar.edu.unahur.Modificaciones;

import ar.edu.unahur.Propuesta.Menu;
import ar.edu.unahur.Propuesta.Propuesta;

public class AgregarPropuesta implements Modificacion {
    private final Menu menu;
    private final Propuesta propuesta;

    public AgregarPropuesta(Menu menu, Propuesta propuesta) {
        this.menu = menu;
        this.propuesta = propuesta;
    }

    @Override
    public void aplicar() {
        menu.agregarPropuesta(propuesta);
    }

    @Override 
    public void revertir() {
        menu.quitarPropuesta(propuesta);
    }  
}
