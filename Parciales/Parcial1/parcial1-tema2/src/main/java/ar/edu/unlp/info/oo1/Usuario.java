package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<Servicio> serviciosContratados;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.serviciosContratados = new ArrayList<>();
    }

    public void agregarServicio(Servicio servicio) {
        this.serviciosContratados.add(servicio);
    }

    public double calcularGastoTotal(){
        return serviciosContratados.stream()
                .mapToDouble(servicio -> servicio.calcularCosto())
                .sum();
    }
}
