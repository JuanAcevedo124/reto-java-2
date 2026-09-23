// LECCIÓN 14: PATRÓN PROXY
// Archivo: 14-Proxy.java

// ¿QUÉ ES?
// Proxy es un sustituto de otro objeto. Controla acceso al objeto real.
// Puede añadir lógica antes o después de la llamada al objeto real.

// ¿CUÁNDO SE USA?
- Control de acceso (solo usuarios autorizados)
- Caché (guardar resultados para no repetir)
- Lazy loading (cargar solo cuando se necesita)
- Logging (registrar quién accede)

// ==================== EJEMPLO SENCILLO ====================

// Interfaz común
interface Imagen {
    void mostrar();
}

// Objeto real
class ImagenReal implements Imagen {
    String nombre;

    public ImagenReal(String nombre) {
        this.nombre = nombre;
        System.out.println("Cargando imagen: " + nombre + " (lento)");
    }

    public void mostrar() {
        System.out.println("Mostrando imagen: " + nombre);
    }
}

// Proxy
class ImagenProxy implements Imagen {
    ImagenReal imagenReal;
    String nombre;
    boolean tienePermiso;

    public ImagenProxy(String nombre, boolean tienePermiso) {
        this.nombre = nombre;
        this.tienePermiso = tienePermiso;
    }

    public void mostrar() {
        if (!tienePermiso) {
            System.out.println("❌ Sin permiso para ver: " + nombre);
            return;
        }

        // Lazy loading: solo carga cuando se necesita
        if (imagenReal == null) {
            imagenReal = new ImagenReal(nombre);
        }

        imagenReal.mostrar();
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

interface Archivo {
    void leer();
    void escribir(String contenido);
}

class ArchivoReal implements Archivo {
    String nombre;
    String contenido = "";

    public ArchivoReal(String nombre) {
        this.nombre = nombre;
        System.out.println("Abriendo archivo: " + nombre);
    }

    public void leer() {
        System.out.println("Contenido: " + contenido);
    }

    public void escribir(String contenido) {
        this.contenido = contenido;
        System.out.println("Escrito: " + contenido);
    }
}

class ArchivoProxy implements Archivo {
    ArchivoReal archivoReal;
    String nombre;
    boolean esAdmin;

    public ArchivoProxy(String nombre, boolean esAdmin) {
        this.nombre = nombre;
        this.esAdmin = esAdmin;
    }

    public void leer() {
        if (archivoReal == null) {
            archivoReal = new ArchivoReal(nombre);
        }
        System.out.println("[LOG] Leyendo archivo: " + nombre);
        archivoReal.leer();
    }

    public void escribir(String contenido) {
        if (!esAdmin) {
            System.out.println("❌ Solo admin puede escribir en: " + nombre);
            return;
        }
        if (archivoReal == null) {
            archivoReal = new ArchivoReal(nombre);
        }
        System.out.println("[LOG] Escribiendo en: " + nombre);
        archivoReal.escribir(contenido);
    }
}

// ==================== CLASE PRINCIPAL ====================

public class Proxy {
    public static void main(String[] args) {

        System.out.println("=== PROXY ===\n");

        // Ejemplo 1: Imagen
        System.out.println("--- Imágenes ---");

        Imagen proxy1 = new ImagenProxy("foto.jpg", true);
        Imagen proxy2 = new ImagenProxy("secreto.png", false);

        proxy1.mostrar();
        proxy1.mostrar(); // ya está cargada

        proxy2.mostrar(); // sin permiso

        // Ejemplo 2: Archivo
        System.out.println("\n--- Archivos ---");

        Archivo admin = new ArchivoProxy("datos.txt", true);
        Archivo usuario = new ArchivoProxy("datos.txt", false);

        admin.leer();
        admin.escribir("Hola mundo");

        usuario.leer();
        usuario.escribir("Intento de escritura");
    }
}

// RESUMEN:
// 1. Interfaz común → lo que esperan ambos (real y proxy)
// 2. Objeto real → la implementación verdadera
// 3. Proxy → controla acceso, añade lógica antes/después
// 4. Ventaja: control, caché, lazy loading, logging
