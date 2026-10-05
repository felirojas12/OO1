package ar.edu.unlp.info.oo1;

public class CajaDeAhorro extends Cuenta {
    @Override
    protected boolean puedeExtraer(double monto) {
        return this.getSaldo() >= monto + this.comision(monto);
    }

    @Override
    public void depositar(double monto) {
        super.depositar(monto - this.comision(monto));
    }

    @Override
    protected void extraerSinControlar(double monto) {
        super.extraerSinControlar(monto + this.comision(monto));
    }

    private double comision (double monto) {
        return monto * 0.02;
    }
}
