import java.util.Scanner;
import java.util.Locale;

public class Solucion05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        // Ejercicio 1
        // System.out.print("Edad: "); int edad = sc.nextInt();
        // if (edad >= 18) System.out.println("Mayor"); else System.out.println("Menor");

        // Ejercicio 2
        // System.out.print("Numero: "); int n = sc.nextInt();
        // if (n > 0) System.out.println("Positivo"); else if (n < 0) System.out.println("Negativo"); else System.out.println("Cero");

        // Ejercicio 3
        // System.out.print("Numero: "); int num = sc.nextInt();
        // if (num % 2 == 0) System.out.println("Par"); else System.out.println("Impar");

        // Ejercicio 4
        // System.out.print("Nota 0-10: "); int nota = sc.nextInt();
        // if (nota >= 9 && nota <= 10) System.out.println("Sobresaliente");
        // else if (nota >= 7) System.out.println("Notable");
        // else if (nota >= 5) System.out.println("Aprobado");
        // else if (nota >= 0) System.out.println("Reprobado");
        // else System.out.println("Nota inválida");

        // Ejercicio 5 - Calculadora
        System.out.print("Num1: "); double a = sc.nextDouble();
        System.out.print("Num2: "); double b = sc.nextDouble();
        System.out.print("Operador (+ - * /): "); char op = sc.next().charAt(0);
        switch (op) {
            case '+': System.out.println("Resultado: " + (a + b)); break;
            case '-': System.out.println("Resultado: " + (a - b)); break;
            case '*': System.out.println("Resultado: " + (a * b)); break;
            case '/': 
                if (b != 0) System.out.println("Resultado: " + (a / b));
                else System.out.println("No se puede dividir por cero");
                break;
            default: System.out.println("Operador inválido");
        }

        // Ejercicio 6
        // System.out.print("Dia 1-7: "); int dia = sc.nextInt();
        // switch(dia) { case 1: System.out.println("Lunes"); break; case 2: System.out.println("Martes"); break; case 3: System.out.println("Miercoles"); break; case 4: System.out.println("Jueves"); break; case 5: System.out.println("Viernes"); break; case 6: System.out.println("Sabado"); break; case 7: System.out.println("Domingo"); break; default: System.out.println("Invalido"); }

        // Ejercicio 7
        // sc.nextLine(); // limpiar si vienes de nextInt
        // String usuarioCorrecto = "admin"; String claveCorrecta = "1234";
        // System.out.print("Usuario: "); String usu = sc.nextLine();
        // System.out.print("Clave: "); String clave = sc.nextLine();
        // if (usu.equals(usuarioCorrecto) && clave.equals(claveCorrecta)) System.out.println("Acceso concedido"); else System.out.println("Acceso denegado");

        // Ejercicio 8
        // System.out.print("Numero: "); int x = sc.nextInt();
        // String res = (x % 2 == 0) ? "Par" : "Impar";
        // System.out.println(res);

        sc.close();
    }
}
