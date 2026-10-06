# Calculadora Matemática

Aplicación de consola en Java que implementa las operaciones matemáticas básicas (suma, resta, multiplicación y división) mediante un menú interactivo.

**Autor:** Matthews Batista

## Objetivo

Aplicar conceptos fundamentales de programación estructurada y orientada a objetos: encapsulamiento, estructuras de control, manejo de entradas y excepciones, y buenas prácticas de documentación.

## Características

- Clase `CalculadoraMatematica` con atributos privados `numero1` y `numero2` (tipo `double`).
- Constructor por defecto y método para establecer los números.
- Operaciones: suma, resta, multiplicación y división.
- Validación de división por cero mediante condicional `if`.
- Menú interactivo que se repite hasta que el usuario elige salir.
- Validación de entradas no numéricas con `InputMismatchException`.
- Documentación con comentarios y JavaDoc.

## Estructura del proyecto

```
.
├── CalculadoraMatematica.java
└── README.md
```

## Requisitos

- Java JDK 8 o superior.

## Compilación y ejecución

```bash
javac CalculadoraMatematica.java
java CalculadoraMatematica
```

## Generar documentación JavaDoc

```bash
javadoc -d docs CalculadoraMatematica.java
```

Luego abre `docs/index.html` en el navegador.

## Menú de opciones

```
===== CALCULADORA MATEMÁTICA =====
1. Ingresar números
2. Sumar
3. Restar
4. Multiplicar
5. Dividir
0. Salir
==================================
Seleccione una opción:
```

| Opción | Acción |
|--------|--------|
| 1 | Solicita y guarda los dos números |
| 2 | Muestra la suma |
| 3 | Muestra la resta (`numero1 - numero2`) |
| 4 | Muestra la multiplicación |
| 5 | Muestra la división (`numero1 / numero2`) |
| 0 | Finaliza el programa |

## Ejemplo de uso

```
Seleccione una opción: 1
Ingrese el primer número: 10
Ingrese el segundo número: 4
Números guardados correctamente.

Seleccione una opción: 5
Resultado: 10.0 / 4.0 = 2.5

Seleccione una opción: 0
Saliendo de la calculadora. ¡Hasta luego!
```

## Métodos principales

| Método | Descripción | Retorno |
|--------|-------------|---------|
| `establecerNumeros(double, double)` | Asigna los dos números | `void` |
| `sumar()` | Suma `numero1 + numero2` | `double` |
| `restar()` | Resta `numero1 - numero2` | `double` |
| `multiplicar()` | Multiplica `numero1 * numero2` | `double` |
| `dividir()` | Divide `numero1 / numero2`; devuelve `NaN` si el divisor es cero | `double` |
| `ingresarNumeros(Scanner)` | Lee los números desde consola | `void` |

## Convenciones utilizadas

- Clases en `PascalCase` (`CalculadoraMatematica`).
- Métodos y variables en `camelCase` (`ingresarNumeros`, `opcionMenu`).
