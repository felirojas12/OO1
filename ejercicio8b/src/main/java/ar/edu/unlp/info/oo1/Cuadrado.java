package ar.edu.unlp.info.oo1;

public class Cuadrado implements Figura {
    private double lado;

    public Cuadrado() {
        this.lado = 0;
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

    public double getLado() {
        return this.lado;
    }
}
