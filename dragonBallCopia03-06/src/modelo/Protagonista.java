
	package modelo;

	import java.util.ArrayList;

	public class Protagonista extends PersonajeCombatiente {

	    private int id; // Añadimos ID para poder guardarlo y cargarlo en el DAO
	    private Inventario inventario; // Agregamos el inventario

	    // Constructor vacío (puede ser útil para ciertos frameworks o deserialización)
	    public Protagonista() {
	        super();
	        this.inventario = new Inventario(); // Inicializa el inventario al crear un protagonista
	    }

	    // Constructor existente, ahora con ID y el inventario inicializado
	    public Protagonista(int id, String nombre, int vida, ArrayList<Ataque> listaAtaques) {
	        super(nombre, vida, listaAtaques);
	        this.id = id;
	        this.inventario = new Inventario(); // Inicializa el inventario al crear un protagonista
	    }

	    // Constructor para cargar un protagonista con un inventario existente
	    public Protagonista(int id, String nombre, int vida, ArrayList<Ataque> listaAtaques, Inventario inventario) {
	        super(nombre, vida, listaAtaques);
	        this.id = id;
	        this.inventario = inventario;
	    }


	    // Nuevo getter para el ID
	    public int getId() {
	        return id;
	    }

	    // Nuevo setter para el ID (si fuera necesario, aunque se suele fijar en el constructor o al cargar de DB)
	    public void setId(int id) {
	        this.id = id;
	    }

	    // Nuevo getter para el inventario
	    public Inventario getInventario() {
	        return inventario;
	    }

	    // Nuevo setter para el inventario
	    public void setInventario(Inventario inventario) {
	        this.inventario = inventario;
	    }

	    // Puedes añadir un método de conveniencia para mostrar el inventario del protagonista
	    public void mostrarInventario() {
	        System.out.println("Inventario de " + this.getNombre() + ":");
	        this.inventario.imprimirInventario();
	    }
	}
 
