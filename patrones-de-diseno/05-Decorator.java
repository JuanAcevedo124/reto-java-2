// LECCIÓN 05: PATRÓN DECORATOR
// Archivo: 05-Decorator.java

// ¿QUÉ ES?
// Decorator agrega funcionalidades a un objeto de forma dinámica
// sin modificar su código fuente. Envuelve al objeto original.

// ¿CUÁNDO SE USA?
// - Cafetería: café + leche + azúcar + crema (cada uno agrega algo)
// - Ventanas: ventana básica + barra de título + borde + scroll
// - Archivos: comprimir + encriptar + comprimir de nuevo

// ==================== EJEMPLO SENCILLO ====================

// Componente base
interface Bebida {
    String getDescripcion();
    double getPrecio();
}

// Componente concreto
class CafeSimple implements Bebida {
    public String getDescripcion() {
        return "Café simple";
    }

    public double getPrecio() {
        return 50.0;
    }
}

// Decorador base
abstract class DecoradorBebida implements Bebida {
    protected Bebida bebida;

    public DecoradorBebida(Bebida bebida) {
        this.bebida = bebida;
    }
}

// Decoradores concretos
class ConLeche extends DecoradorBebida {
    public ConLeche(Bebida bebida) {
        super(bebida);
    }

    public String getDescripcion() {
        return bebida.getDescripcion() + " + leche";
    }

    public double getPrecio() {
        return bebida.getPrecio() + 15.0;
    }
}

class ConAzucar extends DecoradorBebida {
    public ConAzucar(Bebida bebida) {
        super(bebida);
    }

    public String getDescripcion() {
        return bebida.getDescripcion() + " + azúcar";
    }

    public double getPrecio() {
        return bebida.getPrecio() + 5.0;
    }
}

class ConCrema extends DecoradorBebida {
    public ConCrema(Bebida bebida) {
        super(bebida);
    }

    public String getDescripcion() {
        return bebida.getDescripcion() + " + crema";
    }

    public double getPrecio() {
        return bebida.getPrecio() + 20.0;
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

interface Notificacion {
    String getMensaje();
}

class NotificacionBasica implements Notificacion {
    private String mensaje;

    public NotificacionBasica(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}

abstract class DecoradorNotificacion implements Notificacion {
    protected Notificacion notificacion;

    public DecoradorNotificacion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }
}

class ConEmoji extends DecoradorNotificacion {
    public ConEmoji(Notificacion notificacion) {
        super(notificacion);
    }

    public String getMensaje() {
        return "🔔 " + notificacion.getMensaje() + " 🔔";
    }
}

class ConMayusculas extends DecoradorNotificacion {
    public ConMayusculas(Notificacion notificacion) {
        super(notificacion);
    }

    public String getMensaje() {
        return notificacion.getMensaje().toUpperCase();
    }
}

class ConFormato extends DecoradorNotificacion {
    public ConFormato(Notificacion notificacion) {
        super(notificacion);
    }

    public String getMensaje() {
        return "=== " + notificacion.getMensaje() + " ===";
    }
}

// ==================== CLASE PRINCIPAL ====================

public class Decorator {
    public static void main(String[] args) {

        System.out.println("=== DECORATOR ===\n");

        // Ejemplo 1: Café
        System.out.println("--- Cafetería ---");

        Bebida cafe = new CafeSimple();
        System.out.println(cafe.getDescripcion() + " → $" + cafe.getPrecio());

        Bebida cafeConLeche = new ConLeche(cafe);
        System.out.println(cafeConLeche.getDescripcion() + " → $" + cafeConLeche.getPrecio());

        Bebida cafeCompleto = new ConCrema(new ConAzucar(new ConLeche(cafe)));
        System.out.println(cafeCompleto.getDescripcion() + " → $" + cafeCompleto.getPrecio());

        // Ejemplo 2: Notificaciones
        System.out.println("\n--- Notificaciones ---");

        Notificacion basica = new NotificacionBasica("Tu pedido fue enviado");

        Notificacion conEmoji = new ConEmoji(basica);
        System.out.println(conEmoji.getMensaje());

        Notificacion conMayus = new ConMayusculas(basica);
        System.out.println(conMayus.getMensaje());

        Notificacion todoJunto = new ConEmoji(new ConMayusculas(new ConFormato(basica)));
        System.out.println(todoJunto.getMensaje());
    }
}

// RESUMEN:
// 1. Componente → interfaz base (Bebida)
// 2. Componente concreto → implementación básica (CafeSimple)
// 3. Decorador → implementa misma interfaz, tiene referencia al componente
// 4. Decoradores concretos → agregan funcionalidad sin modificar el original
// 5. Ventaja: combinas comportamientos como capas (café + leche + azúcar)
