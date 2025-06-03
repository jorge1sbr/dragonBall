package daoDragonBall;

import java.sql.*;
import modelo.TipoTerreno;
import java.util.ArrayList;
import java.util.List;

public class DaoTipoTerreno {

	private Connection conn;
	private static DaoTipoTerreno instance = null;
	
	public DaoTipoTerreno() throws SQLException {
		conn = DBConnection.getConnection();
	}
	
    public static DaoTipoTerreno getInstance() throws SQLException {
        if (instance == null) {
            instance = new DaoTipoTerreno();
        }
        return instance;
    }
    

	public ArrayList<TipoTerreno> obtenerTipoTerreno() throws SQLException{
		ArrayList<TipoTerreno> lista = new ArrayList<>();
		String sql = "SELECT id, nombre, bonus_ataque, bonus_defensa FROM tipo_terreno";
		PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()) {
        	int id = rs.getInt("id");
        	String nombre = rs.getString("nombre");
        	int bonusAtaque = rs.getInt("bonus_ataque");
            int bonusDefensa = rs.getInt("bonus_defensa");
        	lista.add(new TipoTerreno(id, nombre, bonusAtaque, bonusDefensa));
        }
        rs.close();
        statement.close();
        return lista;
	}
	

}
