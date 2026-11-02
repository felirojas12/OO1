package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class EnvioInterurbano extends Envio {
    private double distanciaEnKm;

    public EnvioInterurbano(LocalDate fecha, String direccionOrigen, String direccionDestino, double pesoEnGramos, double distanciaEnKm) {
        super(fecha, direccionOrigen, direccionDestino, pesoEnGramos);
        this.distanciaEnKm = distanciaEnKm;
    }

    private double calcularCostoBase() {
        if (distanciaEnKm < 100) {
            return 20;
        } else if (distanciaEnKm <= 500) {
            return 25;
        } else {
            return 30;
        }
    }

    public double calcularCosto() {
        return this.getPesoEnGramos() * this.calcularCostoBase();
    }
}
