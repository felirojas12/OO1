package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonaFisicaTest {
    private PersonaFisica personaFisica;
    private EnvioInternacional envioInternacional;
    private EnvioInterurbano envioInterurbano;
    private EnvioLocal envioLocal;

    @BeforeEach
    void setUp() {
        personaFisica = new PersonaFisica("Juan Perez", "Calle Falsa 123", "12345678");
        envioInternacional = new EnvioInternacional(LocalDate.now(), "Argentina" , "Perú", 500, false);
        envioInterurbano = new EnvioInterurbano(LocalDate.now(), "Calle A, CABA" , "Calle D, Ensenada", 300, 150);
        envioLocal = new EnvioLocal(LocalDate.now(), "La Plata", "La Plata", 500, false);
        personaFisica.agregarEnvio(envioInternacional);
        personaFisica.agregarEnvio(envioInterurbano);
        personaFisica.agregarEnvio(envioLocal);
    }

    @Test
    void testCalcularMonto() {
        DateLapse rango = new DateLapse(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        double montoEsperado = (envioInternacional.calcularCosto() + envioInterurbano.calcularCosto() + envioLocal.calcularCosto()) * 0.9; // Aplicando el descuento del 10%
        assertEquals(montoEsperado, personaFisica.calcularMonto(rango));
    }
}
