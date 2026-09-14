package ar.edu.unlp.info.oo1;

public class Balanza {
    private int cantidadDeProductos;
    private double precioTotal;
    private double pesoTotal;

    public Balanza() {
        cantidadDeProductos = 0;
        precioTotal = 0.0;
        pesoTotal = 0.0;
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public void ponerEnCero() {
        precioTotal = 0;
        pesoTotal = 0;
        cantidadDeProductos = 0;
    }

    public void agregarProducto (Producto producto) {
        precioTotal += producto.getPrecio();
        pesoTotal += producto.getPeso();
        cantidadDeProductos++;
    }

    public Ticket emitirTicket() {
        Ticket ticket = new Ticket(cantidadDeProductos, pesoTotal, precioTotal);
        ticket.impuesto();
        return ticket;
    }
}
