// LECCIÓN 01: TU PRIMER PROGRAMA EN JAVA
// Archivo: HolaMundo.java

// 1. En Java, TODO va dentro de una CLASE.
//    El nombre del archivo DEBE ser igual al nombre de la clase.
//    HolaMundo.java -> public class HolaMundo
public class HolaMundo {

    // 2. El punto de entrada es el método 'main'.
    //    Sin esto, Java no sabe por dónde empezar.
    //    Es como el "play" del programa.
    public static void main(String[] args) {

        // 3. Esto imprime texto en pantalla.
        //    System.out.println = "Sistema, saca por pantalla y salta de línea"
        System.out.println("¡Hola, Mundo!");

        // println -> imprime y salta de línea
        // print   -> imprime sin saltar de línea
        System.out.println("Estoy aprendiendo Java desde cero");
        System.out.print("Esto es con print... ");
        System.out.print("y sigue en la misma línea");
        System.out.println(""); // línea vacía para separar

        // 4. Comentarios:
        // Esto es un comentario de una línea
        /* Esto es un
        comentario de
           varias líneas */

        // 5. Sentencias terminan en ;
        System.out.println("Cada instrucción termina en punto y coma ;");
    }
}
