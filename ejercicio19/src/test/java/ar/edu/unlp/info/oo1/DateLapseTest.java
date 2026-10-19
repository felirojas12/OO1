package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateLapseTest {
    private LocalDate from;
    private LocalDate to;
    private DateLapse dateLapse;

    @BeforeEach
    void setUp() {
        from = LocalDate.of(2024, 5, 10);
        to = LocalDate.of(2024,5,20);
        dateLapse = new DateLapse(from, 10);
    }

    @Test
    void shouldReturnTheDatesUsedToCreateTheLapse() {
        assertEquals(from, dateLapse.getFrom());
        assertEquals(to, dateLapse.getTo());
    }

    @Test
    void shouldReturnTheNumberOfDaysBetweenTheDates() {
        assertEquals(10, dateLapse.sizeInDays());
    }

}
