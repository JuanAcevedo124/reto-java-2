import java.util.Scanner;
import java.util.Locale;

public class Solucion06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        // Ejercicio 1
        // for (int i=1; i<=10; i++) System.out.println(i);

        // Ejercicio 2
        // int suma = 0; for (int i=1; i<=100; i++) suma += i; System.out.println(suma); // 5050

        // Ejercicio 3
        System.out.print("Tabla del: "); int tabla = sc.nextInt();
        for (int i=1; i<=10; i++) System.out.println(tabla + " x " + i + " = " + (tabla*i));

        // Ejercicio 4
        // int c = 10; while (c >= 1) { System.out.println(c); c--; }

        // Ejercicio 5
        // int secreto = 7; int intentos=0; while(true){ System.out.print("Adivina: "); int intento = sc.nextInt(); intentos++; if(intento==secreto){ System.out.println("Ganaste en " + intentos); break;} else System.out.println("Intenta de nuevo");}

        // Ejercicio 6
        // for (int i=1; i<=20; i++){ if(i%2!=0) continue; System.out.print(i+" "); }

        // Ejercicio 7 - Pirámide
        // for(int i=1; i<=5; i++){ for(int j=1; j<=i; j++) System.out.print("*"); System.out.println(); }

        // Ejercicio 8 - Factorial
        // System.out.print("n: "); int n = sc.nextInt(); long fact=1; for(int i=1; i<=n; i++) fact*=i; System.out.println(n+"! = "+fact);

        // Ejercicio 9 - Validación
        // int edad; do{ System.out.print("Edad 0-120: "); edad = sc.nextInt(); if(edad<0||edad>120) System.out.println("Inválida"); } while(edad<0||edad>120);

        sc.close();
    }
}
