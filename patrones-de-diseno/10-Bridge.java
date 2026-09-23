// LECCIÓN 10: PATRÓN BRIDGE
// Archivo: 10-Bridge.java

// ¿QUÉ ES?
// Bridge separa una abstraction de su implementación.
// Permite que ambas evolucionen independientemente.

// ¿CUÁNDO SE USA?
- Cuando tienes dos dimensiones independientes (ej: forma + color)
- Para evitar explosión de clases (CírculoRojo, CuadradoAzul, etc.)
- Cuando quieres cambiar la implementación en tiempo de ejecución

// ==================== EJEMPLO SENCILLO ====================

// Implementación
interface Forma {
    void dibujar();
}

// Implementaciones concretas
class CirculoForma implements Forma {
    public void dibujar() {
        System.out.println("    ⭕");
    }
}

class CuadradoForma implements Forma {
    public void dibujar() {
        System.out.println("    ⬛");
    }
}

// Abstracción
abstract class Color {
    protected Forma forma;

    public Color(Forma forma) {
        this.forma = forma;
    }

    abstract void aplicar();
}

// Abstracciones concretas
class Rojo extends Color {
    public Rojo(Forma forma) {
        super(forma);
    }

    public void aplicar() {
        System.out.print("🔴 Rojo ");
        forma.dibujar();
    }
}

class Azul extends Color {
    public Azul(Forma forma) {
        super(forma);
    }

    public void aplicar() {
        System.out.print("🔵 Azul ");
        forma.dibujar();
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

// Implementación: tipo de notificación
interface TipoNotificacion {
    void enviar(String mensaje);
}

class NotificacionEmail implements TipoNotificacion {
    public void enviar(String mensaje) {
        System.out.println("📧 Email: " + mensaje);
    }
}

class NotificacionSMS implements TipoNotificacion {
    public void enviar(String mensaje) {
        System.out.println("📱 SMS: " + mensaje);
    }
}

// Abstracción: prioridad del mensaje
abstract class Mensaje {
    protected TipoNotificacion tipo;

    public Mensaje(TipoNotificacion tipo) {
        this.tipo = tipo;
    }

    abstract void enviar(String mensaje);
}

class MensajeUrgente extends Mensaje {
    public MensajeUrgente(TipoNotificacion tipo) {
        super(tipo);
    }

    public void enviar(String mensaje) {
        System.out.print("🚨 [URGENTE] ");
        tipo.enviar(mensaje);
    }
}

class MensajeNormal extends Mensaje {
    public MensajeNormal(TipoNotificacion tipo) {
        super(tipo);
    }

    public void enviar(String mensaje) {
        System.out.print("ℹ️ [NORMAL] ");
        tipo.enviar(mensaje);
    }
}

// ==================== CLASE PRINCIPAL ====================

public class Bridge {
    public static void main(String[] args) {

        System.out.println("=== BRIDGE ===\n");

        // Ejemplo 1: Formas y colores
        System.out.println("--- Formas con colores ---");

        Color rojoCirculo = new Rojo(new CirculoForma());
        Color azulCuadrado = new Azul(new CuadradoForma());
        Color rojoCuadrado = new Rojo(new CuadradoForma());

        rojoCirculo.aplicar();
        azulCuadrado.aplicar();
        rojoCuadrado.aplicar();

        // Ejemplo 2: Notificaciones
        System.out.println("\n--- Notificaciones ---");

        Mensaje urgenteEmail = new MensajeUrgente(new NotificacionEmail());
        Mensaje normalSMS = new MensajeNormal(new NotificacionSMS());

        urgenteEmail.enviar("El servidor está caído");
        normalSMS.enviar("Tu pedido fue enviado");
    }
}

// RESUMEN:
// 1. Implementación → interfaz de la parte técnica (Forma, TipoNotificacion)
// 2. Abstracción → referencia a la implementación (Color, Mensaje)
// 3. Ventaja: combinas × dimensiones sin crear muchas clases
