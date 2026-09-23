/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica.folder;

/**
 *
 * @author juana
 */

public class coche {
    private String marca;
    private String modelo;
    private int ano;
    
    public coche(String marca, int ano, String modelo) {
        this.marca = marca; // this.nombre = atributo, nombre = parámetro
        this.ano = ano;
        this.modelo = modelo;
}
    public void mostrarInfo() {
    System.out.println("Marca: " + marca + " / " + "Modelo: " + modelo + " / " + " Año: " + ano);
}
    
    public String getMarca() {
        return marca;
    }
    public void setMarca() {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo() {
        this.modelo = modelo;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(){ 
        if (ano >= 1885 && ano <= 2026) { // validación
            this.ano = ano;
        } else {
            System.out.println("Año inválido");
        }
    }
}

        
    

