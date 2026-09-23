// Solución Ejercicio 1 - Clase de ejemplo
package poo;
public class Coche {
    private String marca;
    private String modelo;
    private int ano;

    public Coche(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void mostrarInfo() {
        System.out.println(marca + " " + modelo + " (" + ano + ")");
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public int getAno() { return ano; }
    public void setAno(int ano) {
        if (ano >= 1900 && ano <= 2026) this.ano = ano;
        else System.out.println("Año inválido");
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " - " + ano;
    }
}
