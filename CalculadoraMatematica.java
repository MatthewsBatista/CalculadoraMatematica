package calculadoramatematica;

import java.util.InputMismatchException;
import java.util.Scanner;
 
/**
 * Calculadora matemática de consola.
 * Implementa las operaciones básicas (suma, resta, multiplicación y división)
 * sobre dos números de tipo double, con un menú interactivo.
 *
 * @author Matthews Batista
 */
public class CalculadoraMatematica {
 
    // ===================== ATRIBUTOS PRIVADOS =====================
    private double numero1;
    private double numero2;
 
    // ===================== CONSTRUCTOR =====================
 
    /**
     * Constructor por defecto.
     * Inicializa ambos números en 0.0.
     */
    public CalculadoraMatematica() {
        this.numero1 = 0.0;
        this.numero2 = 0.0;
    }
 
    // ===================== SETTERS / GETTERS =====================
 
    /**
     * Establece los dos números con los que se realizarán las operaciones.
     *
     * @param numero1 primer número
     * @param numero2 segundo número
     */
    public void establecerNumeros(double numero1, double numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }
 
    /**
     * Obtiene el primer número.
     *
     * @return valor de numero1
     */
    public double getNumero1() {
        return numero1;
    }
 
    /**
     * Obtiene el segundo número.
     *
     * @return valor de numero2
     */
    public double getNumero2() {
        return numero2;
    }
 
    // ===================== OPERACIONES MATEMÁTICAS =====================
 
    /**
     * Calcula la suma de dos números.
     *
     * @return resultado de la suma
     */
    public double sumar() {
        return numero1 + numero2;
    }
 
    /**
     * Calcula la resta de dos números (numero1 - numero2).
     *
     * @return resultado de la resta
     */
    public double restar() {
        return numero1 - numero2;
    }
 
    /**
     * Calcula la multiplicación de dos números.
     *
     * @return resultado de la multiplicación
     */
    public double multiplicar() {
        return numero1 * numero2;
    }
 
    /**
     * Calcula la división de numero1 entre numero2.
     * Antes de dividir valida con un IF que el divisor no sea cero.
     *
     * @return resultado de la división, o Double.NaN si numero2 es cero
     */
    public double dividir() {
        if (numero2 == 0) {
            // No se puede dividir entre cero: se informa y se devuelve NaN
            System.out.println("Error: no se puede dividir entre cero.");
            return Double.NaN;
        }
        return numero1 / numero2;
    }
 
    // ===================== MÉTODOS DE INTERFAZ =====================
 
    /**
     * Muestra el menú de opciones en consola.
     */
    public static void mostrarMenu() {
        System.out.println("\n===== CALCULADORA MATEMÁTICA =====");
        System.out.println("1. Ingresar números");
        System.out.println("2. Sumar");
        System.out.println("3. Restar");
        System.out.println("4. Multiplicar");
        System.out.println("5. Dividir");
        System.out.println("0. Salir");
        System.out.println("==================================");
        System.out.print("Seleccione una opción: ");
    }
 
    /**
     * Solicita al usuario los dos números por consola y los guarda en la calculadora.
     *
     * @param teclado objeto Scanner usado para leer la entrada
     */
    public void ingresarNumeros(Scanner teclado) {
        try {
            System.out.print("Ingrese el primer número: ");
            double primero = teclado.nextDouble();
            System.out.print("Ingrese el segundo número: ");
            double segundo = teclado.nextDouble();
 
            establecerNumeros(primero, segundo);
            System.out.println("Números guardados correctamente.");
        } catch (InputMismatchException e) {
            // El usuario escribió algo que no es un número
            System.out.println("Error: debe ingresar un valor numérico válido.");
            teclado.nextLine(); // limpia el buffer para evitar un bucle infinito
        }
    }
 
    // ===================== MÉTODO PRINCIPAL =====================
 
    /**
     * Punto de entrada del programa.
     * Muestra el menú de forma repetitiva hasta que el usuario elige 0 (Salir).
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        CalculadoraMatematica calculadora = new CalculadoraMatematica();
        int opcionMenu = -1;
 
        // Bucle do-while: el menú se ejecuta al menos una vez y se repite hasta salir
        do {
            mostrarMenu();
 
            try {
                opcionMenu = teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opción inválida. Ingrese un número del menú.");
                teclado.nextLine(); // limpia la entrada incorrecta
                opcionMenu = -1;
                continue; // vuelve a mostrar el menú
            }
 
            // Estructura switch para manejar cada opción del menú
            switch (opcionMenu) {
                case 1:
                    calculadora.ingresarNumeros(teclado);
                    break;
                case 2:
                    System.out.println("Resultado: " + calculadora.getNumero1()
                            + " + " + calculadora.getNumero2()
                            + " = " + calculadora.sumar());
                    break;
                case 3:
                    System.out.println("Resultado: " + calculadora.getNumero1()
                            + " - " + calculadora.getNumero2()
                            + " = " + calculadora.restar());
                    break;
                case 4:
                    System.out.println("Resultado: " + calculadora.getNumero1()
                            + " * " + calculadora.getNumero2()
                            + " = " + calculadora.multiplicar());
                    break;
                case 5:
                    double resultado = calculadora.dividir();
                    // Solo se muestra el resultado si la división fue válida
                    if (!Double.isNaN(resultado)) {
                        System.out.println("Resultado: " + calculadora.getNumero1()
                                + " / " + calculadora.getNumero2()
                                + " = " + resultado);
                    }
                    break;
                case 0:
                    System.out.println("Saliendo de la calculadora. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcionMenu != 0);
 
        teclado.close();
    }
}
