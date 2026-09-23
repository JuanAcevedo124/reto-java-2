/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica.folder;

/**
 *
 * @author juana
 */

public class PracticaPOOmain {
    public static void main(String[] args) {
        coche c1 = new coche("Mercedes-Benz", 2019, "CLA 180");
        coche c2 = new coche("Mazda", 2026, "CX 30");
        
        c1.mostrarInfo();
        c2.mostrarInfo();
        
        cuentaBancaria p1 = new cuentaBancaria("Juan", 646000);
        cuentaBancaria p2 = new cuentaBancaria("Hector", 20000);
        
        p1.Retirar(100000);
        p1.Retirar(1000000);
        p2.Depositar(20000);
        p2.Depositar(20000000);
        p2.Depositar(0);
    }
}
