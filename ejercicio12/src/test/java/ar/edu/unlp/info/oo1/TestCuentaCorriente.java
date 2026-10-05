package ar.edu.unlp.info.oo1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCuentaCorriente {
    private CuentaCorriente bbva;

    @BeforeEach
    void setUp() {
        bbva = new CuentaCorriente();
    }

    @Test
    void testDepositar() {
        bbva.depositar(100);
        assertEquals(100,bbva.getSaldo());
    }

    @Test
    void testExtraerExito() {
        bbva.setLimiteDescubierto(500);
        assertTrue(bbva.extraer(300));
        assertEquals(-300,bbva.getSaldo());
    }

    @Test
    void testExtraerFallo() {
        bbva.setLimiteDescubierto(500);
        assertFalse(bbva.extraer(600));
        assertEquals(0, bbva.getSaldo());
    }

    @Test
    void testTransferirACuenta() {
        bbva.setLimiteDescubierto(200);
        CuentaCorriente cuentaDni = new CuentaCorriente();
        assertFalse(bbva.transferirACuenta(300,cuentaDni));
        assertEquals(0,bbva.getSaldo());
        assertEquals(0,cuentaDni.getSaldo());
        assertTrue(bbva.transferirACuenta(100,cuentaDni));
        assertEquals(-100,bbva.getSaldo());
        assertEquals(100,cuentaDni.getSaldo());
    }

    @Test
    void testTransferirACajaDeAhorro() {
        bbva.setLimiteDescubierto(200);
        CajaDeAhorro bancoNacion = new CajaDeAhorro();
        assertFalse(bbva.transferirACuenta(300,bancoNacion));
        assertEquals(0,bbva.getSaldo());
        assertEquals(0,bancoNacion.getSaldo());
        assertTrue(bbva.transferirACuenta(100,bancoNacion));
        assertEquals(-100,bbva.getSaldo());
        assertEquals(98,bancoNacion.getSaldo());
    }
}
