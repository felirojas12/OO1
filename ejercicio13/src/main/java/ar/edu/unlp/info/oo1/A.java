package ar.edu.unlp.info.oo1;

public abstract class A implements Printer {
    public String print() {
        return "hola" + this.getNombre();
    }
    public String getNombre() {
        return "Soy A";
    }
}
