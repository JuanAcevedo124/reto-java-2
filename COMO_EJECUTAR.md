# Cómo ejecutar Java en esta carpeta

Tienes Java 21 instalado. Hay 2 formas:

## Opción 1: Clásica (la que aprenderemos primero)
```powershell
# 1. Ir a la carpeta de la lección
cd "C:\Users\juana\OneDrive\Desktop\Estudio Java\01-fundamentos"

# 2. Compilar
javac HolaMundo.java
# Esto crea HolaMundo.class

# 3. Ejecutar
java HolaMundo
```

## Opción 2: Moderna (Java 21+, más corta)
```powershell
java HolaMundo.java
# Compila y ejecuta en un solo paso
```

## Si usas VS Code
1. Instala extensión "Extension Pack for Java"
2. Abre cualquier .java
3. Dale al botón ▶️ Run arriba a la derecha

## Errores comunes
- `error: class HolaMundo is public, should be declared in a file named HolaMundo.java` -> El nombre del archivo debe ser EXACTO a la clase
- `';' expected` -> Te falta punto y coma al final de la línea
- Usa `"` dobles para String y `'` simples para char
