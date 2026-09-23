/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica.folder;

/**
 *
 * @author juana
 */

public class cuentaBancaria {
    private String titular;
    private double saldo;
    
    public cuentaBancaria(String titular, double saldo) {
        this.titular = titular; // this.nombre = atributo, nombre = parámetro
        this.saldo = saldo;
    }
    
    public void Retirar(double cantidad) {
        if (saldo >= cantidad) {
            saldo = saldo - cantidad;
        System.out.println("Retirado con exito");
        System.out.println("Nuevo saldo: " + saldo);
        }
        else {
            System.out.println("Saldo insuficiente");
        }
    }
    
    public void Depositar(double cantidad) {
        if (cantidad > 0 && cantidad < 10000000) {
            saldo = saldo + cantidad;
        System.out.println("Depositado con exito");
        System.out.println("Nuevo saldo: " + saldo);
        }
        else {
            System.out.println("Transaccion no permitida");
        }
    }
}           


