package ar.edu.unlp.info.oo1;

public class Esfera extends Pieza{
    private double radio;

    public Esfera(String color, String material, double radio) {
        super(color, material);
        this.radio = radio;
    }

    @Override
    public double getVolumen() {
        return (4.0/3.0) * Math.PI * Math.pow(radio, 3);
    }

    @Override
    public double getSuperficie() {
        return 4 * Math.PI * Math.pow(radio, 2);
    }
}
