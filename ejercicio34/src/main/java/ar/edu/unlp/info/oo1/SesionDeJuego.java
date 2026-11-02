package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.List;

public class SesionDeJuego extends Actividad{
    private List<Item> listaDeItems;

    public SesionDeJuego(LocalDate fechaDeInicio, String ipRegistrada, double duracionTotal, List<Item> listaDeItems) {
        super(fechaDeInicio, ipRegistrada, duracionTotal);
        this.listaDeItems = listaDeItems;
    }

    @Override
    public double calcularMonto() {
        if (duracionTotal < 360) {
            return 0;
        }
        return listaDeItems.stream().mapToDouble(Item::calcularPrecio).sum();
    }
}
