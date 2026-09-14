package ar.edu.unlp.info.oo1;

public class Producto {
    private double peso;
    private double precioPorKilo;
    private String descripcion;

    public Producto(String descripcion, double peso, double precioPorKilo) {
        this.peso = peso;
        this.precioPorKilo = precioPorKilo;
        this.descripcion = descripcion;
    }

    public void setPrecioPorKilo(double precioPorKilo) {
        this.precioPorKilo = precioPorKilo;
    }

    public double getPrecioPorKilo() {
        return precioPorKilo;
    }

    public double getPrecio() { return precioPorKilo * peso; };

    public double getPeso() { return peso;}

    public String getDescripcion() {
        return descripcion;
    }
}
