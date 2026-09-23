// LECCIÓN 04: PATRÓN STRATEGY
// Archivo: 04-Strategy.java

// ¿QUÉ ES?
// Strategy permite definir una familia de algoritmos, encapsular cada uno
// y hacerlos intercambiables. El cliente puede cambiar el algoritmo en tiempo de ejecución.

// ¿CUÁNDO SE USA?
// - Métodos de pago (tarjeta, PayPal, transferencia)
// - Algoritmos de ordenamiento (rápido, burbuja, inserción)
// - Estrategias de envío (express, estándar, económico)
// - Formatos de exportación (PDF, Excel, CSV)

// ==================== EJEMPLO SENCILLO ====================

// Interfaz Strategy
interface EstrategiaPago {
    void pagar(double monto);
}

// Estrategias concretas
class PagoTarjeta implements EstrategiaPago {
    public void pagar(double monto) {
        System.out.println("💳 Pagando $" + monto + " con Tarjeta de Crédito");
    }
}

class PagoPayPal implements EstrategiaPago {
    public void pagar(double monto) {
        System.out.println("🅿️ Pagando $" + monto + " con PayPal");
    }
}

class PagoTransferencia implements EstrategiaPago {
    public void pagar(double monto) {
        System.out.println("🏦 Pagando $" + monto + " con Transferencia");
    }
}

// Contexto (quien usa la estrategia)
class Carrito {
    private EstrategiaPago estrategia;

    public void setEstrategia(EstrategiaPago estrategia) {
        this.estrategia = estrategia;
    }

    public void checkout(double total) {
        if (estrategia == null) {
            System.out.println("❌ No hay método de pago seleccionado");
            return;
        }
        estrategia.pagar(total);
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

interface EstrategiaDescuento {
    double calcular(double precio);
}

class DescuentoNinguno implements EstrategiaDescuento {
    public double calcular(double precio) {
        return precio;
    }
}

class Descuento10Porciento implements EstrategiaDescuento {
    public double calcular(double precio) {
        return precio * 0.90;
    }
}

class Descuento20Porciento implements EstrategiaDescuento {
    public double calcular(double precio) {
        return precio * 0.80;
    }
}

class DescuentoFijo50 implements EstrategiaDescuento {
    public double calcular(double precio) {
        return precio - 50;
    }
}

class Tienda {
    private EstrategiaDescuento descuento;

    public void setDescuento(EstrategiaDescuento descuento) {
        this.descuento = descuento;
    }

    public void calcularPrecio(double precio) {
        double final_ = descuento.calcular(precio);
        System.out.println("  Precio original: $" + precio);
        System.out.println("  Precio final: $" + final_);
    }
}

// ==================== CLASE PRINCIPAL ====================

public class Strategy {
    public static void main(String[] args) {

        System.out.println("=== STRATEGY ===\n");

        // Ejemplo 1: Métodos de pago
        Carrito carrito = new Carrito();

        System.out.println("--- Opción 1: Pago con Tarjeta ---");
        carrito.setEstrategia(new PagoTarjeta());
        carrito.checkout(150.00);

        System.out.println("\n--- Opción 2: Cambiamos a PayPal ---");
        carrito.setEstrategia(new PagoPayPal());
        carrito.checkout(150.00);

        System.out.println("\n--- Opción 3: Cambiamos a Transferencia ---");
        carrito.setEstrategia(new PagoTransferencia());
        carrito.checkout(150.00);

        // Ejemplo 2: Descuentos
        System.out.println("\n--- Descuentos ---");

        Tienda tienda = new Tienda();

        System.out.println("\nSin descuento:");
        tienda.setDescuento(new DescuentoNinguno());
        tienda.calcularPrecio(200);

        System.out.println("\n10% de descuento:");
        tienda.setDescuento(new Descuento10Porciento());
        tienda.calcularPrecio(200);

        System.out.println("\n20% de descuento:");
        tienda.setDescuento(new Descuento20Porciento());
        tienda.calcularPrecio(200);

        System.out.println("\nDescuento fijo $50:");
        tienda.setDescuento(new DescuentoFijo50());
        tienda.calcularPrecio(200);
    }
}

// RESUMEN:
// 1. Strategy → interfaz común para todos los algoritmos
// 2. Estrategias concretas → implementan algoritmos diferentes
// 3. Contexto → tiene referencia a una estrategia, la puede cambiar
// 4. Ventaja: cambias el comportamiento sin modificar el contexto
