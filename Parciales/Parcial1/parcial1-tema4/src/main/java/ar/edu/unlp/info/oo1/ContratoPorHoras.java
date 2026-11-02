package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class ContratoPorHoras extends Contrato {
    private double valorHora;
    private int horasMensuales;
    private LocalDate fechaFin;

    public ContratoPorHoras(LocalDate fechaInicio, double valorHora, int horasMensuales, LocalDate fechaFin) {
        super(fechaInicio);
        if (valorHora < 0 || horasMensuales < 0) {
            throw new IllegalArgumentException("Los valores del contrato no pueden ser negativos");
        }
        this.valorHora = valorHora;
        this.horasMensuales = horasMensuales;
        this.fechaFin = fechaFin;
    }

    @Override
    public double calcularSalario(Empleado empleado, LocalDate fechaActual) {
        return valorHora * horasMensuales;
    }

    public double getValorHora() {
        return valorHora;
    }

    public int getHorasMensuales() {
        return horasMensuales;
    }
}
