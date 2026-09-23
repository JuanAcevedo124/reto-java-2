# Ejercicios - Lección 04: Scanner

> En VS Code: abre la Terminal (Ctrl + ñ) y ejecuta `java NombreArchivo.java` para poder escribir datos. El botón ▶️ a veces no deja escribir.

### Ejercicio 1: Saludo personalizado
Pide al usuario: nombre (nextLine) y edad (nextInt). Muestra: "Hola [nombre], en 5 años tendrás [edad+5] años".

### Ejercicio 2: Calculadora completa
Pide 2 números double y muestra: suma, resta, multiplicación y división. Formato bonito.

### Ejercicio 3: Datos completos (con el truco)
Pide: nombre (nextLine), edad (nextInt), altura (nextDouble) y **después** ciudad (nextLine).
Recuerda poner `sc.nextLine()` después de leer número para limpiar el buffer antes de leer ciudad. Si no, se salta la ciudad.

### Ejercicio 4: Conversor de euros a dólares
Pide euros (double) y convierte a dólares con tasa 1.08. Muestra: "X euros son Y dólares".

### Ejercicio 5: IMC
Pide peso (kg, double) y altura (m, double). Calcula IMC = peso / (altura * altura). Muestra el resultado.

### Ejercicio 6 (Reto): Nombre y apellido
Pide nombre completo con `nextLine()` y luego muestra cuántas letras tiene sin contar espacios. Pista: `nombre.replace(" ", "").length()`

---
Soluciones en `Solucion04.java`
