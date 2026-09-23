// LECCIÓN 07: PATRÓN BUILDER
// Archivo: 07-Builder.java

// ¿QUÉ ES?
// Builder construye objetos complejos paso a paso.
// Permite crear diferentes representaciones del mismo objeto
// usando los mismos pasos de construcción.

// ¿CUÁNDO SE USA?
// - Objetos con muchos parámetros (algunos opcionales)
// - Construir objetos que tienen partes que se pueden combinar
// - Evitar constructores con 10+ parámetros

// ==================== EJEMPLO SENCILLO ====================

class Pizza {
    private String masa;
    private String tamano;
    private String salsa;
    private String[] ingredientes;

    // Constructor privado - solo el builder lo usa
    private Pizza(Builder builder) {
        this.masa = builder.masa;
        this.tamano = builder.tamano;
        this.salsa = builder.salsa;
        this.ingredientes = builder.ingredientes;
    }

    public void mostrar() {
        System.out.println("🍕 Pizza " + tamano);
        System.out.println("   Masa: " + masa);
        System.out.println("   Salsa: " + salsa);
        System.out.print("   Ingredientes: ");
        for (int i = 0; i < ingredientes.length; i++) {
            System.out.print(ingredientes[i]);
            if (i < ingredientes.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    // Builder interno
    static class Builder {
        private String masa = "tradicional";
        private String tamano = "mediana";
        private String salsa = "tomate";
        private String[] ingredientes = new String[0];

        public Builder masa(String masa) {
            this.masa = masa;
            return this;
        }

        public Builder tamano(String tamano) {
            this.tamano = tamano;
            return this;
        }

        public Builder salsa(String salsa) {
            this.salsa = salsa;
            return this;
        }

        public Builder ingredientes(String... ingredientes) {
            this.ingredientes = ingredientes;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

class Computadora {
    private String marca;
    private String procesador;
    private int ram;
    private int disco;
    private String tarjetaVideo;
    private boolean bluetooth;

    private Computadora(Builder builder) {
        this.marca = builder.marca;
        this.procesador = builder.procesador;
        this.ram = builder.ram;
        this.disco = builder.disco;
        this.tarjetaVideo = builder.tarjetaVideo;
        this.bluetooth = builder.bluetooth;
    }

    public void mostrar() {
        System.out.println("💻 Computadora " + marca);
        System.out.println("   Procesador: " + procesador);
        System.out.println("   RAM: " + ram + " GB");
        System.out.println("   Disco: " + disco + " GB");
        System.out.println("   Tarjeta Video: " + tarjetaVideo);
        System.out.println("   Bluetooth: " + (bluetooth ? "Sí" : "No"));
    }

    static class Builder {
        private String marca;
        private String procesador;
        private int ram = 8;
        private int disco = 256;
        private String tarjetaVideo = "Integrada";
        private boolean bluetooth = false;

        public Builder(String marca, String procesador) {
            this.marca = marca;
            this.procesador = procesador;
        }

        public Builder ram(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder disco(int disco) {
            this.disco = disco;
            return this;
        }

        public Builder tarjetaVideo(String tarjetaVideo) {
            this.tarjetaVideo = tarjetaVideo;
            return this;
        }

        public Builder bluetooth(boolean bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }

        public Computadora build() {
            return new Computadora(this);
        }
    }
}

// ==================== CLASE PRINCIPAL ====================

public class Builder {
    public static void main(String[] args) {

        System.out.println("=== BUILDER ===\n");

        // Ejemplo 1: Pizza
        System.out.println("--- Pizzas ---");

        Pizza pepperoni = new Pizza.Builder()
                .tamano("grande")
                .masa("fina")
                .ingredientes("pepperoni", "queso", "champiñones")
                .build();

        Pizza vegetariana = new Pizza.Builder()
                .tamano("mediana")
                .masa("integral")
                .salsa("pesto")
                .ingredientes("tomate", "pimiento", "aceituna", "calabacín")
                .build();

        pepperoni.mostrar();
        vegetariana.mostrar();

        // Ejemplo 2: Computadora
        System.out.println("\n--- Computadoras ---");

        Computadora basica = new Computadora.Builder("Lenovo", "i5")
                .build();

        Computadora gaming = new Computadora.Builder("ASUS", "i9")
                .ram(32)
                .disco(1000)
                .tarjetaVideo("RTX 4080")
                .bluetooth(true)
                .build();

        basica.mostrar();
        gaming.mostrar();
    }
}

// RESUMEN:
// 1. Clase con constructor privado → solo el builder la crea
// 2. Builder estático interno → tiene métodos encadenables
// 3. build() → construye el objeto final
// 4. Ventaja: creas objetos complejos sin constructores gigantes
