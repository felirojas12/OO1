package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCajaDeAhorro {
    private CajaDeAhorro bbva;

    @BeforeEach
    void setUp() {
        bbva = new CajaDeAhorro();
    }

    @Test
    void testDepositar() {
        bbva.depositar(100);
        assertEquals(98, bbva.getSaldo());
    }

    @Test
    void testExtraerSaldo() {
        bbva.depositar(100);
        bbva.extraer(50);
        assertEquals(47, bbva.getSaldo());
    }

    @Test
    void testExtraerSaldoInsuficiente() {
        bbva.setSaldo(100);
        assertFalse(bbva.extraer(100));
        assertEquals(100, bbva.getSaldo());
    }

    @Test
    void testTransferirACuenta() {
        CajaDeAhorro cuentaDni = new CajaDeAhorro();
        bbva.depositar(100);
        assertEquals(98, bbva.getSaldo());
        assertFalse(bbva.transferirACuenta(100,cuentaDni));
        assertEquals(98, bbva.getSaldo());
        assertEquals(0, cuentaDni.getSaldo());
        assertTrue(bbva.transferirACuenta(50,cuentaDni));
        assertEquals(47, bbva.getSaldo());
        assertEquals(49, cuentaDni.getSaldo());
    }

    @Test
    void testTransferirACuentaCorriente() {
        CuentaCorriente bancoNacion = new CuentaCorriente();
        bbva.depositar(100);
        assertEquals(98, bbva.getSaldo());
        assertFalse(bbva.transferirACuenta(100,bancoNacion));
        assertEquals(98, bbva.getSaldo());
        assertEquals(0, bancoNacion.getSaldo());
        assertTrue(bbva.transferirACuenta(50,bancoNacion));
        assertEquals(47, bbva.getSaldo());
        assertEquals(50, bancoNacion.getSaldo());
    }
}
