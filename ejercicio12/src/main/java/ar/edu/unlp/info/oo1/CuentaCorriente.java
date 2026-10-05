package ar.edu.unlp.info.oo1;

public class CuentaCorriente extends Cuenta{
    private double limiteDescubierto;

    public CuentaCorriente() {
        this.limiteDescubierto = 0;
    }

    public double getLimiteDescubierto() {
        return limiteDescubierto;
    }

    public void setLimiteDescubierto(double limiteDescubierto) {
        this.limiteDescubierto = limiteDescubierto;
    }

    @Override
    protected boolean puedeExtraer(double monto) {
        return limiteDescubierto >= Math.abs(getSaldo() - monto);
    }
}
