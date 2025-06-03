package modelo;

public class MomentoDia {
	private int id;
	private String nombre;
	private int bonusAtaque;
	private int bonusDefensa;

	public MomentoDia(int id, String nombre, int bonusAtaque, int bonusDefensa) {
		this.id = id;
		this.nombre = nombre;
		this.bonusAtaque = bonusAtaque;
		this.bonusDefensa = bonusDefensa;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getBonusAtaque() {
		return bonusAtaque;
	}

	public int getBonusDefensa() {
		return bonusDefensa;
	}

	@Override
	public String toString() {
		return nombre + " (Bonus ataque: " + getBonusAtaque() + ")" + "\n" + nombre
				+ " (Bonus defensa: " + getBonusDefensa() + ")";
	}

}

