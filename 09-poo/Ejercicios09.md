# Ejercicios - Lección 09: POO

### Ejercicio 1: Crear tu primera clase
Crea clase `Coche` con atributos `private String marca`, `private String modelo`, `i`.
- Constructor con los 3 parámetros
- Método `void mostrarInfo()` que imprima "Marca Modelo (año)"
- Getters y setters
- En Main crea 2 coches y muestra su info

### Ejercicio 2: Clase CuentaBancaria
Crea `CuentaBancaria` con `titular` (String) y `saldo` (double) private.
- Constructor `CuentaBancaria(String titular, double saldoInicial)`
- Métodos `void depositar(double cantidad)`, `void retirar(double cantidad)` (si saldo suficiente, si no muestra "Fondos insuficientes"), `double getSaldo()`
- En Main prueba depositar y retirar

### Ejercicio 3: Clase Estudiante
Crea `Estudiante` con `nombre`, `edad`, `double[] notas` (array de 3 notas).
- Método `double promedio()` que calcule el promedio
- Método `boolean aprobo()` que devuelva true si promedio >= 3.0 (o >=5 según tu país, elige)
- En Main crea 2 estudiantes con distintas notas

### Ejercicio 4: Array de objetos
Con la clase `Persona` del ejemplo, crea `Persona[] personas = new Persona[3]` pide datos por Scanner (nombre, edad, ciudad) y llénalo. Luego muestra todos con for-each.

### Ejercicio 5 (Reto): Clase Libro
Crea `Libro` con `titulo`, `autor`, `paginas`, `leido` (boolean).
- Constructor
- Método `void marcarLeido()` que pone leido=true
- Método `void info()` que muestra todo
- En Main crea 3 libros y marca uno como leído

### Ejercicio 6 (Reto): Validación en setter
En `Persona`, el `setEdad` ya valida 0-120. Haz lo mismo para `Coche` -> `setAno` que solo acepte entre 1900 y 2026. Prueba poner 3000 y ve el mensaje.

---
Pista POO: Cada clase en su propio archivo .java. Para compilar: `javac *.java` y `java MainPOO`
