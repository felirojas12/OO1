package ar.edu.unlp.info.oo1;

public class PlanGrupal extends Plan{

    public PlanGrupal (int cantidadLimiteDeIp) {
        super(cantidadLimiteDeIp);
    }
    @Override
    public double calcularPrecioBase() {
        return cantidadLimiteDeIp * 800;
    }

    @Override
    public double calcularPenalizacion(int cantidadDeIps, Cliente cliente) {
        if (cliente.getAntiguedad() > 10) {
            return 0;
        }
        return Math.max(0, cantidadDeIps - cantidadLimiteDeIp) * 500;
    }
}
