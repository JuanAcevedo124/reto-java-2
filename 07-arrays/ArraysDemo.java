// LECCIÓN 07: ARRAYS (Arreglos) - Guardar muchos datos en una sola variable
import java.util.Scanner;
import java.util.Arrays; // para imprimir arrays bonito

public class ArraysDemo {
    public static void main(String[] args) {

        System.out.println("=== 1. DECLARAR Y CREAR ARRAY ===");
        // Forma 1: ya con valores
        int[] numeros = {10, 20, 30, 40, 50};
        // Forma 2: vacío con tamaño fijo (todos 0)
        int[] vacio = new int[5];
        // Forma 3: String
        String[] nombres = {"Juan", "Ana", "Pedro"};

        System.out.println("numeros[0] = " + numeros[0]); // 10 -> índice empieza en 0
        System.out.println("numeros[2] = " + numeros[2]); // 30
        System.out.println("Último: " + numeros[numeros.length - 1]); // 50
        System.out.println("Longitud: " + numeros.length); // 5 (no lleva paréntesis, no es método)

        System.out.println("\n=== 2. MODIFICAR ===");
        numeros[1] = 99;
        System.out.println("numeros[1] ahora vale: " + numeros[1]); // 99
        vacio[0] = 7;
        vacio[1] = 14;
        System.out.println("vacio: " + Arrays.toString(vacio)); // [7, 14, 0, 0, 0]

        System.out.println("\n=== 3. RECORRER CON FOR ===");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("índice " + i + " -> " + numeros[i]);
        }

        System.out.println("\n=== 4. FOR-EACH (más simple, no necesitas índice) ===");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (String n : nombres) {
            System.out.println("Hola " + n);
        }

        System.out.println("\n=== 5. RECORRER Y SUMAR ===");
        int suma = 0;
        for (int num : numeros) suma += num;
        System.out.println("Suma: " + suma);
        double promedio = (double) suma / numeros.length;
        System.out.println("Promedio: " + promedio);

        System.out.println("\n=== 6. BUSCAR MÁXIMO/MÍNIMO ===");
        int max = numeros[0];
        for (int num : numeros) {
            if (num > max) max = num;
        }
        System.out.println("Máximo: " + max);

        System.out.println("\n=== 7. ARRAY CON SCANNER ===");
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántos nombres? ");
        int cant = sc.nextInt();
        sc.nextLine();
        String[] lista = new String[cant];
        for (int i = 0; i < cant; i++) {
            System.out.print("Nombre " + (i+1) + ": ");
            lista[i] = sc.nextLine();
        }
        System.out.println("Lista: " + Arrays.toString(lista));

        System.out.println("\n=== 8. ERRORES COMUNES ===");
        // System.out.println(numeros[10]); // IndexOutOfBoundsException -> no existe índice 10
        // numeros.length es 5, índices válidos 0 a 4
        System.out.println("Índices válidos: 0 a " + (numeros.length - 1));

        System.out.println("\n=== 9. ARRAYS BIDIMENSIONALES (matriz) ===");
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("matriz[0][1] = " + matriz[0][1]); // 2
        System.out.println("Matriz completa:");
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                System.out.print(matriz[f][c] + " ");
            }
            System.out.println();
        }

        System.out.println("\n=== 10. Arrays.toString y sort ===");
        int[] desorden = {5, 2, 9, 1, 4};
        System.out.println("Antes: " + Arrays.toString(desorden));
        Arrays.sort(desorden);
        System.out.println("Ordenado: " + Arrays.toString(desorden));

        sc.close();
    }
}
