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
        to = LocalDate.of(2024, 5, 20);
        dateLapse = new DateLapse(from, to);
    }

    @Test
    void shouldReturnTheDatesUsedToCreateTheLapse() {
        assertEquals(from, dateLapse.getFrom());
        assertEquals(to, dateLapse.getTo());
    }

    @Test
    void shouldReturnZeroDaysForAnLapseWithTheSameStartAndEndDate() {
        DateLapse oneDay = new DateLapse(from, from);

        assertEquals(0, oneDay.sizeInDays());
    }

    @Test
    void shouldReturnOneDayForConsecutiveDates() {
        DateLapse oneDay = new DateLapse(from, from.plusDays(1));

        assertEquals(1, oneDay.sizeInDays());
    }

    @Test
    void shouldReturnTheNumberOfDaysBetweenTheDates() {
        assertEquals(10, dateLapse.sizeInDays());
    }

    @Test
    void shouldIncludeTheStartDate() {
        assertTrue(dateLapse.includes(from));
    }

    @Test
    void shouldIncludeTheEndDate() {
        assertTrue(dateLapse.includes(to));
    }

    @Test
    void shouldIncludeAnInteriorDate() {
        assertTrue(dateLapse.includes(from.plusDays(1)));
    }

    @Test
    void shouldNotIncludeADateBeforeTheStart() {
        assertFalse(dateLapse.includes(from.minusDays(1)));
    }

    @Test
    void shouldNotIncludeADateAfterTheEnd() {
        assertFalse(dateLapse.includes(to.plusDays(1)));
    }

    @Test
    void shouldOverlapWhenTheOtherLapseStartsInsideThisLapse() {
        DateLapse other = new DateLapse(from.plusDays(2), to.plusDays(2));

        assertTrue(dateLapse.overlaps(other));
    }

    @Test
    void shouldOverlapWhenTheOtherLapseContainsThisLapse() {
        DateLapse other = new DateLapse(from.minusDays(2), to.plusDays(2));

        assertTrue(dateLapse.overlaps(other));
    }

    @Test
    void shouldNotOverlapWhenLapsesAreSeparated() {
        DateLapse other = new DateLapse(to.plusDays(1), to.plusDays(3));

        assertFalse(dateLapse.overlaps(other));
    }
}
