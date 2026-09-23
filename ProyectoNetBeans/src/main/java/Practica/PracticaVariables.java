/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

/**
 *
 * @author juana
 */
public class PracticaVariables {
    public static void main(String[] args) {
        String Nombre = "Juan";
        int Edad = 17;
        double Altura = 1.80;
        char Inicial = 'J';
        boolean esMayorDeEdad = false;
        
        System.out.println("Me llamo "+ Nombre + " tengo " + Edad + " años " + "mido " + Altura + " mi inicial es " + Inicial + " Mayor de edad? " + esMayorDeEdad);
        
        int a = 10;
        int b = 20;
        
        System.out.println("A = " + a);
        System.out.println("B = " + b);
        
        a = a + 10;
        b = b - 10;
        
        System.out.println("Ahora A =" + a);
        System.out.println("Ahora B =" + b);
        
        int num1 = 8;
        int num2 = 3;
        
        System.out.println("Suma: " + (num1 + num2));
        System.out.println("Resta: " + (num1 - num2));
        System.out.println("Multiplicacion: " + (num1 * num2));
        System.out.println("Division: " + ((double) num1 / num2));
        System.out.println("Resto: " + (num1 % num2));
        
        final int DIAS_SEMANA = 7;
        
        System.out.println(DIAS_SEMANA * 4);
        
        var texto = "Hola";
        var decimal = 2.89;
        var booleano = true;
        
        System.out.println(texto);
        System.out.println(decimal);
        System.out.println(booleano);
    }
}
