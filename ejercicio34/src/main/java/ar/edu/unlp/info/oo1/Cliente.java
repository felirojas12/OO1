package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cliente {
    private String nombre;
    private LocalDate fechaDeAlta;
    private Plan planContratado;
    private List<Actividad> actividades;

    public Cliente(String nombre, LocalDate fechaDeAlta) {
        this.nombre = nombre;
        this.fechaDeAlta = fechaDeAlta;
    }

    public Cliente(String nombre, LocalDate fechaDeAlta, Plan planContratado) {
        this.nombre = nombre;
        this.fechaDeAlta = fechaDeAlta;
        this.planContratado = planContratado;
        this.actividades = new ArrayList<>();
    }

    public void setPlanContratado(Plan planContratado) {
        this.planContratado = planContratado;
    }

    public void agregarActividad(Actividad actividad) {
        actividades.add(actividad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(LocalDate fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public int getAntiguedad() {
        return Period.between(fechaDeAlta, LocalDate.now()).getYears();
    }

    private Set<String> obtenerIps(DateLapse rango) {
        Set<String> ips = new HashSet<>();
        actividades.stream()
                .filter(actividad -> rango.includes(actividad.getFechaDeInicio()))
                .forEach(actividad -> ips.add(actividad.getIpRegistrada()));
        return ips;
    }

    public double calcularMontoTotal(DateLapse rango) {
        Set<String> ips = obtenerIps(rango);
        int cantidadDeIps = ips.size();
        double precioActividades = actividades.stream()
                .filter(actividad -> rango.includes(actividad.getFechaDeInicio()))
                .mapToDouble(Actividad::calcularMonto)
                .sum();
        double precioBase = planContratado.calcularPrecioBase();
        double penalizacion = planContratado.calcularPenalizacion(cantidadDeIps, this);
        return precioBase + penalizacion + precioActividades;
    }
}
