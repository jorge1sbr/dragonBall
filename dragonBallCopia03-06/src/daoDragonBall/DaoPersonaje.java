package daoDragonBall;

import java.sql.*;
import java.util.*;
import modelo.*;

public class DaoPersonaje {
    
    private Connection conn;
    private static DaoPersonaje instance = null;
    
    public DaoPersonaje() throws SQLException {
        conn = DBConnection.getConnection();
    }
    
	public static DaoPersonaje getInstance() throws SQLException{
		
		if(instance == null) {
			instance = new DaoPersonaje();
		}
		
		return instance;
	}
	
    
    public ArrayList<Protagonista> obtenerProtagonistas() throws SQLException {
        ArrayList<Protagonista> personajesProtagonistas = new ArrayList<>();

        String obtenerProtagonistas = "SELECT id, nombre, vida FROM personajes WHERE tipo = 'protagonista'";
        PreparedStatement statement = conn.prepareStatement(obtenerProtagonistas);
        ResultSet rs = statement.executeQuery();

        DaoAtaque daoAtaque = DaoAtaque.getInstance();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int vida = rs.getInt("vida");

            ArrayList<Ataque> ataques = daoAtaque.obtenerAtaquesPorPersonaje(id);

            Protagonista protagonista = new Protagonista(nombre, vida, ataques);
            personajesProtagonistas.add(protagonista);
        }

        rs.close();
        statement.close();

        return personajesProtagonistas;
    }
    public ArrayList<PersonajeSecundario> obtenerSecundarios() throws SQLException {
        ArrayList<PersonajeSecundario> personajesSecundarios = new ArrayList<>();

        String obtenerPersonajesSecundarios = "SELECT id, nombre, vida FROM personajes WHERE tipo = 'personajeSecundario'";
        PreparedStatement statement = conn.prepareStatement(obtenerPersonajesSecundarios);
        ResultSet rs = statement.executeQuery();

        DaoAtaque daoAtaque = DaoAtaque.getInstance();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int vida = rs.getInt("vida");

            ArrayList<Ataque> ataques = daoAtaque.obtenerAtaquesPorPersonaje(id);

            PersonajeSecundario secundario = new PersonajeSecundario(nombre, vida, ataques, new ArrayList<>());
            personajesSecundarios.add(secundario);
        }

        rs.close();
        statement.close();

        return personajesSecundarios;
    }
    
    public ArrayList<PersonajeCombatiente> obtenerEnemigos() throws SQLException {
        ArrayList<PersonajeCombatiente> personajesEnemigos = new ArrayList<>();

        String ontenerPersonajesEnemigos = "SELECT id, nombre, vida FROM personajes WHERE tipo = 'enemigo'";
        PreparedStatement statement = conn.prepareStatement(ontenerPersonajesEnemigos);
        ResultSet rs = statement.executeQuery();

        DaoAtaque daoAtaque = DaoAtaque.getInstance();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int vida = rs.getInt("vida");

            ArrayList<Ataque> ataques = daoAtaque.obtenerAtaquesPorPersonaje(id);

            PersonajeCombatiente enemigo = new PersonajeCombatiente(nombre, vida, ataques);
            personajesEnemigos.add(enemigo);
        }

        rs.close();
        statement.close();

        return personajesEnemigos;
    }

}
