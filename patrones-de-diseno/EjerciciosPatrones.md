# Ejercicios - Patrones de Diseño

Intenta hacer estos sin mirar el ejemplo. Edita los archivos o crea archivos nuevos.

---

## Ejercicio 1: Singleton
Crea un **Logger** Singleton que:
- Tenga un método `log(String mensaje)` que imprima "[LOG]: " + mensaje
- Guarde el total de mensajes registrados
- Tenga un método `contarMensajes()` que retorne cuántos se han registrado

---

## Ejercicio 2: Factory Method
Crea una fábrica de **Vehículos** que:
- Tenga una interfaz `Vehiculo` con método `conducir()`
- Cree: `Coche`, `Moto`, `Camion`
- La fábrica reciba el tipo y retorne el vehículo correcto

---

## Ejercicio 3: Observer
Crea un sistema de **suscripciones** donde:
- Un `Canal` tenga suscriptores
- Cuando el canal publique, todos los suscriptores reciban el mensaje
- Agrega un tipo de usuario que reciba notificación por email y otro por SMS

---

## Ejercicio 4: Strategy
Crea un sistema de **descuentos** donde:
- Tenga interfaz `Descuento` con método `calcular(double precio)`
- Implementa: `SinDescuento`, `Descuento10Porciento`, `DescuentoFijo`
- El carrito pueda cambiar de estrategia en cualquier momento

---

## Ejercicio 5: Decorator
Crea un sistema de **notificaciones** donde:
- La notificación base diga "Hola"
- Puedas agregarle: mayúsculas, emojis, formato HTML
- Prueba combinar varios decoradores

---

## Ejercicio 6: Chain of Responsibility
Crea un sistema de **aprobación de préstamos** donde:
- `Analista` apruebe hasta $10,000
- `Gerente` apruebe hasta $50,000
- `Director` apruebe cualquier monto
- Si nadie aprueba, muestre "Préstamo rechazado"

---

## Ejercicio 7: Builder
Crea un **Hamburguesa** Builder que tenga:
- Tamaño (pequeña, mediana, grande)
- Carne (res, pollo, vegana)
- Ingredientes (queso, lechuga, tomate, etc.)
- Precio según las opciones

---

## Ejercicio 8: Adapter
Crea un adaptador para **conectar una impresora vieja** con una interfaz nueva:
- Interfaz nueva: `imprimir(String documento)`
- Impresora vieja: `imprimirVieja(String doc, int copias)`
- El adapter debe funcionar con la interfaz nueva

---

---

## Ejercicio 9: Prototype
Crea un **personaje de videojuego** con Prototype que:
- Tenga vida, ataque, defensa y habilidad especial
- Puedas clonar personajes y modificar solo algunos atributos
- Muestre las diferencias entre original y clon

---

## Ejercicio 10: Bridge
Crea un **sistema de notificaciones** con Bridge donde:
- Implementación: Email, SMS, Push
- Abstracción: MensajeUrgente, MensajeNormal
- Prueba combinar cada tipo de mensaje con cada notificación

---

## Ejercicio 11: Composite
Crea un **menú de restaurante** con Composite donde:
- Opciones simples (hamburguesa, pizza, ensalada)
- Submenús (Postres, Bebidas)
- Muestre el menú completo con precios y calcule el total

---

## Ejercicio 12: Facade
Crea una **computadora** con Facade donde:
- Clases internas: CPU, RAM, Disco, TarjetaRed
- Facade con: encender(), apagar(), reiniciar()
- El cliente solo usa el facade

---

## Ejercicio 13: Flyweight
Crea un **juego del ahorcado** con Flyweight donde:
- Letras compartidas (solo una instancia de cada letra)
- Posiciones únicas para cada letra en la palabra
- Muestre cuántas instancias de letras se crearon

---

## Ejercicio 14: Proxy
Crea un **sistema de archivos** con Proxy donde:
- Proxy de lectura: solo usuarios autorizados
- Proxy de escritura: solo admins
- Lazy loading: cargar archivo solo cuando se acceda

---

## Ejercicio 15: Command
Crea un **editor** con Command donde:
- Comandos: Escribir, Borrar, Copiar
- Control Z: deshacer último comando
- Historial de comandos ejecutados

---

## Ejercicio 16: Iterator
Crea un **árbol genealógico** con Iterator donde:
- Recorra en orden: padres, hijos, hermanos
- Iterator preorder y postorder
- Sin exponer la estructura interna del árbol

---

## Ejercicio 17: Mediator
Crea un **chat de grupo** con Mediator donde:
- Usuarios se comuniquen solo por el mediador
- Mensajes privados y broadcasts
- Log de mensajes enviados

---

## Ejercicio 18: Memento
Crea un **juego** con Memento donde:
- Guardar posición del jugador
- Restaurar partida guardada
- Historial de últimas 5 posiciones

---

## Ejercicio 19: State
Crea una **máquina expendedora** con State donde:
- Estados: EsperandoDinero, Seleccionando, Entregando
- Cada estado tenga comportamiento diferente
- Transiciones claras entre estados

---

## Ejercicio 20: Template Method
Crea un **proceso de cocina** con Template Method donde:
- Pasos: Preparar, Cocinar, Servir
- Cada plato tenga ingredientes diferentes
- Extras opcionales según el plato

---

## Ejercicio 21: Visitor
Crea un **sistema de descuentos** con Visitor donde:
- Productos: Electrónica, Ropa, Alimentos
- VisitorCalcularDescuento calcule descuento por tipo
- VisitorMostrar muestre info de cada producto

---

Cuando termines, avísame y vemos las soluciones.
