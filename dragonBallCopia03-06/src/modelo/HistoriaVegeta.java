package modelo;

import java.util.Scanner;

public class HistoriaVegeta {

	   private Protagonista protagonista;
	   private Juego juego;
	   private Minijuegos minijuegos;
	   private int puntuacionUsuario;
	   private Scanner sc = new Scanner(System.in);
	   private Minijuegos minijuego = new Minijuegos();

	   public HistoriaVegeta(Protagonista protagonista, Juego juego) {
		    this.protagonista = protagonista;
		    this.juego = juego;
		    this.puntuacionUsuario = 0;
		}

	    public void iniciar() {
	        escenaPrologo();
	        pruebaOrgullo();
	        pruebaSabiduria();
	        pruebaPoder();
	        escenaCombateFinal(); 
	    }
	    
	    private void escenaPrologo() {
	    	System.out.println("\n✨ PROLOGO ✨");
	        System.out.println("[Kaioshin del Tiempo aparece herido frente a Vegeta.]");
	        System.out.println("KAIOSHIN: Vegeta... Arokk, una aberración temporal, está usando tus errores para destruirte desde dentro.");
	        System.out.println("KAIOSHIN: Solo superando tres pruebas —Pasado, Sabiduría y Poder— tendrás una oportunidad de enfrentarlo.");
	        System.out.println("[Tres esferas de energía flotan a su alrededor. Comienza la aventura.]");
	    }
	    
	    
	    private void pruebaOrgullo() {
	    	System.out.println("\n🪨 PRUEBA 1: Reflejo del Orgullo");
	        System.out.println("[En las ruinas del planeta Vegeta, una estatua del Rey Vegeta se activa.]");
	        System.out.println("ESTATUA: El mayor enemigo del orgullo… no siempre es el poder.");
	        
	        System.out.println("\nACERTIJO: ¿Cuando el sol y la luna son lo mismo, quién gana?");
	        System.out.println("1. El guerrero\n2. El miedo\n3. La razón");
	        int eleccion = sc.nextInt();
	        sc.nextLine();
	    }
	    
	    private void pruebaSabiduria() {
	    	
	    }
	    
	    private void pruebaPoder() {
	    	
	    }
	    
	    private void escenaCombateFinal() {
	    	
	    }
}
