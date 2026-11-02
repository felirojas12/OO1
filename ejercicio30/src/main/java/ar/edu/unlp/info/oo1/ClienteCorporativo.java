package ar.edu.unlp.info.oo1;

public class ClienteCorporativo extends Cliente{
    private String cuit;

    public ClienteCorporativo(String nombre, String direccion, String cuit) {
        super(nombre, direccion);
        this.cuit = cuit;
    }
}
