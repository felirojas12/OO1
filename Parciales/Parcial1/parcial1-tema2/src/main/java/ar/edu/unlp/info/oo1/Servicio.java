package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Servicio {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Servicio(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public long calcularDias() {
        return ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    }

    public abstract double calcularCosto();
}
