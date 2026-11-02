package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Contrato {
    private LocalDate fechaInicio;

    protected Contrato(LocalDate fechaInicio) {
        this.fechaInicio = Objects.requireNonNull(fechaInicio);
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public abstract double calcularSalario(Empleado empleado, LocalDate fechaActual);

    public double calcularSalario(Empleado empleado) {
        return calcularSalario(empleado, LocalDate.now());
    }

    public boolean estaVigente() {
        return estaVigente(LocalDate.now());
    }

    public boolean estaVigente(LocalDate fechaActual) {
        return !fechaActual.isBefore(fechaInicio);
    }
}
