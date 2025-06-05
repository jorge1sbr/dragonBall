
package modelo;

import java.util.ArrayList;

public class Protagonista extends PersonajeCombatiente {

	private int id; // Añadimos ID para poder guardarlo y cargarlo en el DAO

	// Constructor vacío (puede ser útil para ciertos frameworks o deserialización)
	public Protagonista() {
		super();

	}

	// Constructor existente, ahora con ID y el inventario inicializado
	public Protagonista( String nombre, int vida, ArrayList<Ataque> listaAtaques) {
		super(nombre, vida, listaAtaques);
	}


	// Nuevo getter para el ID
	public int getId() {
		return id;
	}

	// Nuevo setter para el ID (si fuera necesario, aunque se suele fijar en el
	// constructor o al cargar de DB)
	public void setId(int id) {
		this.id = id;
	}

}
