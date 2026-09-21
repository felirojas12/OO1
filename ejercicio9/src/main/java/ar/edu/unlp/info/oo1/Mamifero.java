package ar.edu.unlp.info.oo1;
import java.time.LocalDate;
import java.util.*;

public class Mamifero {
    private String identificador;
    private String especie;
    private LocalDate fechaNacimiento;
    private Mamifero padre;
    private Mamifero madre;

    public Mamifero(String identificador) {
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Mamifero getPadre() {
        return padre;
    }

    public void setPadre(Mamifero padre) {
        this.padre = padre;
    }

    public Mamifero getMadre() {
        return madre;
    }

    public void setMadre(Mamifero madre) { this.madre = madre;
    }

    public Mamifero getAbueloMaterno() {
        return (madre != null) ? madre.getPadre() : null;
    }

    public Mamifero getAbuelaMaterna() {
        return (madre != null) ? madre.getMadre() : null;
    }

    public Mamifero getAbueloPaterno() {
        return (padre != null) ? padre.getPadre() : null;
    }

    public Mamifero getAbuelaPaterna() {
        return (padre != null) ? padre.getMadre() : null;
    }

    public boolean tieneComoAncestroA(Mamifero unMamifero) {
        if (unMamifero == null || unMamifero.equals(this)) {
            return false;
        }

        if (this.padre == unMamifero || this.madre == unMamifero) {
            return true;
        }

        return (this.padre != null && this.padre.tieneComoAncestroA(unMamifero)) ||
               (this.madre != null && this.madre.tieneComoAncestroA(unMamifero));
    }
}
