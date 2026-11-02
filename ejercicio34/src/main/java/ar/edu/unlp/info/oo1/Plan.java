package ar.edu.unlp.info.oo1;

public abstract class Plan {
    protected int cantidadLimiteDeIp;

    public Plan(int cantidadLimiteDeIp) {
        this.cantidadLimiteDeIp = cantidadLimiteDeIp;
    }
    public abstract double calcularPrecioBase();

    public abstract double calcularPenalizacion(int cantidadDeIps, Cliente cliente);

}
