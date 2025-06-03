package modelo;

import java.util.HashMap;
import java.util.Map;

public class Inventario {
    // Usamos un HashMap para guardar los Items y su cantidad.
   
    private Map<Item, Integer> items;

    public Inventario() {
        this.items = new HashMap<>();
    }

    // Método para añadir un ítem al inventario
    public void agregarItem(Item item, int cantidad) {
        items.put(item, items.getOrDefault(item, 0) + cantidad);
        System.out.println("Has añadido " + cantidad + "x " + item.getNombre() + " a tu inventario.");
    }

    // Método para quitar un ítem del inventario
    public boolean quitarItem(Item item, int cantidad) {
        if (items.containsKey(item)) {
            int cantidadActual = items.get(item);
            if (cantidadActual >= cantidad) {
                items.put(item, cantidadActual - cantidad);
                if (items.get(item) <= 0) {
                    items.remove(item); // Si la cantidad llega a 0 o menos, elimina el ítem del mapa
                }
                System.out.println("Has quitado " + cantidad + "x " + item.getNombre() + " de tu inventario.");
                return true;
            } else {
                System.out.println("No tienes suficientes " + item.getNombre() + ".");
                return false;
            }
        } else {
            System.out.println(item.getNombre() + " no está en tu inventario.");
            return false;
        }
    }

    // Método para obtener la cantidad de un ítem
    public int getCantidad(Item item) {
        return items.getOrDefault(item, 0);
    }

    // Método para verificar si el inventario está vacío
    public boolean estaVacio() {
        return items.isEmpty();
    }

    // Método para obtener todos los items del inventario (con sus cantidades)
    public Map<Item, Integer> getItems() {
        return items;
    }

    // Método para imprimir el contenido del inventario
    public void imprimirInventario() {
        if (estaVacio()) {
            System.out.println("Tu inventario está vacío.");
            return;
        }
        System.out.println("\n--- Tu Inventario ---");
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int cantidad = entry.getValue();
            System.out.println("- " + item.getNombre() + " x" + cantidad + " (" + item.getTipo() + ")");
        }
        System.out.println("---------------------\n");
    }
}