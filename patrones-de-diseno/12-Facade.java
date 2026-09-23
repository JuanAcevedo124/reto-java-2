// LECCIÓN 12: PATRÓN FACADE
// Archivo: 12-Facade.java

// ¿QUÉ ES?
// Facade simplifica un sistema complejo proporcionando una interfaz simple.
// En vez de llamar a muchas clases, llamas a una sola que hace todo.

// ¿CUÁNDO SE USA?
- Sistemas complejos con muchas partes
- Para simplificar el uso de una librería
- Para desacoplar el cliente de los detalles internos

// ==================== EJEMPLO SENCILLO ====================

// Clases complejas (internas)
class Motor {
    void encender() { System.out.println("🔧 Motor encendido"); }
    void apagar() { System.out.println("🔧 Motor apagado"); }
}

class Luces {
    void encender() { System.out.println("💡 Luces encendidas"); }
    void apagar() { System.out.println("💡 Luces apagadas"); }
}

class AireAcondicionado {
    void encender() { System.out.println("❄️ Aire encendido"); }
    void apagar() { System.out.println("❄️ Aire apagado"); }
}

// Facade: simplifica todo
class Auto {
    private Motor motor = new Motor();
    private Luces luces = new Luces();
    private AireAcondicionado aire = new AireAcondicionado();

    public void iniciar() {
        System.out.println("🚗 Iniciando auto...");
        motor.encender();
        luces.encender();
    }

    public void apagar() {
        System.out.println("🚗 Apagando auto...");
        motor.apagar();
        luces.apagar();
        aire.apagar();
    }

    public void climaEncender() {
        System.out.println("🚗 Encendiendo clima...");
        aire.encender();
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

class CPU {
    void carga() { System.out.println("  CPU: Cargando datos..."); }
    void ejecuta() { System.out.println("  CPU: Ejecutando..."); }
}

class Memoria {
    void leer() { System.out.println("  Memoria: Leyendo..."); }
    void liberar() { System.out.println("  Memoria: Liberando..."); }
}

class Disco {
    void montar() { System.out.println("  Disco: Montando..."); }
    void desmontar() { System.out.println("  Disco: Desmontando..."); }
}

class TarjetaRed {
    void conectar() { System.out.println("  Red: Conectando a internet..."); }
    void desconectar() { System.out.println("  Red: Desconectando..."); }
}

// Facade de Computadora
class Computadora {
    private CPU cpu = new CPU();
    private Memoria memoria = new Memoria();
    private Disco disco = new Disco();
    private TarjetaRed red = new TarjetaRed();

    public void encender() {
        System.out.println("💻 Encendiendo computadora...");
        disco.montar();
        memoria.leer();
        cpu.carga();
        cpu.ejecuta();
        red.conectar();
        System.out.println("💻 Computadora lista\n");
    }

    public void apagar() {
        System.out.println("💻 Apagando computadora...");
        red.desconectar();
        memoria.liberar();
        disco.desmontar();
        System.out.println("💻 Computadora apagada\n");
    }
}

// ==================== CLASE PRINCIPAL ====================

public class Facade {
    public static void main(String[] args) {

        System.out.println("=== FACADE ===\n");

        // Sin Facade: tendrías que llamar a muchas clases
        // Con Facade: solo un método hace todo

        Auto auto = new Auto();
        auto.iniciar();
        auto.climaEncender();
        auto.apagar();

        System.out.println();

        Computadora pc = new Computadora();
        pc.encender();
        pc.apagar();
    }
}

// RESUMEN:
// 1. Clases complejas → lógica interna del sistema
// 2. Facade → interfaz simple que coordina todo
// 3. Cliente → solo llama al facade, no sabe los detalles
// 4. Ventaja: simplicidad y desacoplamiento
