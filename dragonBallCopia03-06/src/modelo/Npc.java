package modelo;

import java.util.ArrayList;
import java.util.List;

public class Npc extends Personaje {
	ArrayList<String> frases;
	
	//Constructor
	public Npc () {
		
	}
	public Npc (String nombre, ArrayList<String> frases) {
		super(nombre);
		this.frases = frases;
	}
	
	//getters y setters
	public ArrayList<String> getFrase() {
		return frases;
	}
	public void setFrase(ArrayList<String> frases) {
		this.frases = frases;
	}
	
}
