package ar.edu.unlp.info.oo1;

public class Item {
    private String nombre;
    private int cantidad;
    private double precioUnitario;

    public Item(String nombre, int cantidad, double precioUnitario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public double calcularPrecio() {
        return this.cantidad * this.precioUnitario;
    }
}
