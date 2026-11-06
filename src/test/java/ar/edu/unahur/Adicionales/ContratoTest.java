package ar.edu.unahur.Adicionales;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContratoTest {

    @Test
    void dadoUnContratoCreado_alCambiarLaPropuesta_conservaLosDatosAcordados() {
        PropuestaMutableDePrueba menu =
                new PropuestaMutableDePrueba("Menú Parrillero", 342000.0);
        Contrato contrato = new Contrato("Lucía", new MozosAdicionales(menu));

        menu.cambiarPrecio(400000.0);
        menu.cambiarNombre("Menú actualizado");
        List<Object> datos = List.of(
                contrato.getCliente(), contrato.getImporte(), contrato.getDescripcion());

        assertEquals(List.of(
                "Lucía", 360000.0, "Menú Parrillero + Mozos adicionales"), datos);
    }
}
