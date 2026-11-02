package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public abstract class Envio {
    private LocalDate fecha;
    private String direccionOrigen;
    private String direccionDestino;
    private double pesoEnGramos;

    protected Envio(LocalDate fecha, String direccionOrigen, String direccionDestino, double pesoEnGramos) {
        this.fecha = fecha;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.pesoEnGramos = pesoEnGramos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getPesoEnGramos() {
        return pesoEnGramos;
    }

    public abstract double calcularCosto();
}
