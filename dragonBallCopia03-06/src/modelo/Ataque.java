package modelo;

public class Ataque {

		String nombre;
	
		int danho_total;
		int danho_parcial;
		int danho_fallo;
		
	public Ataque() {
		
	}
	public Ataque(String nombre,  int danho_total, int danho_parcial, int danho_fallo ) {
		this.nombre = nombre;
		
		this.danho_total = danho_total;
		this.danho_parcial = danho_parcial;
		this.danho_fallo = danho_fallo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public int getDanho_total() {
		return danho_total;
	}
	public void setDanho_total(int danho_total) {
		this.danho_total = danho_total;
	}
	public int getDanho_parcial() {
		return danho_parcial;
	}
	public void setDanho_parcial(int danho_parcial) {
		this.danho_parcial = danho_parcial;
	}
	public int getDanho_fallo() {
		return danho_fallo;
	}
	public void setDanho_fallo(int danho_fallo) {
		this.danho_fallo = danho_fallo;
	}
	@Override
	public String toString() {
	    return "Nombre: " + nombre + "\n" +
	           "Daño Total: " + danho_total + "\n" +
	           "Daño Parcial: " + danho_parcial + "\n" +
	           "Daño Fallo: " + danho_fallo + "\n";
	}

	
		
		
		
		
		
		
		
		
		
}
