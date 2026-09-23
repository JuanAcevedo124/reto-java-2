// LECCIÓN 03: OPERADORES EN JAVA
// En VS Code ejecuta con: java Operadores.java  (Java 21 ya no necesita javac)

public class Operadores {
    public static void main(String[] args) {

        System.out.println("=== 1. OPERADORES ARITMÉTICOS ===");
        int a = 10;
        int b = 3;
        System.out.println("a = 10, b = 3");
        System.out.println("Suma (a + b): " + (a + b));           // 13
        System.out.println("Resta (a - b): " + (a - b));          // 7
        System.out.println("Multiplicación (a * b): " + (a * b)); // 30
        System.out.println("División entera (a / b): " + (a / b)); // 3 -> ¡OJO! corta decimales
        System.out.println("División decimal (a / 3.0): " + (a / 3.0)); // 3.33
        System.out.println("División decimal con cast: " + ((double) a / b)); // 3.33
        System.out.println("Módulo / Resto (a % b): " + (a % b));  // 1 -> lo que sobra de 10/3

        // Truco del módulo: saber si es par
        int numero = 8;
        System.out.println("¿8 es par? " + (numero % 2 == 0)); // true

        System.out.println("\n=== 2. OPERADORES DE ASIGNACIÓN ===");
        int puntos = 10;
        System.out.println("puntos inicia en: " + puntos);
        puntos += 5; // es lo mismo que puntos = puntos + 5
        System.out.println("puntos += 5 -> " + puntos); // 15
        puntos -= 3; // puntos = puntos - 3
        System.out.println("puntos -= 3 -> " + puntos); // 12
        puntos *= 2; // puntos = puntos * 2
        System.out.println("puntos *= 2 -> " + puntos); // 24
        puntos /= 4; // puntos = puntos / 4
        System.out.println("puntos /= 4 -> " + puntos); // 6
        puntos %= 4; // puntos = puntos % 4
        System.out.println("puntos %= 4 -> " + puntos); // 2

        System.out.println("\n=== 3. INCREMENTO Y DECREMENTO ===");
        int x = 5;
        System.out.println("x = " + x);
        x++; // suma 1
        System.out.println("x++ -> " + x); // 6
        x--; // resta 1
        System.out.println("x-- -> " + x); // 5
        // Diferencia entre ++x y x++ (pre y post)
        int y = 5;
        System.out.println("y++ devuelve y luego suma: " + (y++)); // muestra 5, y pasa a 6
        System.out.println("ahora y vale: " + y); // 6
        System.out.println("++y suma y luego devuelve: " + (++y)); // y pasa a 7 y muestra 7

        System.out.println("\n=== 4. OPERADORES DE COMPARACIÓN (devuelven boolean) ===");
        int n1 = 10, n2 = 20;
        System.out.println("n1=10, n2=20");
        System.out.println("n1 == n2 (igual): " + (n1 == n2)); // false
        System.out.println("n1 != n2 (distinto): " + (n1 != n2)); // true
        System.out.println("n1 > n2 (mayor): " + (n1 > n2)); // false
        System.out.println("n1 < n2 (menor): " + (n1 < n2)); // true
        System.out.println("n1 >= 10: " + (n1 >= 10)); // true
        System.out.println("n1 <= 9: " + (n1 <= 9)); // false
        // ¡OJO con String! No uses == para texto, usa .equals()
        String s1 = "Java";
        String s2 = "Java";
        System.out.println("Texto con equals: " + s1.equals(s2)); // true

        System.out.println("\n=== 5. OPERADORES LÓGICOS ===");
        boolean esMayor = true;
        boolean tienePermiso = false;
        System.out.println("esMayor=true, tienePermiso=false");
        System.out.println("AND (&&) ambos true: " + (esMayor && tienePermiso)); // false
        System.out.println("OR (||) alguno true: " + (esMayor || tienePermiso)); // true
        System.out.println("NOT (!) niega: !" + esMayor + " es " + (!esMayor)); // false
        // Ejemplo real: puede entrar si es mayor Y tiene permiso
        boolean puedeEntrar = esMayor && tienePermiso;
        System.out.println("¿Puede entrar? " + puedeEntrar); // false
        // Puede entrar si es mayor O tiene permiso
        puedeEntrar = esMayor || tienePermiso;
        System.out.println("¿Puede entrar con OR? " + puedeEntrar); // true

        System.out.println("\n=== 6. PRECEDENCIA Y PARÉNTESIS ===");
        int r1 = 2 + 3 * 4; // * va primero -> 14
        int r2 = (2 + 3) * 4; // paréntesis primero -> 20
        System.out.println("2 + 3 * 4 = " + r1);
        System.out.println("(2 + 3) * 4 = " + r2);

        System.out.println("\n=== 7. CLASE MATH (extra útil) ===");
        System.out.println("Math.pow(2,3) -> 2^3 = " + Math.pow(2, 3)); // 8.0
        System.out.println("Math.sqrt(16) -> raiz = " + Math.sqrt(16)); // 4.0
        System.out.println("Math.random() -> 0 a 1 : " + Math.random());
        System.out.println("Math.round(4.6) -> " + Math.round(4.6)); // 5
    }
}
