// LECCIÓN 17: PATRÓN MEDIATOR
// Archivo: 17-Mediator.java

// ¿QUÉ ES?
// Mediator centraliza comunicaciones entre objetos.
// En vez de que se hablen directamente, pasan por un mediador.

// ¿CUÁNDO SE USA?
- Chat rooms (un servidor centraliza mensajes)
- Control de tráfico aéreo (torre controla aviones)
- Componentes de UI que interactúan

// ==================== EJEMPLO SENCILLO ====================

// Interfaz Mediator
interface ChatMediator {
    void enviarMensaje(String mensaje, UsuarioChat usuario);
    void agregarUsuario(UsuarioChat usuario);
}

// Usuario
class UsuarioChat {
    String nombre;
    ChatMediator chat;

    public UsuarioChat(String nombre, ChatMediator chat) {
        this.nombre = nombre;
        this.chat = chat;
        chat.agregarUsuario(this);
    }

    public void enviar(String mensaje) {
        System.out.println(nombre + " envía: " + mensaje);
        chat.enviarMensaje(mensaje, this);
    }

    public void recibir(String mensaje, UsuarioChat remitente) {
        System.out.println("  " + nombre + " recibe de " + remitente.nombre + ": " + mensaje);
    }
}

// Mediador concreto
class ChatGeneral implements ChatMediator {
    UsuarioChat[] usuarios = new UsuarioChat[10];
    int total = 0;

    public void agregarUsuario(UsuarioChat usuario) {
        usuarios[total] = usuario;
        total++;
    }

    public void enviarMensaje(String mensaje, UsuarioChat remitente) {
        for (int i = 0; i < total; i++) {
            if (usuarios[i] != remitente) {
                usuarios[i].recibir(mensaje, remitente);
            }
        }
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

interface ControlTrafico {
    void registrarAvion(Avion avion);
    void autorizarDespegue(Avion avion);
    void autorizarAterrizaje(Avion avion);
}

class Avion {
    String codigo;
    ControlTrafico control;

    public Avion(String codigo, ControlTrafico control) {
        this.codigo = codigo;
        this.control = control;
        control.registrarAvion(this);
    }

    public void solicitarDespegue() {
        System.out.println(codigo + " solicita despegue");
        control.autorizarDespegue(this);
    }

    public void solicitarAterrizaje() {
        System.out.println(codigo + " solicita aterrizaje");
        control.autorizarAterrizaje(this);
    }

    public void recibirAutorizacion(String tipo) {
        System.out.println("  " + codigo + " autorizado para " + tipo);
    }
}

class TorreControl implements ControlTrafico {
    Avion[] aviones = new Avion[10];
    int total = 0;

    public void registrarAvion(Avion avion) {
        aviones[total] = avion;
        total++;
    }

    public void autorizarDespegue(Avion avion) {
        avion.recibirAutorizacion("despegue");
    }

    public void autorizarAterrizaje(Avion avion) {
        avion.recibirAutorizacion("aterrizaje");
    }
}

// ==================== CLASE PRINCIPAL ====================

public class Mediator {
    public static void main(String[] args) {

        System.out.println("=== MEDIATOR ===\n");

        // Ejemplo 1: Chat
        System.out.println("--- Chat ---");

        ChatGeneral chat = new ChatGeneral();
        UsuarioChat ana = new UsuarioChat("Ana", chat);
        UsuarioChat carlos = new UsuarioChat("Carlos", chat);
        UsuarioChat maria = new UsuarioChat("María", chat);

        ana.enviar("Hola a todos");

        System.out.println();

        carlos.enviar("Hola Ana!");

        // Ejemplo 2: Torre de control
        System.out.println("\n--- Torre de Control ---");

        TorreControl torre = new TorreControl();
        Avion avion1 = new Avion("AV-001", torre);
        Avion avion2 = new Avion("AV-002", torre);

        avion1.solicitarDespegue();
        avion2.solicitarAterrizaje();
    }
}

// RESUMEN:
// 1. Mediador → centraliza la comunicación
// 2. Colaboradores → se comunican solo con el mediador
// 3. Ventaja: reduce acoplamiento entre objetos
