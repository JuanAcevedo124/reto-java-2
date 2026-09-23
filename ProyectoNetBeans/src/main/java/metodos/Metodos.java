// LECCIÓN 08: MÉTODOS - Trocear tu programa en piezas reutilizables
// Un método es una mini-función que hace una tarea. Ej: Math.sqrt()

package metodos;
public class Metodos {

    // Método main - desde aquí llamamos a los demás
    public static void main(String[] args) {
        System.out.println("=== 1. MÉTODO SIN PARÁMETROS NI RETORNO (void) ===");
        saludar();

        System.out.println("\n=== 2. MÉTODO CON PARÁMETROS ===");
        saludarPersona("Juan");
        saludarPersona("Ana");
        sumar(10, 5); // no devuelve, solo imprime

        System.out.println("\n=== 3. MÉTODO CON RETORNO ===");
        int resultado = sumarConRetorno(10, 5);
        System.out.println("Resultado guardado: " + resultado);
        System.out.println("Doble de 8: " + doble(8));
        // Puedo usarlo directo en un println o en otro cálculo
        System.out.println("Doble de (doble de 2): " + doble(doble(2))); // 8

        System.out.println("\n=== 4. MÉTODO CON MÚLTIPLES TIPOS ===");
        double area = areaCirculo(5);
        System.out.println("Área círculo r=5: " + area);
        boolean esMayor = esMayorDeEdad(20);
        System.out.println("¿20 es mayor? " + esMayor);

        System.out.println("\n=== 5. SOBRECARGA (mismo nombre, distintos parámetros) ===");
        System.out.println(suma(2, 3));       // llama a suma(int,int)
        System.out.println(suma(2.5, 3.7));   // llama a suma(double,double)
        System.out.println(suma("Hola ", "Mundo")); // llama a suma(String,String)

        System.out.println("\n=== 6. MÉTODO QUE USA OTRO MÉTODO ===");
        System.out.println("Promedio de 10, 20, 30: " + promedio(10, 20, 30));

        System.out.println("\n=== 7. VARIABLE LOCAL (scope) ===");
        int x = 10;
        System.out.println("x en main: " + x);
        ejemploScope();
        System.out.println("x en main sigue siendo: " + x); // no cambió

        System.out.println("\n=== 8. MÉTODO CON ARRAY ===");
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("Suma array: " + sumarArray(nums));
        imprimirArray(nums);
    }

    // --- DEFINICIÓN DE MÉTODOS (fuera del main, dentro de la clase) ---

    // 1. Sin parámetros, sin retorno
    public static void saludar() {
        System.out.println("¡Hola! Soy un método void");
    }

    // 2. Con parámetro
    public static void saludarPersona(String nombre) {
        System.out.println("¡Hola, " + nombre + "!");
    }

    public static void sumar(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
    }

    // 3. Con retorno (devuelve un valor)
    // sintaxis: public static Tipo nombre(Tipo param) { return valor; }
    public static int sumarConRetorno(int a, int b) {
        return a + b; // devuelve el resultado para que main lo use
    }

    public static int doble(int n) {
        return n * 2;
    }

    public static double areaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

    public static boolean esMayorDeEdad(int edad) {
        return edad >= 18; // devuelve true/false directo
        // Equivale a: if (edad >= 18) return true; else return false;
    }

    // 5. SOBRECARGA
    public static int suma(int a, int b) {
        return a + b;
    }
    public static double suma(double a, double b) {
        return a + b;
    }
    public static String suma(String a, String b) {
        return a + b;
    }

    // 6. Método que llama a otro
    public static double promedio(int a, int b, int c) {
        int s = suma(a, b); // reutiliza suma(int,int)
        s = suma(s, c);
        return (double) s / 3;
    }

    // 7. Scope: variables dentro del método solo viven ahí
    public static void ejemploScope() {
        int x = 99; // esta x es OTRA distinta a la del main
        System.out.println("x en ejemploScope: " + x);
    }

    // 8. Con arrays
    public static int sumarArray(int[] arr) {
        int suma = 0;
        for (int n : arr) suma += n;
        return suma;
    }

    public static void imprimirArray(int[] arr) {
        System.out.print("Array: ");
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
    }
}
