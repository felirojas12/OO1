package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class SuscripcionPackPromo extends Suscripcion{
    private int cantidadDias;
    private double precioPorDia;

    public SuscripcionPackPromo(LocalDate fechaInicio, int cantidadDias, double precioPorDia) {
        super(fechaInicio);
        this.cantidadDias = cantidadDias;
        this.precioPorDia = precioPorDia;
    }

    public double calcularCosto() {
        return cantidadDias * precioPorDia;
    }
}
