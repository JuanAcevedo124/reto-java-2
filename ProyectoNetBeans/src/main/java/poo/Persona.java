// LECCIÓN 09: PROGRAMACIÓN ORIENTADA A OBJETOS (POO)
// Una CLASE es un molde, un OBJETO es lo que creas con ese molde
// Ej: Clase Persona -> Objeto juan, Objeto ana

package poo;
public class Persona {
    // 1. ATRIBUTOS (características)
    // private = solo esta clase puede tocarlos (encapsulamiento)
    private String nombre;
    private int edad;
    private String ciudad;

    // 2. CONSTRUCTOR - se ejecuta al crear el objeto con new
    public Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre; // this.nombre = atributo, nombre = parámetro
        this.edad = edad;
        this.ciudad = ciudad;
    }

    // Constructor vacío (por si quieres crear sin datos)
    public Persona() {
        this.nombre = "Sin nombre";
        this.edad = 0;
        this.ciudad = "Desconocida";
    }

    // 3. MÉTODOS (comportamientos)
    public void saludar() {
        System.out.println("Hola, soy " + nombre + " de " + ciudad);
    }

    public void cumplirAnos() {
        edad++;
        System.out.println(nombre + " cumplió años, ahora tiene " + edad);
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    // 4. GETTERS Y SETTERS - para acceder a atributos private de forma controlada
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 0 && edad <= 120) { // validación
            this.edad = edad;
        } else {
            System.out.println("Edad inválida");
        }
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    // 5. Método toString - para imprimir el objeto bonito
    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', edad=" + edad + ", ciudad='" + ciudad + "'}";
    }
}
