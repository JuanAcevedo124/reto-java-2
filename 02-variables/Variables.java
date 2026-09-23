// LECCIÓN 02: VARIABLES Y TIPOS DE DATOS
public class Variables {
    public static void main(String[] args) {

        // Una variable es una "caja" donde guardas un dato.
        // Sintaxis: tipo nombre = valor;

        // --- 1. TIPOS NUMÉRICOS ENTEROS ---
        int edad = 25;              // int: entero más usado (-2 mil millones a 2 mil millones)
        long poblacion = 8000000000L; // long: para números gigantes (pon L al final)
        byte nivel = 100;           // byte: -128 a 127 (poco usado)
        short ano = 2026;           // short: -32768 a 32767

        // --- 2. TIPOS DECIMALES ---
        double precio = 19.99;      // double: decimales con mucha precisión (EL MÁS USADO)
        float altura = 1.75f;       // float: decimales con menos precisión (pon f al final)

        // --- 3. TEXTO Y CARACTERES ---
        char letra = 'A';           // char: UN SOLO carácter, con comillas simples ''
        String nombre = "Juan";     // String: texto, con comillas dobles "" (Nota: String con mayúscula)

        // --- 4. BOOLEANO (lógico) ---
        boolean esEstudiante = true;  // solo true o false
        boolean tieneTrabajo = false;

        // --- 5. MOSTRAR VARIABLES ---
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Precio: " + precio);
        System.out.println("¿Es estudiante? " + esEstudiante);

        // Concatenación: unir texto + variable con +
        System.out.println("Hola " + nombre + ", tienes " + edad + " años");

        // --- 6. CAMBIAR VALOR DE UNA VARIABLE ---
        int puntos = 10;
        System.out.println("Puntos iniciales: " + puntos);
        puntos = 20; // ahora vale 20 (reasignación, sin 'int' de nuevo)
        puntos = puntos + 5; // ahora 25
        System.out.println("Puntos finales: " + puntos);

        // --- 7. CONSTANTES (valor que NO cambia) ---
        final double PI = 3.14159; // final = no se puede cambiar después
        // PI = 3.14; // Esto daría ERROR
        System.out.println("PI vale: " + PI);

        // --- 8. var (Java 10+) - Java deduce el tipo automáticamente ---
        var ciudad = "Madrid"; // Java sabe que es String
        var cantidad = 100;    // Java sabe que es int
        System.out.println(ciudad + " tiene " + cantidad + " cosas");

        // Reglas nombres variables:
        // - Empiezan con letra, _ o $
        // - No pueden ser palabras reservadas (int, class, public...)
        // - Usa camelCase: miVariable, edadUsuario, precioTotal
    }
}
