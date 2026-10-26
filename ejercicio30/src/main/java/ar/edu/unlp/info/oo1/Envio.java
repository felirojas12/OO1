package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public abstract class Envio {
    private LocalDate fecha;
    private String direccionOrigen;
    private String direccionDestino;
    private double pesoEnGramos;

    public Envio(LocalDate fecha, String direccionOrigen, String direccionDestino, double pesoEnGramos) {
        this.fecha = fecha;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.pesoEnGramos = pesoEnGramos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public double getPesoEnGramos() {
        return pesoEnGramos;
    }

    public void setPesoEnGramos(double pesoEnGramos) {
        this.pesoEnGramos = pesoEnGramos;
    }

    public abstract double calcularCosto();
}
