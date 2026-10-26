package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class EnvioInternacional extends EnvioVariable{
    public EnvioInternacional(LocalDate fecha, String direccionOrigen, String direccionDestino, double pesoEnGramos, boolean envioRapido) {
        super(fecha, direccionOrigen, direccionDestino, pesoEnGramos, envioRapido);
    }

    private double calcularCostoBase() {
        if (this.getPesoEnGramos() <= 1000) {
            return 10;
        } else {
            return 12;
        }
    }

    public double calcularCosto() {
        double suma = 5000 + (this.getPesoEnGramos() * this.calcularCostoBase());
        if (this.isEnvioRapido())
            suma += 800;
        return suma;
    }
}
