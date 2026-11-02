package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public abstract class Actividad {
    protected LocalDate fechaDeInicio;
    protected String ipRegistrada;
    protected double duracionTotal;

    protected Actividad(LocalDate fechaDeInicio, String ipRegistrada, double duracionTotal) {
        this.fechaDeInicio = fechaDeInicio;
        this.ipRegistrada = ipRegistrada;
        this.duracionTotal = duracionTotal;
    }

    public LocalDate getFechaDeInicio() {
        return fechaDeInicio;
    }

    public String getIpRegistrada() {
        return ipRegistrada;
    }

    public abstract double calcularMonto();
}
