// CLASE PRINCIPAL - Aquí usamos la clase Persona
// Para compilar con dos archivos: javac Persona.java MainPOO.java
// Para ejecutar: java MainPOO
// En VS Code con Java 21: java MainPOO.java (detecta ambas)

public class MainPOO {
    public static void main(String[] args) {
        System.out.println("=== 1. CREAR OBJETOS ===");
        Persona p1 = new Persona("Juan", 17, "Bucaramanga");
        Persona p2 = new Persona("Ana", 22, "Bogotá");
        Persona p3 = new Persona(); // constructor vacío

        System.out.println(p1); // llama a toString() automáticamente
        System.out.println(p2);
        System.out.println(p3);

        System.out.println("\n=== 2. USAR MÉTODOS ===");
        p1.saludar();
        p2.saludar();
        p1.cumplirAnos(); // Juan ahora 18
        System.out.println("¿Juan es mayor? " + p1.esMayorDeEdad());
        System.out.println("¿Ana es mayor? " + p2.esMayorDeEdad());

        System.out.println("\n=== 3. GETTERS Y SETTERS ===");
        System.out.println("Nombre p1: " + p1.getNombre());
        p1.setEdad(20);
        System.out.println("Nueva edad p1: " + p1.getEdad());
        p1.setEdad(200); // no lo cambia, muestra error
        p3.setNombre("Carlos");
        p3.setEdad(30);
        p3.setCiudad("Medellín");
        System.out.println("p3 actualizado: " + p3);

        System.out.println("\n=== 4. ARRAY DE OBJETOS ===");
        Persona[] grupo = {p1, p2, p3};
        for (Persona p : grupo) {
            p.saludar();
        }

        // Buscar el mayor
        Persona mayor = grupo[0];
        for (Persona p : grupo) {
            if (p.getEdad() > mayor.getEdad()) mayor = p;
        }
        System.out.println("El mayor es: " + mayor.getNombre() + " con " + mayor.getEdad() + " años");

        System.out.println("\n=== 5. OBJETOS SON REFERENCIAS ===");
        Persona a = new Persona("Luis", 25, "Cali");
        Persona b = a; // b NO es copia, es la MISMA referencia
        b.setNombre("Luis Modificado");
        System.out.println("a: " + a.getNombre()); // también cambió!
        System.out.println("b: " + b.getNombre());
        System.out.println("a == b ? " + (a == b)); // true, mismo objeto en memoria

        // Para copiar de verdad necesitas new
        Persona c = new Persona(a.getNombre(), a.getEdad(), a.getCiudad());
        c.setNombre("Luis Copia");
        System.out.println("a: " + a.getNombre() + " | c: " + c.getNombre());
        System.out.println("a == c ? " + (a == c)); // false, objetos distintos
    }
}
