package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class Estadia extends Servicio{
    private String destino;
    private double costoPorDia;
    private int cantidadDePersonas;

    public Estadia(String destino, double costoPorDia, int cantidadDePersonas, LocalDate fechaInicio, LocalDate fechaFin) {
        super(fechaInicio, fechaFin);
        this.destino = destino;
        this.costoPorDia = costoPorDia;
        this.cantidadDePersonas = cantidadDePersonas;
    }
    @Override
    public double calcularCosto() {
        return this.calcularDias() * costoPorDia * cantidadDePersonas;
    }
}
