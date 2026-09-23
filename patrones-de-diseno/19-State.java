// LECCIÓN 19: PATRÓN STATE
// Archivo: 19-State.java

// ¿QUÉ ES?
// State permite a un objeto cambiar de comportamiento cuando cambia su estado.
// Cada estado se representa como una clase separada.

// ¿CUÁNDO SE USA?
- Máquinas de estados (pedidos, turnos)
- Videojuegos (personaje corriendo, saltando, quieto)
- Puertas (abierta, cerrada, bloqueada)

// ==================== EJEMPLO SENCILLO ====================

// Interfaz State
interface EstadoPuerta {
    void abrir(Puerta puerta);
    void cerrar(Puerta puerta);
}

// Estados concretos
class PuertaAbierta implements EstadoPuerta {
    public void abrir(Puerta puerta) {
        System.out.println("La puerta ya está abierta");
    }

    public void cerrar(Puerta puerta) {
        System.out.println("Cerrando puerta...");
        puerta.setEstado(new PuertaCerrada());
    }
}

class PuertaCerrada implements EstadoPuerta {
    public void abrir(Puerta puerta) {
        System.out.println("Abriendo puerta...");
        puerta.setEstado(new PuertaAbierta());
    }

    public void cerrar(Puerta puerta) {
        System.out.println("La puerta ya está cerrada");
    }
}

// Contexto
class Puerta {
    private EstadoPuerta estado;

    public Puerta() {
        this.estado = new PuertaCerrada();
    }

    public void setEstado(EstadoPuerta estado) {
        this.estado = estado;
    }

    public void abrir() {
        estado.abrir(this);
    }

    public void cerrar() {
        estado.cerrar(this);
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

interface EstadoPedido {
    void siguiente(Pedido pedido);
    void mostrar();
}

class EstadoNuevo implements EstadoPedido {
    public void siguiente(Pedido pedido) {
        System.out.println("  Pedido enviado a preparación");
        pedido.setEstado(new EstadoPreparando());
    }

    public void mostrar() {
        System.out.println("  Estado: Nuevo");
    }
}

class EstadoPreparando implements EstadoPedido {
    public void siguiente(Pedido pedido) {
        System.out.println("  Pedido listo para envío");
        pedido.setEstado(new EstadoListo());
    }

    public void mostrar() {
        System.out.println("  Estado: Preparando");
    }
}

class EstadoListo implements EstadoPedido {
    public void siguiente(Pedido pedido) {
        System.out.println("  Pedido entregado al cliente");
        pedido.setEstado(new EstadoEntregado());
    }

    public void mostrar() {
        System.out.println("  Estado: Listo");
    }
}

class EstadoEntregado implements EstadoPedido {
    public void siguiente(Pedido pedido) {
        System.out.println("  El pedido ya fue entregado");
    }

    public void mostrar() {
        System.out.println("  Estado: Entregado");
    }
}

class Pedido {
    private EstadoPedido estado;

    public Pedido() {
        this.estado = new EstadoNuevo();
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void siguiente() {
        estado.siguiente(this);
    }

    public void mostrar() {
        estado.mostrar();
    }
}

// ==================== CLASE PRINCIPAL ====================

public class State {
    public static void main(String[] args) {

        System.out.println("=== STATE ===\n");

        // Ejemplo 1: Puerta
        System.out.println("--- Puerta ---");

        Puerta puerta = new Puerta();
        puerta.abrir();
        puerta.abrir();
        puerta.cerrar();
        puerta.cerrar();
        puerta.abrir();

        // Ejemplo 2: Pedido
        System.out.println("\n--- Pedido ---");

        Pedido pedido = new Pedido();

        pedido.mostrar();
        pedido.siguiente();

        pedido.mostrar();
        pedido.siguiente();

        pedido.mostrar();
        pedido.siguiente();

        pedido.mostrar();
        pedido.siguiente();
    }
}

// RESUMEN:
// 1. State → interfaz de cada estado
// 2. Estados concretos → implementan comportamiento específico
// 3. Contexto → cambia de estado dinámicamente
// 4. Ventaja: el objeto cambia comportamiento sin condicionales gigantes
