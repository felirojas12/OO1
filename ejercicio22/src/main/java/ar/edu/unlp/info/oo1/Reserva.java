package ar.edu.unlp.info.oo1;

public class Reserva {
    private DateLapse rangoDeFechas;
    private Propiedad propiedad;

    public Reserva(DateLapse rangoDeFechas, Propiedad propiedad) {
        this.rangoDeFechas = rangoDeFechas;
        this.propiedad = propiedad;
    }

    public DateLapse getRangoDeFechas() {
        return rangoDeFechas;
    }

    public void setRangoDeFechas(DateLapse rangoDeFechas) {
        this.rangoDeFechas = rangoDeFechas;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public boolean overlaps(DateLapse rango) {
        return this.rangoDeFechas.overlaps(rango);
    }

    public double calcularPrecio() {
        return this.rangoDeFechas.sizeInDays() * this.propiedad.getPrecioPorNoche();
    }
}
