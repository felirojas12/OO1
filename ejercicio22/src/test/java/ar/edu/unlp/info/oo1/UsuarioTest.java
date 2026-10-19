package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
    private Usuario usuario;
    private Propiedad propiedad;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Juan", "Calle 1", "123");
        propiedad = new Propiedad("Casa", "Calle 2", 1000, usuario);
    }

    @Test
    void shouldCreateAReservationWhenThePropertyIsAvailable() {
        assertTrue(usuario.crearReserva(propiedad, range(2, 5)));
        assertFalse(propiedad.consultarDisponibilidad(range(3, 4)));
    }

    @Test
    void shouldNotCreateAReservationWhenThePropertyIsUnavailable() {
        assertTrue(usuario.crearReserva(propiedad, range(2, 5)));

        assertFalse(usuario.crearReserva(propiedad, range(4, 7)));
    }

    @Test
    void shouldNotCancelAReservationThatIsNotOwnedByTheUser() {
        DateLapse rango = new DateLapse(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        Reserva reserva = new Reserva(rango, propiedad);

        assertFalse(usuario.cancelarReserva(reserva));
    }

    private DateLapse range(long fromOffset, long toOffset) {
        return new DateLapse(
                LocalDate.now().plusDays(fromOffset),
                LocalDate.now().plusDays(toOffset));
    }
}
