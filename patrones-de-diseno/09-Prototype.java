// LECCIÓN 09: PATRÓN PROTOTYPE
// Archivo: 09-Prototype.java

// ¿QUÉ ES?
// Prototype crea objetos clonando una instancia existente.
// En vez de crear desde cero, copias un objeto ya hecho.

// ¿CUÁNDO SE USA?
// - Crear objetos costosos (conexiones, configuraciones complejas)
// - Cuando tienes muchos objetos similares
// - Cuando la creación desde cero es lenta

// ==================== EJEMPLO SENCILLO ====================

// Interfaz Cloneable
class AnimalClone implements Cloneable {
    String tipo;
    String nombre;
    String color;

    public AnimalClone(String tipo, String nombre, String color) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.color = color;
    }

    // Método para clonar
    public AnimalClone clonar() {
        try {
            return (AnimalClone) this.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void mostrar() {
        System.out.println(tipo + ": " + nombre + " (" + color + ")");
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

class Configuracion implements Cloneable {
    String idioma;
    String tema;
    String fuente;
    int tamanoFuente;
    boolean notificaciones;

    public Configuracion(String idioma, String tema, String fuente, int tamanoFuente, boolean notificaciones) {
        this.idioma = idioma;
        this.tema = tema;
        this.fuente = fuente;
        this.tamanoFuente = tamanoFuente;
        this.notificaciones = notificaciones;
    }

    public Configuracion clonar() {
        try {
            return (Configuracion) this.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void mostrar() {
        System.out.println("Idioma: " + idioma + " | Tema: " + tema);
        System.out.println("Fuente: " + fuente + " | Tamaño: " + tamanoFuente);
        System.out.println("Notificaciones: " + notificaciones);
    }
}

// ==================== CLASE PRINCIPAL ====================

public class Prototype {
    public static void main(String[] args) {

        System.out.println("=== PROTOTYPE ===\n");

        // Ejemplo 1: Animales
        System.out.println("--- Animales ---");

        AnimalClone perro = new AnimalClone("Perro", "Rex", "Marrón");
        AnimalClone gato = perro.clonar();
        gato.nombre = "Michi";
        gato.color = "Negro";

        perro.mostrar();
        gato.mostrar();

        // Ejemplo 2: Configuración
        System.out.println("\n--- Configuración ---");

        Configuracion configBase = new Configuracion("Español", "Oscuro", "Arial", 14, true);
        Configuracion configPersonal = configBase.clonar();
        configPersonal.idioma = "Inglés";
        configPersonal.tema = "Claro";

        System.out.println("Base:");
        configBase.mostrar();
        System.out.println("\nPersonal:");
        configPersonal.mostrar();
    }
}

// RESUMEN:
// 1. Cloneable → interfaz que indica que se puede clonar
// 2. clone() → método que copia el objeto
// 3. Ventaja: evitas crear objetos costosos desde cero
