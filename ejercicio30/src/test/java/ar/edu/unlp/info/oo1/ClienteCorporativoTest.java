package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteCorporativoTest {
    private ClienteCorporativo clienteCorporativo;
    private EnvioLocal envioLocal;
    private EnvioInterurbano envioInterurbano;
    private EnvioInternacional envioInternacional;

    @BeforeEach
    void setUp() {
        clienteCorporativo = new ClienteCorporativo("Empresa S.A.", "Calle Principal 456", "1234567890");
        envioInternacional = new EnvioInternacional(LocalDate.now(), "Argentina" , "Perú", 500, false);
        envioInterurbano = new EnvioInterurbano(LocalDate.now(), "Calle A, CABA" , "Calle D, Ensenada", 300, 150);
        envioLocal = new EnvioLocal(LocalDate.now(), "La Plata", "La Plata", 500, false);
        clienteCorporativo.agregarEnvio(envioInternacional);
        clienteCorporativo.agregarEnvio(envioInterurbano);
        clienteCorporativo.agregarEnvio(envioLocal);
    }

    @Test
    void testCalcularMonto() {
        DateLapse rango = new DateLapse(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        double montoEsperado = envioInternacional.calcularCosto() + envioInterurbano.calcularCosto() + envioLocal.calcularCosto();
        assertEquals(montoEsperado, clienteCorporativo.calcularMonto(rango));
    }
}
