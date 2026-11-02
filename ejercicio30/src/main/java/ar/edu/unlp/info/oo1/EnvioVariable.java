package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public abstract class EnvioVariable extends Envio{
    private boolean envioRapido;

    public EnvioVariable(LocalDate fecha, String direccionOrigen, String direccionDestino, double pesoEnGramos, boolean envioRapido) {
        super(fecha, direccionOrigen, direccionDestino, pesoEnGramos);
        this.envioRapido = envioRapido;
    }

    public boolean isEnvioRapido() {
        return envioRapido;
    }

    public abstract double calcularCosto();
}
