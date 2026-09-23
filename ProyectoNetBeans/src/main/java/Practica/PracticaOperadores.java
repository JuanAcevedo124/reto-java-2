/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

/**
 *
 * @author juana
 */
public class PracticaOperadores {
    
    public static void main(String[] args) {
    int num1 = 15;
    int num2 = 4;
        
    System.out.println("Suma: " + (num1 + num2));
    System.out.println("Resta: " + (num1 - num2));
    System.out.println("Multiplicacion: " + (num1 * num2));
    System.out.println("Division: " + (num1 / num2));
    System.out.println("Division: " + ((double) num1 / num2));
    System.out.println("Resto: " + (num1 % num2));
    
    int n = 7;
    System.out.println("Es par?" + (n % 2 == 0));
    
    int contador = 10;
    System.out.println(contador);
    contador += 5;
    System.out.println(contador);
    contador ++;
    System.out.println(contador);
    contador *= 2;
    System.out.println(contador);
    
    int edad = 17;
    System.out.println("Es mayor de edad?" + (edad >= 18));
    System.out.println("Es menor que 30?" + (edad < 30));
    System.out.println("Es diferente de 18?" + (edad != 18));
    
    boolean llueve = false;
    boolean tengoParaguas = true;
    
    System.out.println("Debo salir?" + (!llueve || tengoParaguas));
    System.out.println("me mojo?" + (llueve && !tengoParaguas));
    
    double radio = 5;
    System.out.println(Math.PI * Math.pow(radio, 2));
    }
}    
    
