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

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public int sizeInDays() {
        return (int) ChronoUnit.DAYS.between(from, to);
    }

    public boolean includes(LocalDate date) {
        return (date.isEqual(from) || date.isAfter(from)) && (date.isEqual(to) || date.isBefore(to));
    }

    public boolean overlaps(DateLapse other) {
        return this.includes(other.getFrom()) || this.includes(other.getTo()) || other.includes(this.getFrom()) || other.includes(this.getTo());
    }
}
