package estudio;

public class Variables {
    public static void main(String[] args) {
        int edad = 25;
        double precio = 19.99;
        String nombre = "Juan";
        char letra = 'A';
        boolean esEstudiante = true;

        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Precio: " + precio);
        System.out.println("¿Es estudiante? " + esEstudiante);
        System.out.println("Hola " + nombre + ", tienes " + edad + " años");

        int puntos = 10;
        System.out.println("Puntos iniciales: " + puntos);
        puntos = 25;
        System.out.println("Puntos finales: " + puntos);

        final double PI = 3.14159;
        System.out.println("PI vale: " + PI);

        var ciudad = "Madrid";
        var cantidad = 100;
        System.out.println(ciudad + " tiene " + cantidad + " cosas");
    }
}
