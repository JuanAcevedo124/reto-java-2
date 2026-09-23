# Ejercicios - Lección 05: Condicionales

### Ejercicio 1: Mayor de edad
Pide edad con Scanner. Si >= 18 muestra "Mayor", si no "Menor".

### Ejercicio 2: Positivo, negativo o cero
Pide un número int. Muestra si es positivo, negativo o cero (usa if - else if - else).

### Ejercicio 3: Par o impar con if
Pide un número y muestra "Par" o "Impar" usando % 2.

### Ejercicio 4: Nota con letras
Pide nota de 0 a 10 (int):
- 9-10 Sobresaliente
- 7-8 Notable
- 5-6 Aprobado
- 0-4 Reprobado
- otro -> "Nota inválida"
Hazlo primero con if-else if y luego prueba con switch.

### Ejercicio 5: Calculadora con switch
Pide dos números double y un operador char (+ - * /).
Usa switch para hacer la operación. Si operador no es esos 4, muestra "Operador inválido".
Ojo: para leer char usa `sc.next().charAt(0)`

### Ejercicio 6: Día de la semana
Pide número 1-7 y muestra el día (1=Lunes...7=Domingo) con switch. Usa default para "Número inválido".

### Ejercicio 7: Usuario y contraseña
Declara `String usuarioCorrecto = "admin"; String claveCorrecta = "1234";`
Pide usuario y clave al usuario y verifica con `.equals()`. Si ambos correctos muestra "Acceso concedido", si no "Acceso denegado".

### Ejercicio 8 (Reto): Ternario
Pide un número y en UNA sola línea con ternario guarda en String "Par" o "Impar" y muéstralo.
Pista: `String resultado = (num % 2 == 0) ? "Par" : "Impar";`

---
Soluciones en `Solucion05.java`
