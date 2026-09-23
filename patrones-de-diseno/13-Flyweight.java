// LECCIÓN 13: PATRÓN FLYWEIGHT
// Archivo: 13-Flyweight.java

// ¿QUÉ ES?
// Flyweight minimiza el uso de memoria compartiendo datos entre objetos.
// Separa el estado intrínseco (compartido) del extrínseco (único).

// ¿CUÁNDO SE USA?
- Cuando tienes muchos objetos similares (juegos, procesadores de texto)
- Para ahorrar memoria en aplicaciones grandes
- Cuando el estado intrínseco es pequeño y el extrínseco es grande

// ==================== EJEMPLO SENCILLO ====================

// Flyweight: datos compartidos
class Letra {
    char caracter;
    String fuente;
    int tamano;

    public Letra(char caracter, String fuente, int tamano) {
        this.caracter = caracter;
        this.fuente = fuente;
        this.tamano = tamano;
        System.out.println("Creando Letra '" + caracter + "' (compartida)");
    }

    public void mostrar(int x, int y) {
        System.out.println("  Letra '" + caracter + "' en posición (" + x + "," + y + ")");
    }
}

// Fábrica de Flyweights
class FabricaLetras {
    static Letra[] letras = new Letra[26];
    static int total = 0;

    public static Letra getLetra(char caracter) {
        // Buscar si ya existe
        for (int i = 0; i < total; i++) {
            if (letras[i].caracter == caracter) {
                System.out.println("Reutilizando '" + caracter + "'");
                return letras[i];
            }
        }
        // Crear nueva
        Letra nueva = new Letra(caracter, "Arial", 12);
        letras[total] = nueva;
        total++;
        return nueva;
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

class Arbol {
    String tipo;
    String color;
    int altura;

    public Arbol(String tipo, String color, int altura) {
        this.tipo = tipo;
        this.color = color;
        this.altura = altura;
    }

    public void dibujar(int x, int y) {
        System.out.println("  " + tipo + " " + color + " en (" + x + "," + y + ")");
    }
}

class FabricaArboles {
    static Arbol[] arboles = new Arbol[5];
    static int total = 0;

    public static Arbol getArbol(String tipo) {
        for (int i = 0; i < total; i++) {
            if (arboles[i].tipo.equals(tipo)) {
                return arboles[i];
            }
        }
        Arbol nuevo = new Arbol(tipo, "Verde", 10);
        arboles[total] = nuevo;
        total++;
        return nuevo;
    }
}

// ==================== CLASE PRINCIPAL ====================

public class Flyweight {
    public static void main(String[] args) {

        System.out.println("=== FLYWEIGHT ===\n");

        // Ejemplo 1: Letras
        System.out.println("--- Documento ---");

        Letra a1 = FabricaLetras.getLetra('A');
        Letra a2 = FabricaLetras.getLetra('A');
        Letra b = FabricaLetras.getLetra('B');

        a1.mostrar(0, 0);
        a2.mostrar(5, 0);
        b.mostrar(10, 0);

        System.out.println("a1 == a2? " + (a1 == a2));

        // Ejemplo 2: Árboles
        System.out.println("\n--- Bosque ---");

        Arbol roble1 = FabricaArboles.getArbol("Roble");
        Arbol roble2 = FabricaArboles.getArbol("Roble");
        Arbol pino = FabricaArboles.getArbol("Pino");

        roble1.dibujar(1, 1);
        roble2.dibujar(5, 1);
        pino.dibujar(10, 1);

        System.out.println("roble1 == roble2? " + (roble1 == roble2));
    }
}

// RESUMEN:
// 1. Flyweight → objetos que comparten datos (Letra, Arbol)
// 2. Fábrica → crea o reutiliza flyweights
// 3. Estado intrínseco → compartido (tipo, fuente)
// 4. Estado extrínseco → único (posición x,y)
// 5. Ventaja: ahorra memoria cuando hay muchos objetos similares
