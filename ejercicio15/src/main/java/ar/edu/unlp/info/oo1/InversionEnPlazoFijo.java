package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class InversionEnPlazoFijo implements Inversion {
    private LocalDate fechaDeConstitucion;
    private double montoDepositado;
    private double interesDiario;

    public InversionEnPlazoFijo() {
        this(LocalDate.now(), 0.0, 0.0);
    }

    public InversionEnPlazoFijo(LocalDate fechaDeConstitucion, double montoDepositado, double interesDiario) {
        this.fechaDeConstitucion = fechaDeConstitucion;
        this.montoDepositado = montoDepositado;
        this.interesDiario = interesDiario;
    }

    @Override
    public double valorActual() {
        long dias = ChronoUnit.DAYS.between(fechaDeConstitucion, LocalDate.now());
        return montoDepositado + (montoDepositado * interesDiario * dias);
    }
}
