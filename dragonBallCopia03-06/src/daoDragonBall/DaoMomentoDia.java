package daoDragonBall;

import java.sql.*;
import modelo.MomentoDia;
import java.util.ArrayList;
import java.util.List;

public class DaoMomentoDia {

	private Connection conn;
	private static DaoMomentoDia instance = null;
	
	private DaoMomentoDia() throws SQLException{
		conn = DBConnection.getConnection();
	}
	
    public static DaoMomentoDia getInstance() throws SQLException {
        if (instance == null) {
            instance = new DaoMomentoDia();
        }
        return instance;
    }
    
	public ArrayList<MomentoDia> obtenerMomentoDia() throws SQLException{
		ArrayList<MomentoDia> lista = new ArrayList<>();
		String sql = "SELECT id, nombre, bonus_ataque, bonus_defensa FROM momento_dia";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String nombre = rs.getString("nombre");
			int bonusAtaque = rs.getInt("bonus_ataque");
            int bonusDefensa = rs.getInt("bonus_defensa");
			lista.add(new MomentoDia (id, nombre, bonusAtaque, bonusDefensa));
		}
		
		rs.close();
		statement.close();
		return lista;
	}
}
