package modelo;

public class Personaje {
	
	String nombre;
	
	//Constructor
	public Personaje() {
		
	}
	public String getNombre() {
		return nombre;
	}
	
	//getters y setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Personaje(String nombre) {
		this.nombre = nombre;
	}
}
