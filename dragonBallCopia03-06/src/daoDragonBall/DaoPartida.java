package daoDragonBall;

import java.sql.*;
import modelo.Partida;

public class DaoPartida {

	private static DaoPartida instance;
	private Connection conn;

	private DaoPartida() throws SQLException {
		conn = DBConnection.getConnection();
	}

	public static DaoPartida getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoPartida();
		}
		return instance;
	}

	public void guardarPartida(Partida partida) throws SQLException {

		String guardarPartida = "INSERT INTO partidas (nombre_usuario, puntuacion, fecha, final_partida) VALUES (?, ?, ?, ?)";

		PreparedStatement statement = conn.prepareStatement(guardarPartida);
		statement.setString(1, partida.getNombreUsuario());
		statement.setInt(2, partida.getPuntuacion());
		statement.setTimestamp(3, Timestamp.valueOf(partida.getFecha()));
		statement.setString(4, partida.getFinalPartida());
		statement.executeUpdate();
		statement.close();

	}
}