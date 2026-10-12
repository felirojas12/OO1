package ar.edu.unlp.info.oo1;

import java.util.List;
import java.util.ArrayList;

public class Inversor {
    private List<Inversion> carteraDeInversiones;

    public Inversor() {
        this.carteraDeInversiones = new ArrayList<>();
    }

    public double valorDeInversiones() {
        return carteraDeInversiones.stream().mapToDouble(inversion -> inversion.valorActual()).sum();
    }

    public void agregarInversion(Inversion inversion) {
        carteraDeInversiones.add(inversion);
    }

    public void eliminarInversion(Inversion inversion) {
        carteraDeInversiones.remove(inversion);
    }
}
