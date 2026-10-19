package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String direccion;
    private String DNI;
    private List<Reserva> reservas;
    private List<Propiedad> propiedades;

    public Usuario(String nombre, String direccion, String DNI) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.DNI = DNI;
        this.reservas = new ArrayList<>();
        this.propiedades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public boolean crearReserva(Propiedad p, DateLapse rango) {
        if (p.consultarDisponibilidad(rango)) {
            Reserva nuevaReserva = new Reserva(rango, p);
            this.reservas.add(nuevaReserva);
            p.agregarReserva(nuevaReserva);
            return true;
        }
        return false;
    }

    public boolean cancelarReserva(Reserva r) {
        if (!r.getRangoDeFechas().includes(LocalDate.now()) && reservas.contains(r)) {
            reservas.remove(r);
            r.getPropiedad().quitarReserva(r);
            return true;
        }
        return false;
    }

    public double calcularIngresoPropietario(DateLapse rango) {
        return (propiedades.stream()
                .mapToDouble(propiedad -> propiedad.calcularIngresos(rango))
                .sum()) * 0.75;
    }
}
