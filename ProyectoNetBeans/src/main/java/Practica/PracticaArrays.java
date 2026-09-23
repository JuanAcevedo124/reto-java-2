/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

/**
 *
 * @author juana
 */
import java.util.Arrays;
import java.util.Scanner;

public class PracticaArrays {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int[] nums = {5, 10, 15, 20, 25};
    System.out.println("Primero: " + nums[0]);
    System.out.println("Ultimo: " + nums[4]);
    System.out.println("Longitud: " + nums.length);
    
    int suma = 0;
    for (int num : nums) suma += num;
    System.out.println("Suma: " + suma);
    double promedio = (double)suma / nums.length;
    System.out.println("Promedio: " + promedio);
    
    int[] datos = {8, 3, 15, 6, 2, 9};
    int max = 0;
    for (int dato : datos) {
        if (dato > max)
        max = dato;
    }
    System.out.println("Mayor: " + max);
    int min = 0;
    for (int dato : datos) {
        if (dato < min)
        min = dato;
    }
    System.out.println("Menor: " + min);
    
    int[] notas = {4, 9, 6, 3, 10, 7, 5};
    int aprob = 0;
    for (int nota : notas) {
        if (nota >= 5) aprob++;
    }
    System.out.println("Aprobados: " + aprob + " Reprobados: " + (notas.length - aprob));
    
    String[] nombres = {"Ana","Juan","Luis","Maria"};
    System.out.println("Escribe tu nombre para ver si estas registrado");
    String ingresado = sc.nextLine();
    boolean encontrado = false;
    for (String nombre : nombres){
        if (ingresado.equals(nombre))
        encontrado = true;    
    }
    System.out.println(encontrado ? "Encontrado" : "No Encontrado");
    
    int[] original = {1,2,3,4,5};
    int[] invertido = new int[original.length];
    for (int i = 0; i < original.length; i++) {
        invertido[i] = original[original.length - 1 - i];
    }
    System.out.println("Invertido: " + Arrays.toString(invertido));
    }
}

