package daoDragonBall;

import modelo.CondicionAtmosferica;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoCondicionAtmosferica {

	private Connection conn;
	private static DaoCondicionAtmosferica instance = null;

	public DaoCondicionAtmosferica() throws SQLException {
		conn = DBConnection.getConnection();
	}
	
    public static DaoCondicionAtmosferica getInstance() throws SQLException {
        if (instance == null) {
            instance = new DaoCondicionAtmosferica();
        }
        return instance;
    }
	
	public ArrayList<CondicionAtmosferica> obtenerCondicionAtmosferica() throws SQLException{
		
		ArrayList<CondicionAtmosferica> lista = new ArrayList<>();
		
        String sql = "SELECT id, nombre, bonus_ataque, bonus_defensa FROM condiciones_atmosfericas";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()) {
        	int id = rs.getInt("id");
        	String nombre = rs.getString("nombre");
        	int bonusAtaque = rs.getInt("bonus_ataque");
            int bonusDefensa = rs.getInt("bonus_defensa");
        	lista.add(new CondicionAtmosferica(id, nombre,  bonusAtaque, bonusDefensa));
        }
        rs.close();
        statement.close();
        return lista;
	}

}
