package modelo;

import java.util.ArrayList;
import java.util.List;

public class PersonajeCombatiente extends Personaje {

	int vida;
	ArrayList<Ataque> listaAtaques;

	// Constructor
	public PersonajeCombatiente() {

	}

	public PersonajeCombatiente(String nombre, int vida, ArrayList<Ataque> listaAtaques) {
		super(nombre);
		this.vida = vida;
		this.listaAtaques = listaAtaques;
	}
	
	//getters y setters
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public List<Ataque> getAtaque() {
		return listaAtaques;
	}
	
	//MÉTODO ATACAR CON DAÑO TOTAL
	public void atacarTotal(int numAtaque) {
	    if (numAtaque >= 0 && numAtaque < listaAtaques.size()) {
	        Ataque ataque = listaAtaques.get(numAtaque);
	        System.out.println(nombre + " usa " + ataque.getNombre() + "!");
	        System.out.println("Daño total: " + ataque.getDanho_total());
	    } else {
	        System.out.println("Número de ataque inválido");
	    }
	}
	
	//MÉTODO ATACAR CON DAÑO PARCIAL
	public void atacarParcial(int numAtaque) {
	    if (numAtaque >= 0 && numAtaque < listaAtaques.size()) {
	        Ataque ataque = listaAtaques.get(numAtaque);
	        System.out.println(nombre + " usa " + ataque.getNombre() + "!");
	        System.out.println("Daño total: " + ataque.getDanho_parcial());
	    } else {
	        System.out.println("Número de ataque inválido");
	    }
	}

	//MÉTODO ATACAR CON FALLO
	public void atacarFallo(int numAtaque) {
	    if (numAtaque >= 0 && numAtaque < listaAtaques.size()) {
	        Ataque ataque = listaAtaques.get(numAtaque);
	        System.out.println(nombre + " usa " + ataque.getNombre() + "!");
	        System.out.println("Daño total: " + ataque.getDanho_fallo());
	    } else {
	        System.out.println("Número de ataque inválido");
	    }
	}





}
