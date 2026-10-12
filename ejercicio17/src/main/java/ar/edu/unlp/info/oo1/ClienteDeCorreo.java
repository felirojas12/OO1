package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {
    private Carpeta inbox;
    private List<Carpeta> carpetas;

    public ClienteDeCorreo() {
        this.inbox = new Carpeta();
        this.carpetas = new ArrayList<>();
    }

    public void recibir(Email email) {
        inbox.agregar(email);
    }

    public void agregarCarpeta(Carpeta carpeta) {
        carpetas.add(carpeta);
    }

    public Email buscar(String texto) {
        Email emailEncontrado = inbox.buscar(texto);
        if (emailEncontrado != null) {
            return emailEncontrado;
        }
        for (Carpeta carpeta : carpetas) {
            emailEncontrado = carpeta.buscar(texto);
            if (emailEncontrado != null) {
                return emailEncontrado;
            }
        }
        return null;
    }

    public int foldersSize() {
        int totalSize = inbox.size();
        for (Carpeta carpeta: carpetas) {
            totalSize += carpeta.size();
        }
        return totalSize;
    }
}
