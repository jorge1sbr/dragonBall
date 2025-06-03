package modelo;

import java.util.ArrayList;


public class Protagonista extends PersonajeCombatiente {

    
    
    
    //Constructor
    public Protagonista() {
    }

    public Protagonista(String nombre, int vida, ArrayList<Ataque> listaAtaques) {
        super(nombre, vida, listaAtaques); 
        
    }
    

}
