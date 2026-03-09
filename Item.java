/**
 * Representa un artículo individual en el catálogo.
 * Maneja su propia validación de precios y formato de visualización.
 */
public class Item {
    // Hiperparámetros y constantes
    private static final double PRECIO_MINIMO = 0.0;
    private static final double PRECIO_MAXIMO = 10000.0;
    public static final String SIMBOLO_MONEDA = "$";

    private String nombre;
    private double precio;

    public Item(String nombre, double precio) {
        setNombre(nombre);
        setPrecio(precio);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < PRECIO_MINIMO || precio > PRECIO_MAXIMO) {
            throw new IllegalArgumentException("Precio fuera de rango permitido (0 - 10000).");
        }
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("%s - %s%.2f", nombre, SIMBOLO_MONEDA, precio);
    }
}