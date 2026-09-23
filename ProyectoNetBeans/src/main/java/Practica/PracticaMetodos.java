/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

/**
 *
 * @author juana
 */
public class PracticaMetodos {
    public static void main(String[] args) {
    saludar("Hector");
    saludar("Juan");
    saludar("Niche");
    
    int resultado = sumaRetorno(7, 4);
    System.out.println("Resultado: " + resultado);
    System.out.println("Doble: " + (2 * resultado));
    
    System.out.println("El numero es par?: " + esPar(3));
    System.out.println("El numero es par?: " + esPar(6));
    System.out.println("El numero es par?: " + esPar(45));
    System.out.println("El numero es par?: " + esPar(88));
    
    System.out.println("El numero mayor es: " + mayor(9, 3));
    System.out.println("El numero mayor es: " + mayor(8, 8));
    System.out.println("El numero mayor es: " + mayor(20, 27));
    
    System.out.println("Factorial: " + factorial(6));
    System.out.println("Factorial: " + factorial(4));
    System.out.println("Factorial: " + factorial(9));
    System.out.println("Factorial: " + factorial(15));
    
    System.out.println("Area: " + areaRectangulo(20, 15));
    System.out.println("Perimetro: " + perimetroRectangulo(20, 15));
    
    System.out.println("Multiplicacion int: " + multiplicar(20, 15));
    System.out.println("Multiplicacion double: " + multiplicar(20.5, 15.5));
    
    int nums[] = {3, 9, 2, 15, 6};
    System.out.println("Mayor del array: " + maxArray(nums));
    System.out.println("Promedio del array: " + promedioArray(nums));
}
public static void saludar(String nombre){
    System.out.println("Hola " + nombre + "!");
}

public static int sumaRetorno(int a, int b){
    return a + b;
}

public static boolean esPar(int n) {
    boolean conclusion = false;
    if (n % 2 == 0) {
    conclusion = true;
    }
    return conclusion;
}

public static int mayor(int a, int b) {
    int may = 0;
    if (a > b){
       may = a; 
    }
    else {
        may = b;
    }
    return may;
}

public static long factorial(int n) {
    long f = 1;
    for (int i = 1; i <= n; i++) {
        f *= i;
    }
    return f;
}
public static double areaRectangulo(double base, double altura) {
    return base * altura;
}
public static double perimetroRectangulo(double base, double altura) {
    base *= 2;
    altura *= 2;
    return base + altura;
}

public static int multiplicar(int a, int b){
    return a * b;
}
        
public static double multiplicar(double a, double b){
    return a * b;
}

public static int maxArray(int[] arr) {
    int max = 0;
    for (int n : arr) {
        if (n > max) {
            max = n;
        }
    }
    return max;
}            
    
public static double promedioArray(int[] arr) {
    int suma = 0;
    for (int n : arr)
        suma += n;
        double promedio = (double)suma / arr.length;
    return promedio;
}
}
