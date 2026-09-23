import java.util.Arrays;
import java.util.Scanner;

public class Solucion07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ejercicio 2 - Suma y promedio
        int[] nums = {5, 10, 15, 20, 25};
        int suma = 0;
        for (int n : nums) suma += n;
        System.out.println("Suma: " + suma + " Promedio: " + ((double)suma / nums.length));

        // Ejercicio 3 - Max/min
        int[] datos = {8, 3, 15, 6, 2, 9};
        int max = datos[0], min = datos[0];
        for (int d : datos) { if (d > max) max = d; if (d < min) min = d; }
        System.out.println("Max: " + max + " Min: " + min);

        // Ejercicio 4 - Aprobados
        int[] notas = {4, 9, 6, 3, 10, 7, 5};
        int aprob = 0;
        for (int nota : notas) if (nota >= 5) aprob++;
        System.out.println("Aprobados: " + aprob + " Reprobados: " + (notas.length - aprob));

        // Ejercicio 5 - Buscar
        String[] nombres = {"Ana","Juan","Luis","Maria"};
        System.out.print("Buscar nombre: ");
        String buscar = sc.nextLine();
        boolean encontrado = false;
        for (String n : nombres) if (n.equalsIgnoreCase(buscar)) encontrado = true;
        System.out.println(encontrado ? "Encontrado" : "No encontrado");

        // Ejercicio 6 - Invertido
        int[] original = {1,2,3,4,5};
        int[] invertido = new int[original.length];
        for (int i=0; i<original.length; i++) invertido[i] = original[original.length - 1 - i];
        System.out.println("Invertido: " + Arrays.toString(invertido));

        sc.close();
    }
}
