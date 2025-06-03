package modelo;

import java.util.ArrayList;

public class PersonajeSecundario extends PersonajeCombatiente{
	
	ArrayList<String> frases;
	
	//Constructor
	public PersonajeSecundario() {
		
	}
	public PersonajeSecundario(String nombre, int vida, ArrayList<Ataque> listaAtaques, ArrayList<String> frases) {
		super(nombre, vida, listaAtaques);
		this.frases = frases;
	}
}


