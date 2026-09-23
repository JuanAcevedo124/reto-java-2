// LECCIÓN 11: PATRÓN COMPOSITE
// Archivo: 11-Composite.java

// ¿QUÉ ES?
// Composite trata por igual a objetos individuales y a composiciones de objetos.
// Permite crear estructuras de árbol donde hojas y ramas usan la misma interfaz.

// ¿CUÁNDO SE USA?
// - Menús con submenús y opciones
// - Sistema de archivos (carpetas y archivos)
// - Organigramas (gerentes y empleados)

// ==================== EJEMPLO SENCILLO ====================

// Componente común
interface Componente {
    void mostrar(int nivel);
}

// Hoja (objeto individual)
class Hoja implements Componente {
    String nombre;

    public Hoja(String nombre) {
        this.nombre = nombre;
    }

    public void mostrar(int nivel) {
        for (int i = 0; i < nivel; i++) System.out.print("  ");
        System.out.println("📄 " + nombre);
    }
}

// Compuesto (contiene hijos)
class Carpeta implements Componente {
    String nombre;
    Componente[] hijos = new Componente[10];
    int totalHijos = 0;

    public Carpeta(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(Componente componente) {
        hijos[totalHijos] = componente;
        totalHijos++;
    }

    public void mostrar(int nivel) {
        for (int i = 0; i < nivel; i++) System.out.print("  ");
        System.out.println("📁 " + nombre);
        for (int i = 0; i < totalHijos; i++) {
            hijos[i].mostrar(nivel + 1);
        }
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

interface Figura {
    void dibujar(int nivel);
    double calcularArea();
}

class CirculoFigura implements Figura {
    double radio;

    public CirculoFigura(double radio) {
        this.radio = radio;
    }

    public void dibujar(int nivel) {
        for (int i = 0; i < nivel; i++) System.out.print("  ");
        System.out.println("⭕ Círculo (radio: " + radio + ")");
    }

    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}

class RectanguloFigura implements Figura {
    double ancho, alto;

    public RectanguloFigura(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public void dibujar(int nivel) {
        for (int i = 0; i < nivel; i++) System.out.print("  ");
        System.out.println("⬛ Rectángulo (" + ancho + "x" + alto + ")");
    }

    public double calcularArea() {
        return ancho * alto;
    }
}

class GrupoFiguras implements Figura {
    String nombre;
    Figura[] figuras = new Figura[10];
    int total = 0;

    public GrupoFiguras(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(Figura figura) {
        figuras[total] = figura;
        total++;
    }

    public void dibujar(int nivel) {
        for (int i = 0; i < nivel; i++) System.out.print("  ");
        System.out.println("📁 " + nombre);
        for (int i = 0; i < total; i++) {
            figuras[i].dibujar(nivel + 1);
        }
    }

    public double calcularArea() {
        double totalArea = 0;
        for (int i = 0; i < total; i++) {
            totalArea += figuras[i].calcularArea();
        }
        return totalArea;
    }
}

// ==================== CLASE PRINCIPAL ====================

public class Composite {
    public static void main(String[] args) {

        System.out.println("=== COMPOSITE ===\n");

        // Ejemplo 1: Sistema de archivos
        System.out.println("--- Sistema de Archivos ---");

        Carpeta raiz = new Carpeta("Proyecto");
        Carpeta src = new Carpeta("src");
        Carpeta docs = new Carpeta("docs");

        src.agregar(new Hoja("Main.java"));
        src.agregar(new Hoja("Utils.java"));
        docs.agregar(new Hoja("README.md"));

        raiz.agregar(src);
        raiz.agregar(docs);
        raiz.agregar(new Hoja("pom.xml"));

        raiz.mostrar(0);

        // Ejemplo 2: Figuras
        System.out.println("\n--- Figuras ---");

        GrupoFiguras grupo1 = new GrupoFiguras("Grupo 1");
        grupo1.agregar(new CirculoFigura(5));
        grupo1.agregar(new RectanguloFigura(4, 6));

        GrupoFiguras grupo2 = new GrupoFiguras("Grupo 2");
        grupo2.agregar(new CirculoFigura(3));

        GrupoFiguras todo = new GrupoFiguras("Todas las figuras");
        todo.agregar(grupo1);
        todo.agregar(grupo2);
        todo.agregar(new RectanguloFigura(2, 3));

        todo.dibujar(0);
        System.out.println("Área total: " + todo.calcularArea());
    }
}

// RESUMEN:
// 1. Componente → interfaz común (Figura, Componente)
// 2. Hoja → objeto individual sin hijos
// 3. Compuesto → contiene hijos, implementa la misma interfaz
// 4. Ventaja: tratas igual a hojas y ramas
