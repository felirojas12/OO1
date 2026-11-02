package ar.edu.unlp.info.oo1;

public class PersonaFisica extends Cliente{
    private String dni;

    public PersonaFisica(String nombre, String direccion, String dni) {
        super(nombre, direccion);
        this.dni = dni;
    }

    public double calcularMonto(DateLapse rango) {
        return super.calcularMonto(rango) * 0.9; // Aplica un descuento del 10%
    }
}
