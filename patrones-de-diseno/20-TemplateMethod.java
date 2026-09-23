// LECCIÓN 20: PATRÓN TEMPLATE METHOD
// Archivo: 20-TemplateMethod.java

// ¿QUÉ ES?
// Template Method define el esqueleto de un algoritmo en una clase base
// y permite a las subclases sobreescribir pasos específicos.

// ¿CUÁNDO SE USA?
- Cuando tienes pasos comunes pero algunos varían
- Para evitar duplicación de código
- Para definir el orden de ejecución

// ==================== EJEMPLO SENCILLO ====================

// Clase abstracta con el template
abstract class BebidaCaliente {
    // Template method: define el orden
    public final void preparar() {
        hervirAgua();
        agregar();
        servir();
        agregarExtras();
    }

    void hervirAgua() {
        System.out.println("  Hirviendo agua...");
    }

    abstract void agregar(); // cada hijo implementa diferente

    void servir() {
        System.out.println("  Sirviendo en taza...");
    }

    void agregarExtras() {
        System.out.println("  (extras opcionales)");
    }
}

// Subclases
class Te extends BebidaCaliente {
    void agregar() {
        System.out.println("  Agregando hojas de té...");
    }
}

class Cafe extends BebidaCaliente {
    void agregar() {
        System.out.println("  Agregando café molido...");
    }

    @Override
    void agregarExtras() {
        System.out.println("  Agregando leche y azúcar...");
    }
}

class Chocolate extends BebidaCaliente {
    void agregar() {
        System.out.println("  Agregando chocolate en polvo...");
    }

    @Override
    void agregarExtras() {
        System.out.println("  Agregando crema...");
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

abstract class ProcesoDatos {
    // Template method
    public final void ejecutar() {
        leerDatos();
        procesar();
        guardar();
        mostrarResultado();
    }

    abstract void leerDatos();
    abstract void procesar();

    void guardar() {
        System.out.println("  Guardando en base de datos...");
    }

    void mostrarResultado() {
        System.out.println("  Proceso completado\n");
    }
}

class ProcesoVentas extends ProcesoDatos {
    void leerDatos() {
        System.out.println("  Leyendo archivos de ventas...");
    }

    void procesar() {
        System.out.println("  Calculando totales de ventas...");
    }
}

class ProcesoInventario extends ProcesoDatos {
    void leerDatos() {
        System.out.println("  Leyendo inventario actual...");
    }

    void procesar() {
        System.out.println("  Actualizando stock...");
    }

    @Override
    void guardar() {
        System.out.println("  Guardando en archivo CSV...");
    }
}

// ==================== CLASE PRINCIPAL ====================

public class TemplateMethod {
    public static void main(String[] args) {

        System.out.println("=== TEMPLATE METHOD ===\n");

        // Ejemplo 1: Bebidas
        System.out.println("--- Bebidas Calientes ---");

        BebidaCaliente te = new Te();
        BebidaCaliente cafe = new Cafe();
        BebidaCaliente chocolate = new Chocolate();

        System.out.println("Preparando Té:");
        te.preparar();

        System.out.println("\nPreparando Café:");
        cafe.preparar();

        System.out.println("\nPreparando Chocolate:");
        chocolate.preparar();

        // Ejemplo 2: Procesos
        System.out.println("--- Procesos de Datos ---");

        ProcesoDatos ventas = new ProcesoVentas();
        ProcesoDatos inventario = new ProcesoInventario();

        System.out.println("Proceso de Ventas:");
        ventas.ejecutar();

        System.out.println("Proceso de Inventario:");
        inventario.ejecutar();
    }
}

// RESUMEN:
// 1. Template method → método final que define el orden
// 2. Métodos abstractos → los que cada hijo implementa diferente
// 3. Métodos con hook → los que se pueden sobreescribir (opcional)
// 4. Ventaja: evitas duplicar código, defines el flujo una vez
