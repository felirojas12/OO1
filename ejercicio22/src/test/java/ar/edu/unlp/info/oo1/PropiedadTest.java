package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropiedadTest {
    private Usuario propietario;
    private Propiedad propiedad;

    @BeforeEach
    void setUp() {
        propietario = new Usuario("Ana", "Calle 2", "123");
        propiedad = new Propiedad("Casa", "Calle 1", 1000, propietario);
    }

    @Test
    void shouldBeAvailableWhenThereAreNoReservations() {
        assertTrue(propiedad.consultarDisponibilidad(range("2024-06-10", "2024-06-15")));
    }

    @Test
    void shouldNotBeAvailableWhenTheRequestedRangeOverlapsAReservation() {
        Reserva reserva = new Reserva(range("2024-06-10", "2024-06-15"), propiedad);
        propiedad.agregarReserva(reserva);

        assertFalse(propiedad.consultarDisponibilidad(range("2024-06-12", "2024-06-20")));
    }

    @Test
    void shouldBeAvailableAfterRemovingAReservation() {
        Reserva reserva = new Reserva(range("2024-06-10", "2024-06-15"), propiedad);
        propiedad.agregarReserva(reserva);
        propiedad.quitarReserva(reserva);

        assertTrue(propiedad.consultarDisponibilidad(range("2024-06-12", "2024-06-20")));
    }

    @Test
    void shouldCalculateTheIncomeOfOverlappingReservations() {
        propiedad.agregarReserva(new Reserva(range("2024-06-10", "2024-06-15"), propiedad));
        propiedad.agregarReserva(new Reserva(range("2024-07-01", "2024-07-04"), propiedad));

        assertEquals(8000, propiedad.calcularIngresos(range("2024-06-12", "2024-06-13")));
    }

    private DateLapse range(String from, String to) {
        return new DateLapse(LocalDate.parse(from), LocalDate.parse(to));
    }
}
