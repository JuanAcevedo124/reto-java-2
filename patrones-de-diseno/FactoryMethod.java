// LECCIÓN 02: PATRÓN FACTORY METHOD
// Archivo: 02-FactoryMethod.java

// ¿QUÉ ES?
// Factory Method crea objetos sin especificar la clase exacta.
// En vez de usar "new", delegas la creación a un método fábrica.

// ¿CUÁNDO SE USA?
// - Cuando no sabes qué tipo de objeto necesitas hasta runtime
// - Cuando quieres centralizar la creación de objetos
// - Cuando necesitas diferentes variantes de un mismo producto

// ==================== EJEMPLO SENCILLO ====================

// Interfaz común para todos los productos
interface Animal {
    void hacerSonido();
}

// Productos concretos
class Perro implements Animal {
    public void hacerSonido() {
        System.out.println("Guau guau");
    }
}

class Gato implements Animal {
    public void hacerSonido() {
        System.out.println("Miau");
    }
}

class Pajaro implements Animal {
    public void hacerSonido() {
        System.out.println("Pio pio");
    }
}       

// La Fábrica
class AnimalFactory {
    public static Animal crearAnimal(String tipo) {
        switch (tipo.toLowerCase()) {
            case "perro": return new Perro();
            case "gato": return new Gato();
            case "pajaro": return new Pajaro();
            default: throw new IllegalArgumentException("Animal no válido: " + tipo);
        }
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

interface Notificacion {
    void enviar(String mensaje);
}

class NotificacionEmail implements Notificacion {
    public void enviar(String mensaje) {
        System.out.println("📧 Email: " + mensaje);
    }
}

class NotificacionSMS implements Notificacion {
    public void enviar(String mensaje) {
        System.out.println("📱 SMS: " + mensaje);
    }
}

class NotificacionPush implements Notificacion {
    public void enviar(String mensaje) {
        System.out.println("🔔 Push: " + mensaje);
    }
}

class NotificacionFactory {
    public static Notificacion crear(String tipo) {
        switch (tipo.toLowerCase()) {
            case "email": return new NotificacionEmail();
            case "sms": return new NotificacionSMS();
            case "push": return new NotificacionPush();
            default: throw new IllegalArgumentException("Tipo no válido: " + tipo);
        }
    }
}

// ==================== CLASE PRINCIPAL ====================

public class FactoryMethod {
    public static void main(String[] args) {

        System.out.println("=== FACTORY METHOD ===\n");

        // Sin Factory: tendríamos que decidir qué clase usar
        // Animal a = new Perro(); // el cliente sabe qué crear

        // Con Factory: solo pasamos el tipo
        Animal perro = AnimalFactory.crearAnimal("perro");
        Animal gato = AnimalFactory.crearAnimal("gato");
        Animal pajaro = AnimalFactory.crearAnimal("pajaro");

        perro.hacerSonido();   // Guau guau
        gato.hacerSonido();    // Miau
        pajaro.hacerSonido();  // Pio pio

        System.out.println();

        // Ejemplo práctico: Notificaciones
        Notificacion email = NotificacionFactory.crear("email");
        Notificacion sms = NotificacionFactory.crear("sms");
        Notificacion push = NotificacionFactory.crear("push");

        email.enviar("Tu pedido fue enviado");
        sms.enviar("Código de verificación: 1234");
        push.enviar("Tienes un nuevo mensaje");

        System.out.println();

        // Ventaja: el cliente no necesita saber qué clase específica crear
        String tipoUsuario = "sms"; // podría venir de una BD
        Notificacion n = NotificacionFactory.crear(tipoUsuario);
        n.enviar("Alerta para el usuario");
    }
}

// RESUMEN:
// 1. Interfaz común → todos los productos implementan lo mismo
// 2. Fábrica → método estático que decide qué clase crear
// 3. Cliente → solo pide "dame un X", no sabe cómo se crea
// 4. Ventaja: si mañana agregas "WhatsApp", solo modificas la fábrica
