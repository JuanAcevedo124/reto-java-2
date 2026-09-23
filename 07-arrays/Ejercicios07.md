# Ejercicios - Lección 07: Arrays

### Ejercicio 1: Básico
Crea `int[] nums = {5, 10, 15, 20, 25}` y muestra: primer elemento, último y longitud.

### Ejercicio 2: Recorrer y sumar
Con el array anterior, recorre con for y calcula suma y promedio. Muestra ambos.

### Ejercicio 3: Máximo y mínimo
Crea `int[] datos = {8, 3, 15, 6, 2, 9}`. Encuentra el mayor y el menor con for.

### Ejercicio 4: Contar aprobados
Crea `int[] notas = {4, 9, 6, 3, 10, 7, 5}`. Cuenta cuántos aprobaron (>=5) y cuántos reprobaron.

### Ejercicio 5: Buscar nombre
Crea `String[] nombres = {"Ana","Juan","Luis","Maria"}`. Pide un nombre por Scanner y di si está o no (usa `equals` en un for, pon boolean encontrado = false).

### Ejercicio 6: Array al revés
Crea `int[] original = {1,2,3,4,5}` y crea otro `invertido` del mismo tamaño. Llena invertido al revés y muéstralo con `Arrays.toString()`.

### Ejercicio 7: Scanner + array
Pide 5 números al usuario, guárdalos en `int[] entrada = new int[5]` y luego muestra la suma y el mayor.

### Ejercicio 8 (Reto): Ordenar sin sort
Crea `int[] arr = {4, 2, 7, 1}` y ordénalo tú con bucles anidados (burbuja) o simplemente usa `Arrays.sort(arr)` y muestra.

### Ejercicio 9 (Reto): Matriz
Crea matriz 3x3 `int[][] m` y llénala con números del 1 al 9 con bucles anidados. Muéstrala en forma de tabla.

---
Soluciones en `Solucion07.java`











int[] nums = {5, 10, 15, 20, 25};
    System.out.println("Primero: " + nums[0]);
    System.out.println("Ultimo: " + nums[nums.length - 1]);
    System.out.println("Longitud: " + nums.length);
    
    int suma = 0;
    for (int num : nums) suma += num;
    System.out.println("Suma: " + suma);
    double promedio = (double) suma / nums.length;
    System.out.println("Promedio: " + promedio);
    
    int[] datos = {8, 3, 15, 6, 2, 9};
    int max = datos[0];
    for (int num : datos) {
        if (num > max) 
        max = num;
    }
    System.out.println("Maximo: " + max);
    int min = datos[0];
    for (int num : datos) {
        if (num < min)
        min = num;
    }
    
    int[] notas = {4, 9, 6, 3, 10, 7, 5};
    int aprob = 0;
        for (int nota : notas) {
            if (nota >= 5) aprob++;
        }
    System.out.println("Aprobados: " + aprob + " Reprobados: " + (notas.length - aprob));
    
    String[] nombres = {"Ana","Juan","Luis","Maria"};
    System.out.println("Escribe tu nombre para verificar si estas en la lista");
    String nombreIngresado = sc.nextLine();
    boolean encontrado = false;
    for (String nombre : nombres)
        if (nombre.equals(nombreIngresado)) {
            encontrado = true;    
        }
    System.out.println(encontrado ? "Encontrado" : "No Encontrado"); 
    
    int[] original = {1,2,3,4,5};
    int[] invertido = {5,4,3,2,1};
    System.out.println("Invertido: " + Arrays.toString(invertido));
    Arrays.sort(invertido);
    System.out.println("Original: " + Arrays.toString(original));
    System.out.println("Invertido: " + Arrays.toString(invertido));