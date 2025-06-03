package daoDragonBall;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Ataque;

public class DaoAtaque {
	
	private Connection conn = null;
	private static DaoAtaque instance = null;
	
	public DaoAtaque () throws SQLException {
		conn = DBConnection.getConnection();
	}
	
	public static DaoAtaque getInstance() throws SQLException{
		
		if(instance == null) {
			instance = new DaoAtaque();
		}
		
		return instance;
	}
	
	//OBTENER EL ATAQUE DE UN PERSONAJE 
	public ArrayList<Ataque> obtenerAtaquesPorPersonaje(int personajeId) throws SQLException {
		
		String obtenerAtaquePorPersonaje = "{CALL ObtenerAtaquesPorPersonaje(?)}";
		
		CallableStatement statement = conn.prepareCall(obtenerAtaquePorPersonaje);
		
		statement.setInt(1, personajeId);
		
		ResultSet rs = statement.executeQuery();
		
		ArrayList<Ataque> listaAtaques = new ArrayList<>();

		 while (rs.next()) {
		        Ataque ataque = new Ataque();
		        ataque.setNombre(rs.getString("nombre"));
		        ataque.setDanho_total(rs.getInt("daño_total"));
		        ataque.setDanho_parcial(rs.getInt("daño_parcial"));
		        ataque.setDanho_fallo(rs.getInt("daño_fallo"));
		        
		        listaAtaques.add(ataque);
		    }

		    rs.close();
		    statement.close();

		    return listaAtaques;
		}
	public void imprimirAtaquesPorPersonaje(int personajeId) throws SQLException {
	    String imprimirAtaquesPorPersonaje = "{CALL ObtenerAtaquesPorPersonaje(?)}";

	    CallableStatement statement = conn.prepareCall(imprimirAtaquesPorPersonaje);
	    statement.setInt(1, personajeId);

	    ResultSet rs = statement.executeQuery();

	    while (rs.next()) {
	        System.out.println("Nombre: " + rs.getString("nombre"));
	        System.out.println("Daño total: " + rs.getInt("daño_total"));
	        System.out.println("Daño parcial: " + rs.getInt("daño_parcial"));
	        System.out.println("Daño fallo: " + rs.getInt("daño_fallo"));
	        System.out.println("-----------------------------");
	    }

	    rs.close();
	    statement.close();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
