// LECCIÓN 15: PATRÓN COMMAND
// Archivo: 15-Command.java

// ¿QUÉ ES?
// Command encapsula una operación como un objeto.
// Permite desacoplar el emisor de la receptor de la acción.

// ¿CUÁNDO SE USA?
- Deshacer/rehacer (undo/redo)
- Colas de tareas
- Menús y botones
- Operaciones programadas

// ==================== EJEMPLO SENCILLO ====================

// Interfaz Command
interface Comando {
    void ejecutar();
    void deshacer();
}

// Receptor
class LucesCasa {
    boolean encendidas = false;

    void encender() {
        encendidas = true;
        System.out.println("  💡 Luces encendidas");
    }

    void apagar() {
        encendidas = false;
        System.out.println("  💡 Luces apagadas");
    }
}

// Comandos concretos
class ComandoEncender implements Comando {
    LucesCasa luces;

    public ComandoEncender(LucesCasa luces) {
        this.luces = luces;
    }

    public void ejecutar() {
        luces.encender();
    }

    public void deshacer() {
        luces.apagar();
    }
}

class ComandoApagar implements Comando {
    LucesCasa luces;

    public ComandoApagar(LucesCasa luces) {
        this.luces = luces;
    }

    public void ejecutar() {
        luces.apagar();
    }

    public void deshacer() {
        luces.encender();
    }
}

// Invocador
class ControlRemoto {
    Comando[] botones = new Comando[5];
    Comando historial;
    int posicion = 0;

    public void setBoton(int i, Comando comando) {
        botones[i] = comando;
    }

    public void presionarBoton(int i) {
        historial = botones[i];
        botones[i].ejecutar();
    }

    public void deshacer() {
        if (historial != null) {
            System.out.println("  ↩️ Deshacer:");
            historial.deshacer();
        }
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

interface ComandoEditor {
    void ejecutar();
    void deshacer();
}

class TextoEditor {
    String texto = "";

    void agregar(String t) {
        texto += t;
    }

    void eliminar(int cantidad) {
        if (cantidad <= texto.length()) {
            texto = texto.substring(0, texto.length() - cantidad);
        }
    }
}

class ComandoEscribir implements ComandoEditor {
    TextoEditor editor;
    String texto;

    public ComandoEscribir(TextoEditor editor, String texto) {
        this.editor = editor;
        this.texto = texto;
    }

    public void ejecutar() {
        editor.agregar(texto);
    }

    public void deshacer() {
        editor.eliminar(texto.length());
    }
}

// ==================== CLASE PRINCIPAL ====================

public class Command {
    public static void main(String[] args) {

        System.out.println("=== COMMAND ===\n");

        // Ejemplo 1: Control remoto
        System.out.println("--- Control Remoto ---");

        LucesCasa luces = new LucesCasa();
        ControlRemoto control = new ControlRemoto();

        control.setBoton(0, new ComandoEncender(luces));
        control.setBoton(1, new ComandoApagar(luces));

        control.presionarBoton(0);
        control.presionarBoton(1);
        control.deshacer();

        // Ejemplo 2: Editor
        System.out.println("\n--- Editor de Texto ---");

        TextoEditor editor = new TextoEditor();
        ComandoEditor cmd1 = new ComandoEscribir(editor, "Hola ");
        ComandoEditor cmd2 = new ComandoEscribir(editor, "Mundo");

        cmd1.ejecutar();
        cmd2.ejecutar();
        System.out.println("Texto: " + editor.texto);

        cmd2.deshacer();
        System.out.println("Después de deshacer: " + editor.texto);
    }
}

// RESUMEN:
// 1. Command → interfaz con ejecutar() y deshacer()
// 2. Receptor → ejecuta la acción real (LucesCasa, TextoEditor)
// 3. Invocador → llama al comando sin saber qué hace
// 4. Ventaja: puedes deshacer, reprogramar, encadenar acciones
