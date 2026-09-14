package ar.edu.unlp.info.oo1;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Presupuesto {
    private LocalDate fecha;
    private String cliente;
    private List<Item> items;

    public Presupuesto(String cliente) {
        this.fecha = LocalDate.now();
        this.cliente = cliente;
        this.items = new ArrayList<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void agregarItem(Item item){
        items.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (Item item: items) {
            total += item.costo();
        }
        return total;
    }
}
