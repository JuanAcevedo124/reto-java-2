// LECCIÓN 01: PATRÓN SINGLETON
// Archivo: 01-Singleton.java

// ¿QUÉ ES?
// Singleton asegura que una clase tenga SOLO UNA instancia
// y proporcione un punto de acceso global a ella.

// ¿CUÁNDO SE USA?
// - Conexiones a base de datos
// - Configuraciones globales
// - Logs (registros)
// - Cache

// ==================== EJEMPLO SENCILLO ====================

class Configuracion {
    // 1. Variable estática que guarda la única instancia
    private static Configuracion instancia;

    // 2. Datos de configuración
    private String idioma;
    private String tema;

    // 3. Constructor privado (NO se puede hacer new desde afuera)
    private Configuracion() {
        this.idioma = "Español";
        this.tema = "Claro";
        System.out.println("Configuración creada (solo una vez)");
    }

    // 4. Método estático para obtener la instancia
    public static Configuracion getInstancia() {
        if (instancia == null) {
            instancia = new Configuracion();
        }
        return instancia;
    }

    // 5. Getters y Setters
    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    public String getTema() { return tema; }
    public void setTema(String tema) { this.tema = tema; }

    public void mostrarConfig() {
        System.out.println("Idioma: " + idioma + " | Tema: " + tema);
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

class BaseDatos {
    private static BaseDatos instancia;
    private String conexion;

    private BaseDatos() {
        this.conexion = "Conectado a MySQL";
        System.out.println("Conexión establecida");
    }

    public static BaseDatos getInstancia() {
        if (instancia == null) {
            instancia = new BaseDatos();
        }
        return instancia;
    }

    public void ejecutarQuery(String query) {
        System.out.println("Ejecutando: " + query);
    }
}

// ==================== CLASE PRINCIPAL ====================

public class Singleton {
    public static void main(String[] args) {

        System.out.println("=== SINGLETON ===\n");

        // Intentamos crear dos "instancias"
        Configuracion config1 = Configuracion.getInstancia();
        Configuracion config2 = Configuracion.getInstancia();

        // Son la misma instancia
        System.out.println("¿Son la misma instancia? " + (config1 == config2));

        // Modifico desde una referencia
        config1.setIdioma("Inglés");
        config1.setTema("Oscuro");

        // La otra referencia ve los cambios
        config2.mostrarConfig(); // Inglés | Oscuro

        System.out.println();

        // Ejemplo con Base de Datos
        BaseDatos db1 = BaseDatos.getInstancia();
        BaseDatos db2 = BaseDatos.getInstancia();

        System.out.println("¿Misma conexión? " + (db1 == db2));

        db1.ejecutarQuery("SELECT * FROM usuarios");
        db2.ejecutarQuery("INSERT INTO usuarios VALUES...");
    }
}

// RESUMEN:
// 1. Constructor privado → no puedes hacer new
// 2. Variable estática → guarda la instancia
// 3. Método getInstancia() → crea si no existe, retorna la misma siempre
// 4. Resultado: SIEMPRE hay una sola instancia
