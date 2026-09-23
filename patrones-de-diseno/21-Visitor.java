// LECCIÓN 21: PATRÓN VISITOR
// Archivo: 21-Visitor.java

// ¿QUÉ ES?
// Visitor permite agregar nuevas operaciones a clases existentes
// sin modificarlas. Las operaciones se implementan en clases separadas.

// ¿CUÁNDO SE USA?
- Operaciones sobre estructuras de datos (recorridos)
- Cuando no puedes modificar las clases pero sí agregar comportamiento
- Operaciones que dependen del tipo de elemento

// ==================== EJEMPLO SENCILLO ====================

// Interfaz del visitor
interface Visitor {
    void visitar(Circulo circulo);
    void visitar(Rectangulo rectangulo);
    void visitar(Triangulo triangulo);
}

// Interfaz del elemento
interface FiguraVisitada {
    void accept(Visitor visitor);
}

// Elementos concretos
class Circulo implements FiguraVisitada {
    double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public void accept(Visitor visitor) {
        visitor.visitar(this);
    }
}

class Rectangulo implements FiguraVisitada {
    double ancho, alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public void accept(Visitor visitor) {
        visitor.visitar(this);
    }
}

class Triangulo implements FiguraVisitada {
    double base, altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public void accept(Visitor visitor) {
        visitor.visitar(this);
    }
}

// Visitor concreto: calcular área
class AreaVisitor implements Visitor {
    public void visitar(Circulo circulo) {
        double area = Math.PI * circulo.radio * circulo.radio;
        System.out.println("  Área círculo: " + String.format("%.2f", area));
    }

    public void visitar(Rectangulo rectangulo) {
        double area = rectangulo.ancho * rectangulo.alto;
        System.out.println("  Área rectángulo: " + area);
    }

    public void visitar(Triangulo triangulo) {
        double area = (triangulo.base * triangulo.altura) / 2;
        System.out.println("  Área triángulo: " + area);
    }
}

// Visitor concreto: dibujar
class DibujarVisitor implements Visitor {
    public void visitar(Circulo circulo) {
        System.out.println("  ⭕ Círculo (radio: " + circulo.radio + ")");
    }

    public void visitar(Rectangulo rectangulo) {
        System.out.println("  ⬛ Rectángulo (" + rectangulo.ancho + "x" + rectangulo.alto + ")");
    }

    public void visitar(Triangulo triangulo) {
        System.out.println("  🔺 Triángulo (base: " + triangulo.base + ")");
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

interface ElementoDocumento {
    void accept(VisitadorDocumento visitador);
}

class Parrafo implements ElementoDocumento {
    String texto;

    public Parrafo(String texto) {
        this.texto = texto;
    }

    public void accept(VisitadorDocumento visitador) {
        visitador.visitar(this);
    }
}

class ImagenDoc implements ElementoDocumento {
    String url;

    public ImagenDoc(String url) {
        this.url = url;
    }

    public void accept(VisitadorDocumento visitador) {
        visitador.visitar(this);
    }
}

class Tabla implements ElementoDocumento {
    int filas, columnas;

    public Tabla(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }

    public void accept(VisitadorDocumento visitador) {
        visitador.visitar(this);
    }
}

interface VisitadorDocumento {
    void visitar(Parrafo parrafo);
    void visitar(ImagenDoc imagen);
    void visitar(Tabla tabla);
}

class ContarVisitor implements VisitadorDocumento {
    int palabras = 0;
    int imagenes = 0;
    int tablas = 0;

    public void visitar(Parrafo parrafo) {
        palabras += parrafo.texto.split(" ").length;
    }

    public void visitar(ImagenDoc imagen) {
        imagenes++;
    }

    public void visitar(Tabla tabla) {
        tablas++;
    }

    public void mostrarEstadisticas() {
        System.out.println("  Palabras: " + palabras);
        System.out.println("  Imágenes: " + imagenes);
        System.out.println("  Tablas: " + tablas);
    }
}

// ==================== CLASE PRINCIPAL ====================

public class Visitor {
    public static void main(String[] args) {

        System.out.println("=== VISITOR ===\n");

        // Ejemplo 1: Figuras
        System.out.println("--- Figuras ---");

        FiguraVisitada[] figuras = {
            new Circulo(5),
            new Rectangulo(4, 6),
            new Triangulo(3, 8)
        };

        System.out.println("Áreas:");
        Visitor areaVisitor = new AreaVisitor();
        for (FiguraVisitada f : figuras) {
            f.accept(areaVisitor);
        }

        System.out.println("\nDibujando:");
        Visitor dibujarVisitor = new DibujarVisitor();
        for (FiguraVisitada f : figuras) {
            f.accept(dibujarVisitor);
        }

        // Ejemplo 2: Documento
        System.out.println("\n--- Documento ---");

        ElementoDocumento[] doc = {
            new Parrafo("Hola mundo"),
            new ImagenDoc("foto.jpg"),
            new Tabla(3, 4)
        };

        ContarVisitor contador = new ContarVisitor();
        for (ElementoDocumento e : doc) {
            e.accept(contador);
        }
        contador.mostrarEstadisticas();
    }
}

// RESUMEN:
// 1. Visitor → interfaz con métodos para cada tipo de elemento
// 2. Elementos → tienen método accept() que llama al visitor
// 3. Visitor concreto → implementa la operación
// 4. Ventaja: agregas operaciones sin modificar las clases existentes
