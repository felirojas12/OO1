package ar.edu.unlp.info.oo1;

public abstract class Pieza {
    private String color;
    private String material;

    public Pieza(String color, String material) {
        this.color = color;
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public abstract double getVolumen();
    public abstract double getSuperficie();
}
