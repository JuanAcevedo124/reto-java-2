public class Solucion02 {
    public static void main(String[] args) {
        // Ejercicio 1
        String nombre = "Ana";
        int edad = 22;
        double altura = 1.68;
        char inicial = 'A';
        boolean esMayorDeEdad = true;
        System.out.println("Me llamo " + nombre + ", tengo " + edad + " años, mido " + altura + " metros, mi inicial es " + inicial + ". ¿Mayor de edad? " + esMayorDeEdad);

        // Ejercicio 2
        int a = 10;
        int b = 20;
        System.out.println("Antes: a=" + a + " b=" + b);
        int aux = a;
        a = b;
        b = aux;
        System.out.println("Después: a=" + a + " b=" + b);

        // Ejercicio 3
        int num1 = 8;
        int num2 = 3;
        System.out.println("Suma: " + (num1 + num2));
        System.out.println("Resta: " + (num1 - num2));
        System.out.println("Multi: " + (num1 * num2));
        System.out.println("Division entera: " + (num1 / num2));
        System.out.println("Division decimal: " + ((double) num1 / num2));
        System.out.println("Resto: " + (num1 % num2));

        // Ejercicio 4
        final int DIAS_SEMANA = 7;
        System.out.println("4 semanas = " + (DIAS_SEMANA * 4) + " días");

        // Ejercicio 5
        var texto = "Hola";
        var decimal = 3.14;
        var logico = false;
        System.out.println(texto + " - " + decimal + " - " + logico);
    }
}
