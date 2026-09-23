// LECCIÓN 03: PATRÓN OBSERVER
// Archivo: 03-Observer.java

// ¿QUÉ ES?
// Observer define una relación de dependencia cuando un objeto
// (Sujeto) cambia de estado, todos sus dependientes (Observadores)
// son notificados automáticamente.

// ¿CUÁNDO SE USA?
// - Redes sociales: cuando alguien publica, sus seguidores son notificados
// - YouTube: cuando el canal sube un video, los suscriptores reciben aviso
// - Excel: cuando cambias una celda, las fórmulas que dependen se actualizan
// - Eventos en interfaces gráficas (botones, clicks)

// ==================== EJEMPLO SENCILLO ====================

// Interfaz del Observador
interface Observador {
    void actualizar(String mensaje);
}

// El Sujeto (quien tiene la información)
class CanalYouTube {
    private String nombre;
    private Observador[] suscriptores = new Observador[10];
    private int totalSuscriptores = 0;

    public CanalYouTube(String nombre) {
        this.nombre = nombre;
    }

    public void suscribir(Observador observador) {
        suscriptores[totalSuscriptores] = observador;
        totalSuscriptores++;
    }

    public void publicarVideo(String titulo) {
        System.out.println("\n🎬 " + nombre + " publicó: " + titulo);
        notificarTodos("Nuevo video: " + titulo);
    }

    private void notificarTodos(String mensaje) {
        for (int i = 0; i < totalSuscriptores; i++) {
            suscriptores[i].actualizar(mensaje);
        }
    }
}

// Observadores concretos
class Usuario implements Observador {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public void actualizar(String mensaje) {
        System.out.println("  📱 " + nombre + " recibió: " + mensaje);
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

interface ObservadorTienda {
    void onProductoAgotado(String producto);
}

class Tienda {
    private ObservadorTienda[] observadores = new ObservadorTienda[10];
    private int total = 0;

    public void registrarObservador(ObservadorTienda obs) {
        observadores[total] = obs;
        total++;
    }

    public void agotarProducto(String producto) {
        System.out.println("\n🛒 Producto agotado: " + producto);
        for (int i = 0; i < total; i++) {
            observadores[i].onProductoAgotado(producto);
        }
    }
}

class ClienteNotificado implements ObservadorTienda {
    private String nombre;

    public ClienteNotificado(String nombre) {
        this.nombre = nombre;
    }

    public void onProductoAgotado(String producto) {
        System.out.println("  🔔 " + nombre + ": ¡Oh no! " + producto + " se agotó");
    }
}

class AdminNotificado implements ObservadorTienda {
    public void onProductoAgotado(String producto) {
        System.out.println("  📊 Admin: Reabastecer " + producto);
    }
}

// ==================== CLASE PRINCIPAL ====================

public class Observer {
    public static void main(String[] args) {

        System.out.println("=== OBSERVER ===\n");

        // Ejemplo 1: YouTube
        CanalYouTube canal = new CanalYouTube("CodeMaster");

        Usuario u1 = new Usuario("Ana");
        Usuario u2 = new Usuario("Carlos");
        Usuario u3 = new Usuario("María");

        canal.suscribir(u1);
        canal.suscribir(u2);
        canal.suscribir(u3);

        canal.publicarVideo("Patrones de Diseño en Java");

        // Ejemplo 2: Tienda
        System.out.println("\n--- Tienda Online ---");

        Tienda tienda = new Tienda();

        ClienteNotificado cliente1 = new ClienteNotificado("Pedro");
        ClienteNotificado cliente2 = new ClienteNotificado("Laura");
        AdminNotificado admin = new AdminNotificado();

        tienda.registrarObservador(cliente1);
        tienda.registrarObservador(cliente2);
        tienda.registrarObservador(admin);

        tienda.agotarProducto("Laptop Gamer");
        tienda.agotarProducto("Mouse RGB");
    }
}

// RESUMEN:
// 1. Observador → interfaz con método actualizar()
// 2. Sujeto → tiene lista de observadores y les avisa cuando cambia
// 3. Observadores concretos → reaccionan al cambio
// 4. Ventaja: desacoplas el sujeto de sus dependientes
