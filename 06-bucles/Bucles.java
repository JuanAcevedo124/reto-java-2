// LECCIÓN 06: BUCLES - Repetir código sin copiar y pegar
import java.util.Scanner;
import java.util.Locale;

public class Bucles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.println("=== 1. FOR (cuando sabes cuántas veces repetir) ===");
        // for (inicio; condición; actualización)
        for (int i = 1; i <= 5; i++) {
            System.out.println("Vuelta " + i);
        }
        // i solo existe dentro del for

        // For con paso de 2 en 2
        System.out.println("Pares del 0 al 10:");
        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // For al revés
        System.out.println("Cuenta atrás:");
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\n=== 2. WHILE (mientras se cumpla, repite) ===");
        // Útil cuando NO sabes cuántas veces repetir
        int contador = 1;
        while (contador <= 3) {
            System.out.println("While vuelta " + contador);
            contador++; // ¡IMPORTANTE! Si no aumentas, bucle infinito
        }

        // Ejemplo: pedir contraseña hasta que acierte
        // String clave = "";
        // while (!clave.equals("1234")) {
        //     System.out.print("Escribe clave: ");
        //     clave = sc.nextLine();
        // }
        // System.out.println("Correcto!");

        System.out.println("\n=== 3. DO-WHILE (se ejecuta al menos una vez) ===");
        int numero;
        do {
            System.out.print("Escribe un numero positivo (do-while lo pide al menos una vez): ");
            numero = sc.nextInt();
        } while (numero <= 0);
        System.out.println("Gracias, escribiste " + numero);

        // Diferencia clave: while puede no ejecutarse nunca, do-while siempre 1 vez mínimo

        System.out.println("\n=== 4. BREAK y CONTINUE ===");
        // break -> rompe el bucle y sale
        // continue -> salta a la siguiente vuelta
        System.out.println("Con break (para en 5):");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) break;
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Con continue (salta el 5):");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) continue;
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\n=== 5. BUCLE ANIDADO (bucle dentro de otro) ===");
        // Tabla de multiplicar
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(i + "x" + j + "=" + (i*j) + "  ");
            }
            System.out.println();
        }

        // Dibujar rectángulo con *
        System.out.println("Rectangulo 3x5:");
        for (int fila = 1; fila <= 3; fila++) {
            for (int col = 1; col <= 5; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\n=== 6. FOR con Scanner (sumar N números) ===");
        System.out.print("¿Cuántos números quieres sumar? ");
        int n = sc.nextInt();
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Numero " + i + ": ");
            int valor = sc.nextInt();
            suma += valor;
        }
        System.out.println("Suma total: " + suma);

        System.out.println("\n=== 7. WHILE con contador y acumulador ===");
        // Sumar hasta que el usuario escriba 0
        System.out.println("Escribe números (0 para terminar):");
        int total = 0;
        int valor = sc.nextInt();
        while (valor != 0) {
            total += valor;
            System.out.print("Otro (0 fin): ");
            valor = sc.nextInt();
        }
        System.out.println("Total acumulado: " + total);

        sc.close();
    }
}
