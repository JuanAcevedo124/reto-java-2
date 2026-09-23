public class Solucion03 {
    public static void main(String[] args) {
        // Ejercicio 1
        int x = 15, y = 4;
        System.out.println("Suma: " + (x + y));
        System.out.println("Resta: " + (x - y));
        System.out.println("Multi: " + (x * y));
        System.out.println("Div entera: " + (x / y)); // 3
        System.out.println("Div decimal: " + ((double) x / y)); // 3.75
        System.out.println("Resto: " + (x % y));

        // Ejercicio 2
        int n = 7;
        System.out.println("¿" + n + " es par? " + (n % 2 == 0));

        // Ejercicio 3
        int contador = 10;
        contador += 5; System.out.println(contador); // 15
        contador++; System.out.println(contador); // 16
        contador *= 2; System.out.println(contador); // 32

        // Ejercicio 4
        int edad = 17;
        System.out.println("Mayor de edad: " + (edad >= 18));
        System.out.println("Menor que 30: " + (edad < 30));
        System.out.println("Distinta de 18: " + (edad != 18));

        // Ejercicio 5
        boolean llueve = false;
        boolean tengoParaguas = true;
        System.out.println("Debo salir: " + (!llueve || tengoParaguas));
        System.out.println("Me mojo: " + (llueve && !tengoParaguas));

        // Ejercicio 6
        double radio = 5;
        double area = Math.PI * Math.pow(radio, 2);
        System.out.println("Área círculo r=5: " + area);

        // Ejercicio 7
        int a = 10, b = 20;
        a = a + b; // a=30
        b = a - b; // b=10
        a = a - b; // a=20
        System.out.println("a=" + a + " b=" + b);
    }
}
