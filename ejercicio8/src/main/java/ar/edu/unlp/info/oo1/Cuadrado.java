package ar.edu.unlp.info.oo1;

public class Cuadrado {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public double getPerimetro() {
        return 4 * this.getLado();
    }

    public double getArea() {
        return Math.pow(this.getLado(), 2);
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
}
