package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public abstract class Suscripcion {
    private LocalDate fechaInicio;

    protected Suscripcion(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    private double calcularMontoConIva(double valor) {
        double iva = valor * 0.21;
        return valor + iva;
    }

    private double calcularRecargo(LocalDate fechaPago, double monto) {
        if (fechaPago.isAfter(this.fechaInicio))
            return monto * 0.3;
        return 0;
    }

    public double montoAPagar(LocalDate fechaPago) {
        double costo = this.calcularCosto();
        double recargo = this.calcularRecargo(fechaPago, costo);
        return this.calcularMontoConIva(costo + recargo);
    }

    public abstract double calcularCosto();
}
