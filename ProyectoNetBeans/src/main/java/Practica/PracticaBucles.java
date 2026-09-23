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

public class PracticaBucles {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
    
    for (int i = 1; i <= 10; i++){
        System.out.println("Numero " + i);
        }
    
    int suma = 0;
    for (int i = 1; i <= 100; i++) {
        suma += i;       
    }
    System.out.println("Total: " + suma);
    
    System.out.println("Escribe un numero para ver su tabla");
    int num = sc.nextInt();
    System.out.println("Tabla del: " + num);
    for (int i = 1; i <= 10; i++) {
        System.out.println(num + " x " + i + " = " + (num * i));
    }
    
    int contador = 10;
    while (contador >= 1) {
        System.out.println("Cuenta atras: " + contador);
        contador--;
    }
    sc.nextLine();
    
    String secreto = " ";
    System.out.println("Intenta adivinar el numero de 1 a 20");
    while (!secreto.equals("7")){
        System.out.println("Adivina: ");
        secreto = sc.nextLine();
        System.out.println("Numero incorrecto, intenta de nuevo");
    }
    System.out.println("Correcto!");
    
    for (int i = 1; i <= 20; i++) {
        if (i % 2 != 0) continue; 
        System.out.println("Numero " + i);
    }
    
    for (int fila = 1; fila <= 5; fila++) {
        for (int col = 1; col <= fila; col++){
            System.out.print("* ");
        }
        System.out.println();
    }
    
    System.out.println("Escribe un numero para ver su factorial");
    num = sc.nextInt();
    long fact = 1;
    System.out.println("Factorial del: " + num);
    for (int i = 1; i <= num; i++) {
        fact *= i;
        System.out.println(num +"! = " + fact);
    }
    }
}
