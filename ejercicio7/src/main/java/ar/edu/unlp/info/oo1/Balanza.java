package ar.edu.unlp.info.oo1;
import java.util.List;
import java.util.ArrayList;

public class Balanza {
    private List<Producto> productos;

    public Balanza() {
        productos = new ArrayList<>();
    }

    public int getCantidadDeProductos() {
        return productos.size();
    }

    public double getPrecioTotal() {
        double suma = 0;
        for (Producto producto: productos) {
            suma += producto.getPrecio();
        }
        return suma;
    }

    public double getPesoTotal() {
        double suma = 0;
        for (Producto producto: productos) {
            suma += producto.getPeso();
        }
        return suma;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void ponerEnCero() {
        productos.clear();
    }

    public void agregarProducto (Producto producto) {
        productos.add(producto);
    }

    public Ticket emitirTicket() {
        Ticket ticket = new Ticket(getProductos(), getCantidadDeProductos(), getPesoTotal(), getPrecioTotal());
        ticket.impuesto();
        return ticket;
    }
}
