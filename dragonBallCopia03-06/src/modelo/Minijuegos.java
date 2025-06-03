package modelo;

import java.util.Random;
import java.util.Scanner;

public class Minijuegos {
	private Scanner sc = new Scanner(System.in);
	
	public Minijuegos() {
		
	}

	public boolean piedraPapelTijerasZ() {
	    Random rand = new Random();

	    System.out.println("""
	        Piedra, Papel o Tijeras Z :
	        Recuerda, las reglas son como el Piedra, Papel o Tijera humano.
	        1 (Caparazón) vence a 2 (Brazo de androide 16)
	        2 (Brazo de androide 16) vence a 3 (Frijol Senzu)
	        3 (Frijol Senzu) vence a 1 (Caparazón)
	        """);

	    int puntosJugador = 0;
	    int puntosEnemigo = 0;

	    while (puntosJugador < 2 && puntosEnemigo < 2) {
	        int eleccionUsuario = 0;
	        String opcionUsuario = "";

	        System.out.println("Elige qué sacar:");
	        System.out.println("1. Caparazón del Maestro Tortuga");
	        System.out.println("2. Brazo de androide 16");
	        System.out.println("3. Frijol Senzu");

	        String eleccion = sc.nextLine();
	        while (!eleccion.equals("1") && !eleccion.equals("2") && !eleccion.equals("3")) {
	            System.out.println("Elección no válida. Elige 1, 2 o 3:");
	            eleccion = sc.nextLine();
	        }

	        if (eleccion.equals("1")) {
	            eleccionUsuario = 1;
	            opcionUsuario = "Caparazón del Maestro Tortuga";
	        } else if (eleccion.equals("2")) {
	            eleccionUsuario = 2;
	            opcionUsuario = "Brazo de androide 16";
	        } else {
	            eleccionUsuario = 3;
	            opcionUsuario = "Frijol Senzu";
	        }

	        int eleccionSistema = rand.nextInt(3) + 1;
	        if (eleccionSistema == 1) {
	            System.out.println("Dabra ha elegido: Caparazón del Maestro Tortuga");
	        } else if (eleccionSistema == 2) {
	            System.out.println("Dabra ha elegido: Brazo de Androide 16");
	        } else {
	            System.out.println("Dabra ha elegido: Frijol Senzu");
	        }


	        if (eleccionUsuario == eleccionSistema) {
	            System.out.println("Empate. ¡Volvemos a elegir!");
	            continue;
	        }


	        if ((eleccionUsuario == 1 && eleccionSistema == 2) ||
	            (eleccionUsuario == 2 && eleccionSistema == 3) ||
	            (eleccionUsuario == 3 && eleccionSistema == 1)) {
	            System.out.println("Has ganado esta ronda con " + opcionUsuario + ".");
	            puntosJugador++;
	        } else {
	            System.out.println("Dabra gana esta ronda.");
	            puntosEnemigo++;
	        }

	        System.out.println("Puntuación: Tú " + puntosJugador + " - Dabra " + puntosEnemigo);
	        System.out.println();
	    }
	    if (puntosJugador == 2) {
	        System.out.println("¡Has ganado el combate contra Dabra!");
	        return true;
	    } else {
	        System.out.println("Has perdido el combate contra Dabra.");
	        return false;
	    }
	}

}
