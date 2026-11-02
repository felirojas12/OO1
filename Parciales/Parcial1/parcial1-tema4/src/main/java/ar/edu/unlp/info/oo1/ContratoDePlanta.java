package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.Objects;

public class ContratoDePlanta extends Contrato {
    private double sueldoMensual;
    private double montoConyuge;
    private double montoHijos;

    public ContratoDePlanta(LocalDate fechaInicio, double sueldoMensual,
                            double montoConyuge, double montoHijos) {
        super(fechaInicio);
        if (sueldoMensual < 0 || montoConyuge < 0 || montoHijos < 0) {
            throw new IllegalArgumentException("Los importes no pueden ser negativos");
        }
        this.sueldoMensual = sueldoMensual;
        this.montoConyuge = montoConyuge;
        this.montoHijos = montoHijos;
    }

    @Override
    public double calcularSalario(Empleado empleado, LocalDate fechaActual) {
        Objects.requireNonNull(empleado);
        Objects.requireNonNull(fechaActual);
        double salario = sueldoMensual;
        if (empleado.calcularAntiguedad(fechaActual) > 10) {
            salario *= 1.20;
        }
        if (empleado.tieneConyuge()) {
            salario += sueldoMensual * 0.05;
        }
        salario += empleado.getCantidadHijos() * montoHijos;
        return salario;
    }

    public double calcularSueldoBase(Empleado empleado) {
        Objects.requireNonNull(empleado);
        return sueldoMensual;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    public double getMontoConyuge() {
        return montoConyuge;
    }

    public double getMontoHijos() {
        return montoHijos;
    }
}
