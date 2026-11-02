package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class ReproduccionDeVideo extends Actividad{
    private double duracionPublicidad;

    public ReproduccionDeVideo(LocalDate fechaDeInicio, String ipRegistrada, double duracionTotal, double duracionPublicidad) {
        super(fechaDeInicio, ipRegistrada, duracionTotal);
        this.duracionPublicidad = duracionPublicidad;
    }

    public double getDuracionReal() {
        return duracionTotal - duracionPublicidad;
    }

    @Override
    public double calcularMonto() {
        return this.getDuracionReal() * 10;
    }
}
