package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
    private LocalDate from;
    private int sizeInDays;

    public DateLapse(LocalDate from, int sizeInDays) {
        this.from = from;
        this.sizeInDays = sizeInDays;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return from.plusDays(sizeInDays);
    }

    public int sizeInDays() {
        return sizeInDays;
    }

}
