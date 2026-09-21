package ar.edu.unlp.info.oo1;

public class Circulo implements Figura{
    private double radio;

    public Circulo() {
        this.radio = 0;
    }

    public double getRadio() { return radio; }

    public double getDiametro() { return radio * 2; }

    public double getPerimetro() { return Math.PI * this.getDiametro(); }

    public double getArea() { return Math.PI * (Math.pow(this.getRadio(), 2)); }

    public void setRadio(double radio) { this.radio = radio; }

    public void setDiametro(double diametro) { this.radio = diametro / 2; }


}
