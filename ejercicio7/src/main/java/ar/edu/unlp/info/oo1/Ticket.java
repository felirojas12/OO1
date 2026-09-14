package ar.edu.unlp.info.oo1;

import java.util.*;
import java.time.LocalDate;


public class Ticket {
    private List<Producto> productos;
    private LocalDate fecha;
    private int cantidadDeProductos;
    private double pesoTotal;
    private double precioTotal;

    public Ticket(List<Producto> productos, int cantidadDeProductos, double pesoTotal, double precioTotal) {
        this.productos = productos;
        this.fecha = LocalDate.now();
        this.cantidadDeProductos = cantidadDeProductos;
        this.pesoTotal = pesoTotal;
        this.precioTotal = precioTotal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public double impuesto() {
        return precioTotal * 0.21;
    }
}
