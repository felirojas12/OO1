package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
    private LocalDate from;
    private LocalDate to;

    public DateLapse(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public boolean includes(LocalDate date) {
        return (date.isEqual(from) || date.isAfter(from)) && (date.isEqual(to) || date.isBefore(to));
    }

}
