# Carrito de Compras - Refactorización Java

Este proyecto presenta una solución refactorizada de un sistema de gestión de carrito de compras, aplicando principios de **Diseño Orientado a Objetos (POO)**, **Clean Code** y mejora de **escalabilidad**.

## 🛠️ Refactorizaciones Implementadas

Siguiendo los requisitos de calidad de software, se han realizado los siguientes cambios estructurales:

### 1. Desacoplamiento y Entidad Propia
Se ha separado la lógica del programa principal de la lógica del negocio. Ahora existen tres clases independientes:
* `Item.java`: Representa la entidad del producto.
* `CarritoDeCompras.java`: Contiene la lógica de gestión de la cesta.
* `Main.java`: Clase encargada de ejecutar la simulación (Punto de entrada).

### 2. Separación de Responsabilidades (SRP)
* Se ha extraído el cálculo del total de la función de impresión. El carrito ahora tiene un método `calcularTotal()` independiente.
* La representación de cada producto se delega al método `toString()` de la clase `Item`, siguiendo los estándares de Java.

### 3. Encapsulamiento y Validación
* Los atributos de `Item` ahora son `private`.
* Se han implementado **Getters y Setters** con lógica de validación.
* **Manejo de Excepciones:** El sistema lanza `IllegalArgumentException` si se intentan asignar precios negativos o superiores al límite permitido (5000.00€), y `NoSuchElementException` si se intenta borrar un ítem inexistente.

### 4. Escalabilidad y Estructuras de Datos
Se ha sustituido el `ArrayList` original por un **`LinkedHashMap<Item, Integer>`**.
* **Eficiencia:** Permite acceso y búsqueda en tiempo constante $O(1)$.
* **Gestión de Cantidad:** Permite añadir la cantidad comprada de cada ítem de forma eficiente sin duplicar objetos en la lista.

### 5. Uso de Hiperparámetros y Constantes
Para evitar el uso de "números mágicos" y texto plano disperso, se han definido constantes `static final` para:
* Símbolo de moneda (`€`).
* Cabeceras de listado.
* Límites de precios válidos.

---

## 🚀 Estructura del Proyecto

* `src/Item.java`: Define el objeto producto con validaciones.
* `src/CarritoDeCompras.java`: Gestiona la colección de productos y cálculos.
* `src/Main.java`: Clase de prueba para demostrar el funcionamiento.

---

## 📖 Documentación (Javadoc)
El código ha sido documentado siguiendo el estándar **Javadoc**. Puedes generar la documentación técnica ejecutando:
```bash
javadoc -d doc src/*.java