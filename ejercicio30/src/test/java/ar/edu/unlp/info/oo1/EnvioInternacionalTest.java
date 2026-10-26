package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnvioInternacionalTest {
    private EnvioInternacional envioInternacionalRapido;
    private EnvioInternacional envioInternacionalNormal;
    private EnvioInternacional envioInternacionalLigero;
    private EnvioInternacional envioInternacionalMil;
    private EnvioInternacional envioInternacionalPesado;

    @BeforeEach
    void setUp() {
        envioInternacionalLigero = new EnvioInternacional(LocalDate.now(), "Calle A, CABA" , "Calle D, Ensenada", 500, false);
        envioInternacionalMil = new EnvioInternacional(LocalDate.now(), "Calle A, CABA" , "Calle D, Ensenada", 1000, false);
        envioInternacionalPesado = new EnvioInternacional(LocalDate.now(), "Calle A, CABA" , "Calle D, Ensenada", 1500, false);
        envioInternacionalRapido = new EnvioInternacional(LocalDate.now(), "Calle A, CABA" , "Calle D, Ensenada", 300, true);
    }

    @Test
    void testCalcularCostoEnvioInternacionalLigero() {
        assertEquals(5000 + (500 * 10), envioInternacionalLigero.calcularCosto());
    }

    @Test
    void testCalcularCostoEnvioInternacionalMil() {
        assertEquals(5000 + (1000 * 10), envioInternacionalMil.calcularCosto());
    }

    @Test
    void testCalcularCostoEnvioInternacionalPesado() {
        assertEquals(5000 + (1500 * 12), envioInternacionalPesado.calcularCosto());
    }

    @Test
    void testCalcularCostoEnvioInternacionalRapido() {
        assertEquals(5000 + (300 * 10) + 800, envioInternacionalRapido.calcularCosto());
    }
}
