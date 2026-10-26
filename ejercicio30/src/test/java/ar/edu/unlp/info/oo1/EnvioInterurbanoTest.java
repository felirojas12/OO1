package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnvioInterurbanoTest {
    private EnvioInterurbano envioInterurbanoDistanciaMenorACien;
    private EnvioInterurbano envioInterurbanoDistanciaCien;
    private EnvioInterurbano envioInterurbanoDistanciaMayorAQuinientos;
    private EnvioInterurbano envioInterurbanoDistanciaQuinientos;

    @BeforeEach
    void setUp() {
        envioInterurbanoDistanciaMenorACien = new EnvioInterurbano(LocalDate.now(), "Calle A, CABA" , "Calle D, Ensenada", 300, 99);
        envioInterurbanoDistanciaCien = new EnvioInterurbano(LocalDate.now(), "Calle A, CABA" , "Calle D, Berisso", 300, 100);
        envioInterurbanoDistanciaMayorAQuinientos = new EnvioInterurbano(LocalDate.now(), "Calle A, Magdalena" , "Calle D, CABA", 300, 501);
        envioInterurbanoDistanciaQuinientos = new EnvioInterurbano(LocalDate.now(), "Calle A, Magdalena" , "Calle D, CABA", 300, 500);
    }

    @Test
    void testCalcularCostoMenorACien() {
        assertEquals(300 * 20, envioInterurbanoDistanciaMenorACien.calcularCosto());
    }

    @Test
    void testCalcularCostoEntreCienYQuinientos() {
        assertEquals(300 * 25, envioInterurbanoDistanciaCien.calcularCosto());
        assertEquals(300 * 25, envioInterurbanoDistanciaQuinientos.calcularCosto());
    }

    @Test
    void testCalcularCostoMayorAQuinientos() {
        assertEquals(300 * 30, envioInterurbanoDistanciaMayorAQuinientos.calcularCosto());
    }
}
