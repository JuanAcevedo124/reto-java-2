public class Solucion08 {
    public static void main(String[] args) {
        saludar("Juan");
        saludar("Ana");
        int r = sumar(5, 7);
        System.out.println("Suma: " + r);
        System.out.println("¿4 es par? " + esPar(4));
        System.out.println("Mayor 10 y 20: " + mayor(10, 20));
        System.out.println("Factorial 5: " + factorial(5));
        System.out.println("Área 4x6: " + areaRectangulo(4, 6));
        System.out.println("Multi int: " + multiplicar(3, 4) + " double: " + multiplicar(2.5, 3.0));
        int[] arr = {3, 9, 2, 15, 6};
        System.out.println("Max: " + maxArray(arr) + " Promedio: " + promedioArray(arr));
    }

    public static void saludar(String nombre) { System.out.println("Hola, " + nombre); }
    public static int sumar(int a, int b) { return a + b; }
    public static boolean esPar(int n) { return n % 2 == 0; }
    public static int mayor(int a, int b) { return (a > b) ? a : b; }
    public static long factorial(int n) { long f=1; for(int i=1;i<=n;i++) f*=i; return f; }
    public static double areaRectangulo(double b, double h) { return b * h; }
    public static int multiplicar(int a, int b) { return a * b; }
    public static double multiplicar(double a, double b) { return a * b; }
    public static int maxArray(int[] arr) { int m=arr[0]; for(int n:arr) if(n>m) m=n; return m; }
    public static double promedioArray(int[] arr) { int s=0; for(int n:arr) s+=n; return (double)s/arr.length; }
}
