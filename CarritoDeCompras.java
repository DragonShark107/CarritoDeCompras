import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Gestiona la colección de artículos seleccionados por el usuario.
 * Utiliza un Map para asociar ítems con sus cantidades de forma eficiente.
 */
public class CarritoDeCompras {
    public static final String CABECERA_DETALLE = "--- Detalles del carrito de compras ---";
    
    // Escalabilidad: Map permite acceso O(1) y gestionar cantidades fácilmente
    private Map<Item, Integer> items;

    public CarritoDeCompras() {
        this.items = new LinkedHashMap<>();
    }

    /**
     * Agrega un ítem al carrito o incrementa su cantidad si ya existe.
     */
    public void agregarItem(Item item, int cantidad) {
        if (cantidad <= 0) throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
        items.put(item, items.getOrDefault(item, 0) + cantidad);
    }

    /**
     * Elimina un ítem por completo del carrito.
     * @throws NoSuchElementException si el ítem no existe.
     */
    public void removerItem(Item item) {
        if (!items.containsKey(item)) {
            throw new NoSuchElementException("El ítem no se encuentra en el carrito.");
        }
        items.remove(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrecio() * entry.getValue();
        }
        return total;
    }

    public void imprimirDetalle() {
        System.out.println(CABECERA_DETALLE);
        items.forEach((item, cantidad) -> 
            System.out.println(item.toString() + " x" + cantidad)
        );
        System.out.println("Total: " + String.format("%.2f", calcularTotal()) + Item.SIMBOLO_MONEDA);
    }
}