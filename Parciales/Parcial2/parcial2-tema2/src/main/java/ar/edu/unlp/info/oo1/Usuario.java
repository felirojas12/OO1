package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String email;
    private List<Suscripcion> suscripciones;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        suscripciones = new ArrayList<>();
    }

    public void agregarSuscripcion(Suscripcion suscripcion) {
        suscripciones.add(suscripcion);
    }

    public double montoAPagar(LocalDate fecha) {
        return suscripciones.stream()
                .mapToDouble(suscripcion -> suscripcion.montoAPagar(fecha))
                .sum();
    }
}
