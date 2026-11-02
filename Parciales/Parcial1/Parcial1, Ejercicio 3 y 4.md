# Ejercicios

## Ejercio 3

### A

Opcion 3: Printer, A, B, C, D

### B

Opcion 4: B, C, D

### C

Opcion 3: hola soy B y tambien soy A

### D

Opcion 2: hola soy C saludos

## Ejercicio 4

### Punto 1

``` java
public Empleado(String nombre, LocalDate fechaNacimiento, int cantidadHijos, boolean tieneConyuge) {
    this.nombre = Objects.requireNonNull(nombre);
    this.fechaNacimiento = Objects.requireNonNull(fechaNacimiento);
    this.cantidadHijos = cantidadHijos;
    this.tieneConyuge = tieneConyuge;
    this.contratos = new ArrayList<>();
}
```

### Punto 2

``` java
juanPerez = new Empleado("Juan Perez", LocalDate.of(1985, 5, 10), 2, true);
contratoPorHorasJuan = new ContratoPorHoras(LocalDate.of(2020, 06, 01), 900, 160, LocalDate.of(2023, 01, 31));
contratoDePlantaJuan = new ContratoDePlanta(LocalDate.of(2023, 02, 01), 120000, 6000, 10000);
juanPerez.agregarContrato(contratoDePlantaJuan);
juanPerez.agregarContrato(contratoPorHorasJuan);
anaGarcia = new Empleado("Ana García", LocalDate.of(1990, 8, 15), 1, false);
contratoPorHorasAna = new ContratoPorHoras(LocalDate.of(2024, 10, 01), 1100, 150, LocalDate.of(2025, 12, 15));
contratoDePlantaAna = new ContratoDePlanta(LocalDate.of(2022, 07, 01), 80000, 6000, 8000);
anaGarcia.agregarContrato(contratoDePlantaAna);
anaGarcia.agregarContrato(contratoPorHorasAna);
```

### Punto 3

Casos de prueba:

``` java
void testCalcularSueldoBasicoAntiguedadMenorADiez(); //antiguedad = 9
void testCalcularSueldoBasicoAntiguedadDiez(); //antiguedad = 10
void testCalcularSueldoBasicoAntiguedadMayorADiez(); //antiguedad = 11

void testCalcularSueldoBasicoConyuge(); //conyuge = true
void testCalcularSueldoBasicoSinConyuge(); //conyuge = true

void testCalcularSueldoBasicoSinHijos(); //hijos = 0
void testCalcularSueldoBasicoConHijos(); //hijos = 2
```
