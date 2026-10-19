package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public class Propiedad {
    private String nombre;
    private String direccion;
    private double precioPorNoche;
    private List<Reserva> reservas;
    private Usuario propietario;

    public Propiedad(String nombre, String direccion, double precioPorNoche, Usuario propietario) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.precioPorNoche = precioPorNoche;
        this.propietario = propietario;
        this.reservas = new ArrayList<>();
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

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public boolean consultarDisponibilidad(DateLapse rango) {
        return reservas.stream().noneMatch(reserva -> reserva.overlaps(rango));
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void quitarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public double calcularIngresos(DateLapse rango) {
        return reservas.stream()
                .filter(reserva -> reserva.overlaps(rango))
                .mapToDouble(Reserva::calcularPrecio)
                .sum();
    }
}
