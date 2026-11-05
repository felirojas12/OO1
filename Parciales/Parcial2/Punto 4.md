# Puntos

## Ejercicio 4

### Punto 1

```java
public Usuario(String nombre) {
    this.nombre = nombre;
    alquileres = new ArrayList<>();
}

public Alquiler(LocalDate fechaInicio, int cantidadDias, int cantidadInquilinos, double costoPorDia) {
    this.fechaInicio = fechaInicio;
    this.cantidadDias = cantidadDias;
    this.cantidadInquilinos = cantidadInquilinos;
    this.costoPorDia = costoPorDia;
    servicios = new ArrayList<>();
}

protected Servicio (LocalDate fechaContratada) {
    this.fechaContratada = fechaContratada;
}

public Traslado(LocalDate fechaContratada, double distancia, double precioPorKm) {
    super(fechaContratada);
    this.distancia = distancia;
    this.precioPorKm = precioPorKm;
}
```
