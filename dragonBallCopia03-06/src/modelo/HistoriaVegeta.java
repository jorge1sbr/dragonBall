package modelo;

public class HistoriaVegeta {

	   private Protagonista protagonista;
		  
	   private Juego juego;


	   public HistoriaVegeta(Protagonista protagonista, Juego juego) {
		    this.protagonista = protagonista;
		    this.juego = juego;
		}

	    public void iniciar() {
	        System.out.println("🌟 Comienza la historia de Vegeta...");
	        
	    }
}
