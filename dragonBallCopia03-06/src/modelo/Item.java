package modelo;

public class Item {
    private int id;
    private String nombre;
    private String descripcion;
    private String tipo; // Ejemplo: "cura", "ataque", "defensa", "mision"
    private int valorEfecto; // Por ejemplo, puntos de vida que recupera, o daño extra


    public Item() {
    }

    // Constructor completo
    public Item(int id, String nombre, String descripcion, String tipo, int valorEfecto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.valorEfecto = valorEfecto;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public int getValorEfecto() {
        return valorEfecto;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValorEfecto(int valorEfecto) {
        this.valorEfecto = valorEfecto;
    }

    @Override
    public String toString() {
        return "Item: " + nombre +
               "\n  Descripción: " + descripcion +
               "\n  Tipo: " + tipo +
               "\n  Efecto: " + valorEfecto;
    }
}