package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InversorTest {
    private Inversor inversor;
    private InversionEnAcciones inversionEnAcciones;
    private InversionEnPlazoFijo inversionEnPlazoFijo;

    @BeforeEach
    void setUp() {
        inversor = new Inversor();
        inversionEnAcciones = new InversionEnAcciones("ACME", 10, 100.0);
        inversionEnPlazoFijo =
                new InversionEnPlazoFijo(LocalDate.now().minusDays(1), 1000.0, 0.01);
    }

    @Test
    void valorDeInversionesDeCarteraVaciaEsCero() {
        assertEquals(0.0, inversor.valorDeInversiones(), 0.0001);
    }

    @Test
    void valorDeInversionesConUnaInversionEsSuValorActual() {
        inversor.agregarInversion(inversionEnAcciones);

        assertEquals(1000.0, inversor.valorDeInversiones(), 0.0001);
    }

    @Test
    void valorDeInversionesConVariasInversionesEsLaSumaDeSusValores() {
        inversor.agregarInversion(inversionEnAcciones);
        inversor.agregarInversion(inversionEnPlazoFijo);

        assertEquals(2010.0, inversor.valorDeInversiones(), 0.0001);
    }

    @Test
    void eliminarInversionActualizaElValorDeLaCartera() {
        inversor.agregarInversion(inversionEnAcciones);

        inversor.eliminarInversion(inversionEnAcciones);

        assertEquals(0.0, inversor.valorDeInversiones(), 0.0001);
    }
}
