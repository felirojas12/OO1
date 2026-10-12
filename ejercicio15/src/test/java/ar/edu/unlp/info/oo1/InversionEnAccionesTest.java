package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InversionEnAccionesTest {
    private String nombre;
    private double valorUnitario;

    @BeforeEach
    void setUp() {
        nombre = "ACME";
        valorUnitario = 125.50;
    }

    @Test
    void valorActualDeCantidadCeroEsCero() {
        InversionEnAcciones inversion = new InversionEnAcciones(nombre, 0, valorUnitario);

        assertEquals(0.0, inversion.valorActual(), 0.0001);
    }

    @Test
    void valorActualDeCantidadPositivaEsCantidadPorValorUnitario() {
        InversionEnAcciones inversion = new InversionEnAcciones(nombre, 10, valorUnitario);

        assertEquals(1255.0, inversion.valorActual(), 0.0001);
    }

    @Test
    void valorActualConValorUnitarioCeroEsCero() {
        InversionEnAcciones inversion = new InversionEnAcciones(nombre, 10, 0.0);

        assertEquals(0.0, inversion.valorActual(), 0.0001);
    }
}
