package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class AlquilerAuto extends Servicio {
    private double costoPorKilometro;
    private double kilometrosRecorridos;
    private double costoDiarioSeguro;
    private String tipoVehiculo;

    public AlquilerAuto(LocalDate fechaInicio, LocalDate fechaFin, double costoPorKilometro, double kilometrosRecorridos, double costoDiarioSeguro, String tipoVehiculo) {
        super(fechaInicio, fechaFin);
        this.costoPorKilometro = costoPorKilometro;
        this.kilometrosRecorridos = kilometrosRecorridos;
        this.costoDiarioSeguro = costoDiarioSeguro;
        this.tipoVehiculo = tipoVehiculo;
    }

    public double calcularCosto() {
        return (costoPorKilometro * kilometrosRecorridos) + (costoDiarioSeguro * this.calcularDias());
    }
}
