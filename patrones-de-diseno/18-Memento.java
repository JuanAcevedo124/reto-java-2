// LECCIÓN 18: PATRÓN MEMENTO
// Archivo: 18-Memento.java

// ¿QUÉ ES?
// Memento guarda el estado de un objeto para poder restaurarlo después.
// Como una máquina del tiempo: puedes volver a un punto anterior.

// ¿CUÁNDO SE USA?
- Deshacer/rehacer en editores
- Guardar partida en videojuegos
- Historial de cambios

// ==================== EJEMPLO SENCILLO ====================

// Memento: guarda el estado
class MementoEstado {
    String estado;

    public MementoEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}

// Originador: el objeto que cambia de estado
class Texto {
    String contenido;

    public void escribir(String contenido) {
        this.contenido = contenido;
        System.out.println("Escribiendo: " + contenido);
    }

    public MementoEstado guardar() {
        return new MementoEstado(contenido);
    }

    public void restaurar(MementoEstado memento) {
        this.contenido = memento.getEstado();
        System.out.println("Restaurado: " + contenido);
    }
}

// Cuidador: guarda y restaura mementos
class Historial {
    MementoEstado[] mementos = new MementoEstado[10];
    int posicion = 0;

    public void guardar(MementoEstado memento) {
        mementos[posicion] = memento;
        posicion++;
    }

    public MementoEstado deshacer() {
        if (posicion > 0) {
            posicion--;
            return mementos[posicion];
        }
        return null;
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

class Editor {
    String texto;
    int cursorX;
    int cursorY;

    public Editor(String texto, int x, int y) {
        this.texto = texto;
        this.cursorX = x;
        this.cursorY = y;
    }

    public MementoEstado guardar() {
        return new MementoEstado(texto + "|" + cursorX + "|" + cursorY);
    }

    public void restaurar(MementoEstado memento) {
        String[] partes = memento.getEstado().split("\\|");
        this.texto = partes[0];
        this.cursorX = Integer.parseInt(partes[1]);
        this.cursorY = Integer.parseInt(partes[2]);
    }

    public void mostrar() {
        System.out.println("  Texto: \"" + texto + "\" Cursor: (" + cursorX + "," + cursorY + ")");
    }
}

// ==================== CLASE PRINCIPAL ====================

public class Memento {
    public static void main(String[] args) {

        System.out.println("=== MEMENTO ===\n");

        // Ejemplo 1: Texto simple
        System.out.println("--- Editor Simple ---");

        Texto texto = new Texto();
        Historial historial = new Historial();

        texto.escribir("Hola");
        historial.guardar(texto.guardar());

        texto.escribir("Hola Mundo");
        historial.guardar(texto.guardar());

        texto.escribir("Hola Mundo Java");

        System.out.println("\nDeshacer:");
        texto.restaurar(historial.deshacer());
        texto.restaurar(historial.deshacer());

        // Ejemplo 2: Editor con posición
        System.out.println("\n--- Editor con Cursor ---");

        Editor editor = new Editor("", 0, 0);
        Historial hist2 = new Historial();

        editor.texto = "Primera línea";
        editor.cursorX = 15;
        editor.cursorY = 0;
        hist2.guardar(editor.guardar());
        editor.mostrar();

        editor.texto = "Segunda línea";
        editor.cursorX = 15;
        editor.cursorY = 1;
        hist2.guardar(editor.guardar());
        editor.mostrar();

        System.out.println("\nRestaurar primera línea:");
        editor.restaurar(hist2.deshacer());
        editor.mostrar();
    }
}

// RESUMEN:
// 1. Memento → guarda el estado del objeto
// 2. Originador → el objeto que cambia
// 3. Cuidador → guarda y restaura mementos
// 4. Ventaja: puedes volver a estados anteriores sin exponer detalles
