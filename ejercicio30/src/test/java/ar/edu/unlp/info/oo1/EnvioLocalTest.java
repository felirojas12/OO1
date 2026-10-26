package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnvioLocalTest {
    private EnvioLocal envioNormal;
    private EnvioLocal envioRapido;

    @BeforeEach
    void setUp() {
        envioNormal = new EnvioLocal(LocalDate.now(), "La Plata", "Ensenada", 500, false);
        envioRapido = new EnvioLocal(LocalDate.now(), "Ensenada", "Berisso", 725, true);
    }

    @Test
    void testCalcularContoEnvioRapido() {
        assertEquals(1500, envioRapido.calcularCosto());
    }

    @Test
    void testCalcularContoEnvioNormal() {
        assertEquals(1000, envioNormal.calcularCosto());
    }
}
