package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class EnvioLocal extends EnvioVariable{
    public EnvioLocal(LocalDate fecha, String direccionOrigen, String direccionDestino, double pesoEnGramos, boolean envioRapido) {
        super(fecha, direccionOrigen, direccionDestino, pesoEnGramos, envioRapido);
    }

    public double calcularCosto() {
        double suma = 1000;
        if (this.isEnvioRapido())
            suma += 500;
        return suma;
    }
}
