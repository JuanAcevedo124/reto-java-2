/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

/**
 *
 * @author juana
 */
import java.util.Scanner;
import java.util.Locale;

public class PracticaEntradaDatos {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US); // Fuerza a usar punto 8.9 en vez de coma
    System.out.println("Escribe tu nombre");
    String nombre = sc.nextLine();
    System.out.println("Escribe tu edad");
    int edad = sc.nextInt();
    System.out.println("Hola " + nombre + ", en 5 años tendras " + (edad + 5) + " años.");
    
    
    System.out.println("Calculadora");
    System.out.println("Escribe un numero");
    double num1 = sc.nextDouble();
    System.out.println("Escribe otro numero");
    double num2 = sc.nextDouble();
    System.out.println("Suma: " + (num1 + num2));
    System.out.println("Resta: " + (num1 - num2));
    System.out.println("Multiplicacion: " + (num1 * num2));
    System.out.println("Division: " + (num1 / num2));
    sc.nextLine();
    
    System.out.println("Escribe tu nombre");
    nombre = sc.nextLine();
    System.out.println("Escribe tu edad");
    edad = sc.nextInt();
    System.out.println("Escribe tu altura");
    double altura = sc.nextDouble();
    System.out.println("Escribe tu pais");
    sc.nextLine();
    String pais = sc.nextLine();
    System.out.println("Hola " + nombre + ", tienes " + edad + " años " + " mides " + altura + "m y vives en " + pais);
    
    System.out.println("Escribe la cantidad de euros que quieres convertir");
    double euros = sc.nextDouble();
    double dolares = (euros * 1.16);
    System.out.println(euros + " euros son " + dolares + " dolares.");
    
    System.out.println("Escribe tu altura");
    altura = sc.nextDouble();
    System.out.println("Escribe tu peso");
    double peso = sc.nextDouble();
    System.out.println("El IMC calculado es " + (peso / (altura * altura)));
    sc.nextLine();
    
    System.out.println("Escribe tu nombre completo");
    nombre = sc.nextLine();
    System.out.println("las letras de tu nombre son " + (nombre.replace(" ", "").length()));
    }
}
