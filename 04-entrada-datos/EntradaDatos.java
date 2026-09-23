// LECCIÓN 04: ENTRADA DE DATOS CON SCANNER
// Para pedir datos al usuario por teclado

import java.util.Scanner; // 1. Importar la herramienta Scanner

public class EntradaDatos {
    public static void main(String[] args) {

        // 2. Crear el objeto Scanner (solo una vez)
        Scanner sc = new Scanner(System.in);

        System.out.println("=== EJEMPLO 1: TEXTO Y NÚMEROS ===");

        System.out.print("Escribe tu nombre: ");
        String nombre = sc.nextLine(); // lee línea completa (con espacios)

        System.out.print("Escribe tu edad: ");
        int edad = sc.nextInt(); // lee entero

        System.out.print("Escribe tu altura (ej 1.75): ");
        double altura = sc.nextDouble(); // lee decimal

        // ¡TRUCO IMPORTANTE! Después de nextInt/nextDouble, hay que limpiar el salto de línea
        sc.nextLine(); // consume el "enter" que quedó pendiente

        System.out.print("Escribe tu ciudad: ");
        String ciudad = sc.nextLine();

        System.out.println("\n--- Resumen ---");
        System.out.println("Hola " + nombre + ", tienes " + edad + " años, mides " + altura + "m y vives en " + ciudad);

        System.out.println("\n=== EJEMPLO 2: DIFERENCIA ENTRE next() y nextLine() ===");
        // Si solo quieres una palabra sin espacios, puedes usar next()
        // Pero nextLine() es mejor para nombres completos
        // Descomenta para probar:
        // System.out.print("Escribe una frase: ");
        // sc.nextLine(); // si vienes de un nextInt antes, limpia
        // String frase = sc.nextLine();
        // System.out.println("Escribiste: " + frase);
        // System.out.print("Escribe una palabra con next(): ");
        // String palabra = sc.next();
        // System.out.println("Con next() solo toma: " + palabra);

        System.out.println("\n=== EJEMPLO 3: CALCULADORA INTERACTIVA ===");
        System.out.print("Dame un número: ");
        double num1 = sc.nextDouble();
        System.out.print("Dame otro número: ");
        double num2 = sc.nextDouble();
        System.out.println("Suma: " + (num1 + num2));
        System.out.println("Multiplicación: " + (num1 * num2));

        System.out.println("\n=== EJEMPLO 4: BOOLEAN ===");
        System.out.print("¿Eres estudiante? (true/false): ");
        boolean esEstudiante = sc.nextBoolean();
        System.out.println("Estudiante: " + esEstudiante);

        // 3. Cerrar el scanner al final (buena práctica)
        sc.close();

        // NOTA VS CODE: Para que Scanner funcione, ejecuta en la TERMINAL, no con "Run" del botón.
        // Ve a Terminal -> New Terminal y escribe: java EntradaDatos.java
        // Si usas el botón Run de VS Code (Code Runner) a veces no deja escribir.
    }
}
