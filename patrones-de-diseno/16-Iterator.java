// LECCIÓN 16: PATRÓN ITERATOR
// Archivo: 16-Iterator.java

// ¿QUÉ ES?
// Iterator recorre una colección sin exponer su estructura interna.
// Proporciona una forma uniforme de acceder a los elementos.

// ¿CUÁNDO SE USA?
- Recorrer listas, árboles, grafos
- Cuando no quieres exponer la estructura interna
- Para tener múltiples formas de recorrer lo mismo

// ==================== EJEMPLO SENCILLO ====================

// Interfaz Iterator
interface Iterador {
    boolean tieneSiguiente();
    Object siguiente();
}

// Interfaz Iterable
interface Coleccion {
    Iterador crearIterador();
}

// Colección concreta
class ListaNombres implements Coleccion {
    String[] nombres = new String[10];
    int total = 0;

    public void agregar(String nombre) {
        nombres[total] = nombre;
        total++;
    }

    public Iterador crearIterador() {
        return new IteradorNombres(nombres, total);
    }
}

// Iterator concreto
class IteradorNombres implements Iterador {
    String[] nombres;
    int total;
    int posicion = 0;

    public IteradorNombres(String[] nombres, int total) {
        this.nombres = nombres;
        this.total = total;
    }

    public boolean tieneSiguiente() {
        return posicion < total;
    }

    public String siguiente() {
        String nombre = nombres[posicion];
        posicion++;
        return nombre;
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

interface IteradorNumeros {
    boolean tieneSiguiente();
    int siguiente();
}

class NumerosPares implements Coleccion {
    int limite;

    public NumerosPares(int limite) {
        this.limite = limite;
    }

    public Iterador crearIterador() {
        return new IteradorPares(limite);
    }
}

class IteradorPares implements IteradorNumeros {
    int limite;
    int actual = 0;

    public IteradorPares(int limite) {
        this.limite = limite;
    }

    public boolean tieneSiguiente() {
        return actual <= limite;
    }

    public int siguiente() {
        int valor = actual;
        actual += 2;
        return valor;
    }
}

// ==================== CLASE PRINCIPAL ====================

public class Iterator {
    public static void main(String[] args) {

        System.out.println("=== ITERATOR ===\n");

        // Ejemplo 1: Lista de nombres
        System.out.println("--- Lista de Nombres ---");

        ListaNombres lista = new ListaNombres();
        lista.agregar("Ana");
        lista.agregar("Carlos");
        lista.agregar("María");

        Iterador iterador = lista.crearIterador();
        while (iterador.tieneSiguiente()) {
            System.out.println("  👤 " + iterador.siguiente());
        }

        // Ejemplo 2: Números pares
        System.out.println("\n--- Números Pares ---");

        NumerosPares pares = new NumerosPares(10);
        IteradorNumeros iterPares = (IteradorNumeros) pares.crearIterador();

        System.out.print("  Pares: ");
        while (iterPares.tieneSiguiente()) {
            System.out.print(iterPares.siguiente() + " ");
        }
        System.out.println();
    }
}

// RESUMEN:
// 1. Iterator → interfaz con tieneSiguiente() y siguiente()
// 2. Colección → crea iteradores
// 3. Iterator concreto → implementa la lógica de recorrido
// 4. Ventaja: recorres colecciones sin saber cómo están almacenadas
