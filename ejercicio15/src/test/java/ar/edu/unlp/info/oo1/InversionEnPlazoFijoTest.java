package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InversionEnPlazoFijoTest {
    private double montoDepositado;
    private double interesDiario;

    @BeforeEach
    void setUp() {
        montoDepositado = 1000.0;
        interesDiario = 0.01;
    }

    @Test
    void valorActualElDiaDeConstitucionEsElMontoDepositado() {
        InversionEnPlazoFijo inversion =
                new InversionEnPlazoFijo(LocalDate.now(), montoDepositado, interesDiario);

        assertEquals(1000.0, inversion.valorActual(), 0.0001);
    }

    @Test
    void valorActualUnDiaDespuesIncluyeElInteresDiario() {
        InversionEnPlazoFijo inversion =
                new InversionEnPlazoFijo(LocalDate.now().minusDays(1), montoDepositado, interesDiario);

        assertEquals(1010.0, inversion.valorActual(), 0.0001);
    }

    @Test
    void valorActualConInteresCeroPermaneceIgualAlMonto() {
        InversionEnPlazoFijo inversion =
                new InversionEnPlazoFijo(LocalDate.now().minusDays(30), montoDepositado, 0.0);

        assertEquals(1000.0, inversion.valorActual(), 0.0001);
    }
}
