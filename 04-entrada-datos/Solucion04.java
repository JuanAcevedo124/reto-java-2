import java.util.Scanner;

public class Solucion04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ejercicio 1
        // System.out.print("Nombre: ");
        // String nombre = sc.nextLine();
        // System.out.print("Edad: ");
        // int edad = sc.nextInt();
        // System.out.println("Hola " + nombre + ", en 5 años tendrás " + (edad + 5));

        // Ejercicio 2
        // System.out.print("Num1: "); double n1 = sc.nextDouble();
        // System.out.print("Num2: "); double n2 = sc.nextDouble();
        // System.out.println("Suma: " + (n1+n2) + " Resta: " + (n1-n2) + " Multi: " + (n1*n2) + " Div: " + (n1/n2));

        // Ejercicio 3 - El importante con el truco
        System.out.print("Nombre: ");
        String nombre3 = sc.nextLine();
        System.out.print("Edad: ");
        int edad3 = sc.nextInt();
        System.out.print("Altura: ");
        double altura3 = sc.nextDouble();
        sc.nextLine(); // LIMPIEZA CLAVE
        System.out.print("Ciudad: ");
        String ciudad3 = sc.nextLine();
        System.out.println(nombre3 + " " + edad3 + " " + altura3 + " " + ciudad3);

        // Ejercicio 4
        // System.out.print("Euros: "); double euros = sc.nextDouble();
        // System.out.println(euros + " euros son " + (euros * 1.08) + " dolares");

        // Ejercicio 5
        // System.out.print("Peso kg: "); double peso = sc.nextDouble();
        // System.out.print("Altura m: "); double altura = sc.nextDouble();
        // double imc = peso / (altura * altura);
        // System.out.println("IMC: " + imc);

        // Ejercicio 6
        // sc.nextLine(); // limpiar si vienes de nextDouble
        // System.out.print("Nombre completo: "); String completo = sc.nextLine();
        // int letras = completo.replace(" ", "").length();
        // System.out.println("Letras sin espacios: " + letras);

        sc.close();
    }
}
