package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class SuscripcionPorUso extends Suscripcion{
    private double gbLimite;
    private double precioPorGb;

    public SuscripcionPorUso(LocalDate fechaInicio, double gbLimite, double precioPorGb) {
        super(fechaInicio);
        this.gbLimite = gbLimite;
        this.precioPorGb = precioPorGb;
    }

    public double calcularCosto() {
        return gbLimite * precioPorGb;
    }
}
