package controller;

import modelo.*;

import java.sql.*;

import java.util.Scanner;

import daoDragonBall.*;

public class Main {

	public static void main(String[] args) throws SQLException {
	
	
	boolean fin = false; 
	
	Menus menu = new Menus();
	String usuario = menu.menuLogin();
	
	//SE CREA LA PARTIDA PARA GUARDARLA FACILMENTE AL ACABAR
	Partida partida = new Partida(usuario, 0, "");
	Juego juego = new Juego();
	juego.inicializar();
	
	juego.imprimirProtagonistas();
	
	//EL USUARIO ELIGE SU PROTAGONISTA
	Protagonista protagonista = juego.elegirProtagonistaInicial(); 
	while (!fin && protagonista.getVida()>0) {
	PersonajeCombatiente enemigo = juego.buscarEnemigoPorNombre("Majin Boo");
	System.out.println(enemigo);
	System.out.println("Vida protagonista: " + protagonista.getVida());
	System.out.println("Vida enemigo: " + enemigo.getVida());
//	Combate combate = new Combate(protagonista, enemigo, juego);
//	combate.combatir();
	//INICIAMOS LA HISTORIA QUE ELIJA
	switch (protagonista.getNombre().toLowerCase()) {
	    case "goku":
	        new HistoriaGoku(protagonista, juego, partida).iniciar();
	        fin = true;
	        break;
	    case "vegeta":
	        new HistoriaVegeta(protagonista, juego).iniciar();
	        break;
	    case "majin boo":
	    	new HistoriaBoo(protagonista, juego).iniciar();

	        break;
	        
	}

	}
	
	/*Combate  combate = new Combate(protagonista, enemigo, juego);*/
	if(protagonista.getVida() > 0) {
		partida.setFinalPartida("Victoria");
	} else {
		partida.setFinalPartida("Derrota");
	}
	// SYSO COMPROBAMOS PARTIDA
	System.out.println("Guardando partida...");
	System.out.println("Usuario: " + partida.getNombreUsuario());
	System.out.println("Puntuación: " + partida.getPuntuacion());
	System.out.println("Fecha: " + partida.getFecha());
	System.out.println("Final de partida: " + partida.getFinalPartida());
	
	DaoPartida.getInstance().guardarPartida(partida);

 }



 }
	
	

		



