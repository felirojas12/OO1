package ar.edu.unlp.info.oo1;

public class PlanIndividual extends Plan{
    private int cantidadDeMinutos;

    public PlanIndividual(int cantidadDeMinutos) {
        super(1);
        this.cantidadDeMinutos = cantidadDeMinutos;
    }

    @Override
    public double calcularPrecioBase() {
        return cantidadDeMinutos * 20;
    }

    @Override
    public double calcularPenalizacion(int cantidadDeIps, Cliente cliente) {
        return Math.max(0, cantidadDeIps - cantidadLimiteDeIp) * 300;
    }
}
