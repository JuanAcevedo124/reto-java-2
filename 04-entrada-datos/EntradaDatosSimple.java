// Versión SIMPLE para probar rápido sin el bug del nextLine
import java.util.Scanner;

public class EntradaDatosSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();

        // Sin pedir más texto después, no necesitamos limpiar

        System.out.println("Hola " + nombre + " tienes " + edad + " años. En 10 años tendrás " + (edad + 10));

        sc.close();
    }
}
