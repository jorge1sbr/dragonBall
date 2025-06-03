package modelo;

import java.time.LocalDateTime;

public class Partida {

	private String nombreUsuario;
	private int puntuacion;
	private String finalPartida;
	private LocalDateTime fecha;
	
	public Partida (String nombreUsuario, int puntuacion, String finalPartida) {
		this.nombreUsuario = nombreUsuario;
		this.puntuacion = puntuacion;
		this.finalPartida = finalPartida;
		this.fecha = LocalDateTime.now();
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public void sumarPuntos(int puntos) {
	    puntuacion += puntos;
	}

	public String getFinalPartida() {
		return finalPartida;
	}

	public void setFinalPartida(String finalPartida) {
		this.finalPartida = finalPartida;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}


	
	
}
