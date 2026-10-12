package ar.edu.unlp.info.oo1;

import java.util.List;

public class ReporteDeConstruccion {
    private List<Pieza> piezas;

    public double volumenDeMaterial(String material) {
        return piezas.stream()
                .filter(p -> p.getMaterial().equals(material))
                .mapToDouble(Pieza::getVolumen)
                .sum();
    }

    public double superficieDeMaterial(String material) {
        return piezas.stream()
                .filter(p -> p.getMaterial().equals(material))
                .mapToDouble(Pieza::getSuperficie)
                .sum();
    }
}
