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

public class PracticaCondicionales {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
    
    System.out.println("Escribe tu edad");
    int edad = sc.nextInt();
    if (edad >= 18){
        System.out.println("Eres mayor de edad");
    }
    else {
        System.out.println("Eres menor de edad");
    }
    
    System.out.println("Escribe un numero");
    double num1 = sc.nextDouble();
    if (num1 > 0){
        System.out.println("El numero es positivo");
    }
    else if (num1 == 0){
        System.out.println("El numero es neutro(0)");
    }
    else {
        System.out.println("El numero es negativo");
    }
    
  }
}
