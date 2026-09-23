// LECCIÓN 05: CONDICIONALES - Tomar decisiones en el código
package condicionales;
import java.util.Scanner;
import java.util.Locale;

public class Condicionales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.println("=== 1. IF SIMPLE ===");
        int edad = 20;
        if (edad >= 18) {
            System.out.println("Eres mayor de edad");
        }
        // Si solo hay una línea, puedes omitir { } pero es mala práctica

        System.out.println("\n=== 2. IF - ELSE ===");
        int nota = 4;
        if (nota >= 5) {
            System.out.println("Aprobado");
        } else {
            System.out.println("Reprobado");
        }

        System.out.println("\n=== 3. IF - ELSE IF - ELSE (varias condiciones) ===");
        int calificacion = 8;
        if (calificacion >= 9) {
            System.out.println("Sobresaliente");
        } else if (calificacion >= 7) {
            System.out.println("Notable");
        } else if (calificacion >= 5) {
            System.out.println("Aprobado");
        } else {
            System.out.println("Reprobado");
        }
        // Solo entra en UNO, el primero que sea true. El orden importa.

        System.out.println("\n=== 4. CONDICIONES CON && || ! ===");
        int edad2 = 25;
        boolean tieneLicencia = true;
        if (edad2 >= 18 && tieneLicencia) {
            System.out.println("Puede conducir");
        }
        if (edad2 < 18 || !tieneLicencia) {
            System.out.println("NO puede conducir (ejemplo OR/NOT)");
        }

        System.out.println("\n=== 5. IF ANIDADO ===");
        int num = 10;
        if (num > 0) {
            if (num % 2 == 0) {
                System.out.println(num + " es positivo y par");
            } else {
                System.out.println(num + " es positivo e impar");
            }
        } else {
            System.out.println(num + " no es positivo");
        }

        System.out.println("\n=== 6. SWITCH (alternativa a muchos else if) ===");
        int dia = 3;
        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break; // sin break se ejecuta el siguiente también!
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miercoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            default: // como el else
                System.out.println("Fin de semana");
        }

        // Switch con String (desde Java 7)
        String fruta = "manzana";
        switch (fruta) {
            case "manzana":
                System.out.println("Es manzana");
                break;
            case "pera":
                System.out.println("Es pera");
                break;
            default:
                System.out.println("Otra fruta");
        }

        // Switch moderno (Java 14+) - más corto, sin break
        int mes = 2;
        String estacion = switch (mes) {
            case 12, 1, 2 -> "Invierno";
            case 3, 4, 5 -> "Primavera";
            case 6, 7, 8 -> "Verano";
            case 9, 10, 11 -> "Otoño";
            default -> "Mes inválido";
        };
        System.out.println("Mes " + mes + " es " + estacion);

        System.out.println("\n=== 7. OPERADOR TERNARIO (if en una línea) ===");
        int a = 10, b = 20;
        int mayor = (a > b) ? a : b; // condición ? valor_si_true : valor_si_false
        System.out.println("El mayor entre " + a + " y " + b + " es " + mayor);

        String estado = (nota >= 5) ? "Aprobado" : "Reprobado";
        System.out.println("Estado: " + estado);

        System.out.println("\n=== 8. TRUCO: Comparar String SIEMPRE con .equals() ===");
        String clave = "1234";
        // MAL: if (clave == "1234") -> falla a veces
        // BIEN:
        if (clave.equals("1234")) {
            System.out.println("Clave correcta con equals");
        }
        // Para ignorar mayúsculas/minúsculas: equalsIgnoreCase()
        String nombre = "Juan";
        if (nombre.equalsIgnoreCase("juan")) {
            System.out.println("Nombre coincide (ignora mayúsculas)");
        }

        System.out.println("\n=== 9. EJEMPLO INTERACTIVO ===");
        System.out.print("Escribe tu edad: ");
        int edadInput = sc.nextInt();
        if (edadInput >= 18) {
            System.out.println("Eres adulto");
            if (edadInput >= 65) {
                System.out.println("Eres adulto mayor");
            }
        } else if (edadInput >= 13) {
            System.out.println("Eres adolescente");
        } else {
            System.out.println("Eres niño");
        }

        sc.close();
    }
}
