package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente{
    private String nombre;
    private String direccion;
    private List<Envio> envios;

    protected Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.envios = new ArrayList<>();
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
