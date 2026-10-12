package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public class Email {
    private String titulo;
    private String cuerpo;
    private List<Archivo> adjuntos;

    public Email(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.adjuntos = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public int size() {
        int totalSize = titulo.length() + cuerpo.length();
        for (Archivo archivo : adjuntos) {
            totalSize += archivo.size();
        }
        return totalSize;
    }
}
