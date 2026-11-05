# Puntos

## Ejercicio 4

### Punto 1

Implemente el constructor de las clases Usuario, Alquiler, Servicio y Traslado

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

### Punto 2

Implemente el método totalGastado() de la clase Usuario, junto con los métodos auxiliares que dicho cálculo requiera. El total gastado se define como la suma de los costos de alquileres que realizó. Utilice Streams cuando resulte apropiado. Considere que los métodos costo de Limpieza, MediaPension y Traslado ya están implementados.

```java
public class Usuario {
    public double totalGastado() {
        return alquileres.stream()
                         .mapToDouble(alquiler -> alquiler.calcularCosto())
                         .sum();
    }
}

public class Alquiler {
    public double calcularCosto() {
        double costoServicios = servicios.stream()
                                         .mapToDouble(servicio -> servicio.costo())
                                         .sum();
        double costoBaseAlquiler = cantidadDias * costoPorDia;
        return costoBaseAlquiler + costoServicios;
    }
}
```

### Punto 3

Instancie el siguiente con sus alquileres y servicios asociados, utilizando la siguiente información:

- Usuario: Lautaro Gonzalez, con 2 alquileres:  
  - Alquiler 1: Fecha de inicio 01/01/2025, 5 días, 2 inquilinos, costo por día 5000.  
    - Servicios: Limpieza para el 02/01/2025, 3 horas, 2000 la hora.  
    - Media Pensión para el 01/01/2025, 2 personas, 2500 por persona.  
  - Alquiler 2: Fecha de inicio 15/02/2025, 3 días, 1 inquilino, costo por día 6000.  
    - Servicio: Traslado para el 15/02/2025, 10 km, precio por km 500.  

```java
Limpieza limpieza = new Limpieza(LocalDate.of(2025, 01, 02), 3, 2000);
MediaPension mediaPension = new MediaPension(LocalDate.of(2025, 01, 01), 2, 2500);
Traslado traslado = new Traslado(LocalDate.of(2025, 02, 15), 10, 500);
Alquiler alquilerUno = new Alquiler(LocalDate.of(2025, 01, 01), 5, 2, 5000)
alquilerUno.agregarServicio(limpieza);
alquilerUno.agregarServicio(mediaPension);
Alquiler alquilerDos = new Alquiler(LocalDate.of(2025, 02, 15), 3, 1, 6000);
alquilerDos.agregarServicio(traslado);
Usuario usuario = new Usuario("Lautaro Gonzalez");
usuario.agregarAlquiler(alquilerUno);
usuario.agregarAlquiler(alquilerDos);
```
