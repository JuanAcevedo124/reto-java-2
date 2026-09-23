# Ejercicios - Lección 03: Operadores

Haz cada uno en un archivo nuevo o comenta/descomenta en `Operadores.java`.

### Ejercicio 1: Calculadora básica
Declara `int x = 15, y = 4`. Muestra: suma, resta, multiplicación, división entera, división decimal y resto. Explica por qué `x / y` no da 3.75.

### Ejercicio 2: ¿Par o impar?
Pide un número (puedes poner `int n = 7;` por ahora) y muestra `true` si es par y `false` si es impar usando `% 2`.

### Ejercicio 3: Contador
Declara `int contador = 10;`
Aplica: `contador += 5`, luego `contador++`, luego `contador *= 2`. Imprime el valor después de cada paso. ¿Cuánto vale al final?

### Ejercicio 4: Comparaciones
Con `int edad = 17;` muestra:
- ¿Es mayor de edad? (edad >= 18)
- ¿Es menor que 30? (edad < 30)
- ¿Edad distinta de 18? (edad != 18)

### Ejercicio 5: Lógica AND/OR
Declara `boolean llueve = false; boolean tengoParaguas = true;`
- ¿Debo salir? (NO llueve O tengo paraguas) -> `!llueve || tengoParaguas`
- ¿Me mojo? (llueve Y NO tengo paraguas) -> `llueve && !tengoParaguas`

### Ejercicio 6 (Reto): Área de círculo
Declara `double radio = 5;` y calcula el área con `Math.PI * Math.pow(radio, 2)`. Muéstralo.

### Ejercicio 7 (Reto): Intercambio sin variable extra (solo si quieres complicarte)
Con `a=10, b=20` intercámbialos usando solo `+` y `-` sin `aux`. Pista: `a = a + b; ...`

---
Soluciones en `Solucion03.java` -> Intenta primero sin mirar.
