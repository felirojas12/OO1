package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente{
    private String nombre;
    private String direccion;
    private List<Envio> envios;

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.envios = new ArrayList<>();
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

    public void agregarEnvio(Envio envio) {
        envios.add(envio);
    }

    public double calcularMonto(DateLapse rango) {
        return envios.stream()
            .filter(envio -> rango.includes(envio.getFecha()))
            .mapToDouble(Envio::calcularCosto)
            .sum();
    }
}
