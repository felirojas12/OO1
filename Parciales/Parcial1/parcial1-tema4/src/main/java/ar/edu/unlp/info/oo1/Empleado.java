package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Empleado {
    private String nombre;
    private LocalDate fechaNacimiento;
    private int cantidadHijos;
    private boolean tieneConyuge;
    private List<Contrato> contratos;

    public Empleado(String nombre, LocalDate fechaNacimiento, int cantidadHijos, boolean tieneConyuge) {
        this.nombre = Objects.requireNonNull(nombre);
        this.fechaNacimiento = Objects.requireNonNull(fechaNacimiento);
        this.cantidadHijos = cantidadHijos;
        this.tieneConyuge = tieneConyuge;
        this.contratos = new ArrayList<>();
    }

    public int calcularAntiguedad(LocalDate fechaActual) {
        Objects.requireNonNull(fechaActual);
        Contrato contrato = contratos.stream()
                .filter(c -> !fechaActual.isBefore(c.getFechaInicio()))
                .min((contrato1, contrato2) ->
                        contrato1.getFechaInicio().compareTo(contrato2.getFechaInicio()))
                .orElse(null);
        if (contrato == null) {
            return 0;
        }
        return Period.between(contrato.getFechaInicio(), fechaActual).getYears();
    }

    public double calcularSueldo(LocalDate fechaActual) {
        Objects.requireNonNull(fechaActual);
        Contrato contrato = contratoVigente(fechaActual);
        if (contrato == null) {
            return 0;
        }
        return contrato.calcularSalario(this, fechaActual);
    }

    private Contrato contratoVigente(LocalDate fechaActual) {
        return contratos.stream()
                .filter(contrato -> contrato.estaVigente(fechaActual))
                .max((contrato1, contrato2) ->
                        contrato1.getFechaInicio().compareTo(contrato2.getFechaInicio()))
                .orElse(null);
    }

    public void agregarContrato(Contrato contrato) {
        contratos.add(Objects.requireNonNull(contrato));
    }

    public void quitarContrato(Contrato contrato) {
        contratos.remove(Objects.requireNonNull(contrato));
    }

    public boolean tieneContrato() {
        return !contratos.isEmpty();
    }

    public int getCantidadHijos() {
        return cantidadHijos;
    }

    public boolean tieneConyuge() {
        return tieneConyuge;
    }

    public String getNombre() {
        return nombre;
    }
}
