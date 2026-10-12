package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
    private List<Email> emails;

    public Carpeta() {
        this.emails = new ArrayList<>();
    }

    public void agregar(Email email) {
        emails.add(email);
    }

    public void mover(Email email, Carpeta destino) {
        if (emails.contains(email)) {
            emails.remove(email);
            destino.agregar(email);
        }
    }

    public Email buscar(String texto) {
        for (Email email : emails) {
            if (email.getTitulo().contains(texto) || email.getCuerpo().contains(texto)) {
                return email;
            }
        }
        return null;
    }

    public int size() {
        int totalSize = 0;
        for (Email email : emails) {
            totalSize += email.size();
        }
        return totalSize;
    }
}
