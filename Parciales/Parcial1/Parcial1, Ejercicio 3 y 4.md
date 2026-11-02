# Ejercicios

## Ejercio 3

### A

Indique la opción que incluye **todos** los tipos válidos con los que puede declararse la variable o1 para que el fragmento anterior sea válido en tiempo de compilación.

Opción 1: A, B, C, D
Opción 2: Printer, A, C, D
**Opción 3: Printer, A, B, C, D**
Opción 4: Printer, A, B, C

### B

Suponiendo que o1 fue declarada de tipo Printer, indique la opción que incluye **todos** los tipos que pueden instanciarse y asignarse a la variable o1 en el fragmento anterior.

Opción 1: Printer, A, B, C, D
Opción 2: C, D
Opción 3: Printer, A, B, C
**Opción 4: B, C, D**

### C

Observando el diagrama, indique qué texto retorna el siguiente fragmento de codigo:

``` java
Printer p = new B();
p.print();
```

Opción 1: hola soy A y tambien soy B
Opción 2: hola soy A
**Opción 3: hola soy B y tambien soy A**
Opción 4: hola soy B

### D

``` java
A a = new C();
a.print();
```

Opción 1: hola soy A
**Opcion 2: hola soy C saludos**
Opción 3: hola soy C
Opción 4: hola soy A saludos

## Ejercicio 4

### Punto 1

Defina el constructor de Empleado. Observe que Contrato ya tiene sus constructores definidos.

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

Instancie a los empleados Juan Perez y Ana García con la informacion provista.

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

Diseñe los casos de prueba para el metodo **calcularSueldoBasico** de **ContratoDePlanta** teniendo en cuenta los conceptos de valores de borde y particiones equivalentes vistos en la materia.

``` java
void testCalcularSueldoBasicoAntiguedadMenorADiez(); //antiguedad = 9
void testCalcularSueldoBasicoAntiguedadDiez(); //antiguedad = 10
void testCalcularSueldoBasicoAntiguedadMayorADiez(); //antiguedad = 11

void testCalcularSueldoBasicoConyuge(); //conyuge = true
void testCalcularSueldoBasicoSinConyuge(); //conyuge = true

void testCalcularSueldoBasicoSinHijos(); //hijos = 0
void testCalcularSueldoBasicoConHijos(); //hijos = 2
```
