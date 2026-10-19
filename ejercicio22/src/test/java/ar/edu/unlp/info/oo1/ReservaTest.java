package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {
    private DateLapse rango;
    private Propiedad propiedad;
    private Reserva reserva;

    @BeforeEach
    void setUp() {
        rango = new DateLapse(LocalDate.of(2024, 6, 10), LocalDate.of(2024, 6, 15));
        propiedad = new Propiedad("Casa", "Calle 1", 1200, new Usuario("Ana", "Calle 2", "123"));
        reserva = new Reserva(rango, propiedad);
    }

    @Test
    void shouldReturnTheDateRangeAndProperty() {
        assertSame(rango, reserva.getRangoDeFechas());
        assertSame(propiedad, reserva.getPropiedad());
    }

    @Test
    void shouldDelegateOverlapToItsDateRange() {
        assertTrue(reserva.overlaps(new DateLapse(
                LocalDate.of(2024, 6, 12), LocalDate.of(2024, 6, 20))));
    }

    @Test
    void shouldCalculateThePriceUsingTheNumberOfNightsAndPropertyPrice() {
        assertEquals(6000, reserva.calcularPrecio());
    }

    @Test
    void shouldUpdateDateRangeAndProperty() {
        DateLapse anotherRange = new DateLapse(
                LocalDate.of(2024, 7, 1), LocalDate.of(2024, 7, 3));
        Propiedad anotherProperty = new Propiedad(
                "Departamento", "Calle 3", 800, new Usuario("Luis", "Calle 4", "456"));

        reserva.setRangoDeFechas(anotherRange);
        reserva.setPropiedad(anotherProperty);

        assertSame(anotherRange, reserva.getRangoDeFechas());
        assertSame(anotherProperty, reserva.getPropiedad());
    }
}
