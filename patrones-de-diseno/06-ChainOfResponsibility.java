// LECCIÓN 06: PATRÓN CHAIN OF RESPONSIBILITY
// Archivo: 06-ChainOfResponsibility.java

// ¿QUÉ ES?
// Pasa una petición a lo largo de una cadena de objetos.
// Cada objeto decide si la procesa o la pasa al siguiente.

// ¿CUÁNDO SE USA?
// - Aprobaciones: supervisor → gerente → director
// - Soporte técnico: nivel 1 → nivel 2 → nivel 3
// - Filtros: cada filtro decide si deja pasar o bloquea

// ==================== EJEMPLO SENCILLO ====================

abstract class Handler {
    protected Handler next;

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public void handle(int amount) {
        if (next != null) {
            next.handle(amount);
        }
    }
}

class Supervisor extends Handler {
    public void handle(int amount) {
        if (amount <= 500) {
            System.out.println("Supervisor aprobó: $" + amount);
        } else {
            super.handle(amount);
        }
    }
}

class Gerente extends Handler {
    public void handle(int amount) {
        if (amount <= 5000) {
            System.out.println("Gerente aprobó: $" + amount);
        } else {
            super.handle(amount);
        }
    }
}

class Director extends Handler {
    public void handle(int amount) {
        System.out.println("Director aprobó: $" + amount);
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

abstract class Filtro {
    protected Filtro siguiente;

    public Filtro setSiguiente(Filtro siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }

    public String filtrar(String texto) {
        if (siguiente != null) {
            return siguiente.filtrar(texto);
        }
        return texto;
    }
}

class FiltroPalabras extends Filtro {
    public String filtrar(String texto) {
        texto = texto.replace("malo", "***");
        texto = texto.replace("feo", "***");
        if (siguiente != null) {
            return siguiente.filtrar(texto);
        }
        return texto;
    }
}

class FiltroEspacios extends Filtro {
    public String filtrar(String texto) {
        while (texto.contains("  ")) {
            texto = texto.replace("  ", " ");
        }
        if (siguiente != null) {
            return siguiente.filtrar(texto);
        }
        return texto;
    }
}

class FiltroMayusculas extends Filtro {
    public String filtrar(String texto) {
        texto = texto.toUpperCase();
        if (siguiente != null) {
            return siguiente.filtrar(texto);
        }
        return texto;
    }
}

// ==================== CLASE PRINCIPAL ====================

public class ChainOfResponsibility {
    public static void main(String[] args) {

        System.out.println("=== CHAIN OF RESPONSIBILITY ===\n");

        // Ejemplo 1: Aprobaciones
        System.out.println("--- Aprobación de gastos ---");

        Handler supervisor = new Supervisor();
        Handler gerente = new Gerente();
        Handler director = new Director();

        supervisor.setNext(gerente).setNext(director);

        supervisor.handle(300);
        supervisor.handle(2000);
        supervisor.handle(10000);

        // Ejemplo 2: Filtros de texto
        System.out.println("\n--- Filtros de texto ---");

        Filtro filtro1 = new FiltroPalabras();
        Filtro filtro2 = new FiltroEspacios();
        Filtro filtro3 = new FiltroMayusculas();

        filtro1.setSiguiente(filtro2).setSiguiente(filtro3);

        String texto = "Este es  un texto  malo  con  espacios  feos";
        System.out.println("Original: " + texto);
        System.out.println("Filtrado: " + filtro1.filtrar(texto));
    }
}

// RESUMEN:
// 1. Handler → clase base con referencia al siguiente
// 2. Handlers concretos → procesan o pasan al siguiente
// 3. Cadena → se arma con setNext()
// 4. Ventaja: desacoplas quién procesa la petición
