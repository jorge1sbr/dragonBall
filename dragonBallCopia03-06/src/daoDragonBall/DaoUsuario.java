package daoDragonBall;

import java.sql.*;

public class DaoUsuario {

	private Connection conn = null;

	private static DaoUsuario instance = null;

	public DaoUsuario() throws SQLException {

		conn = DBConnection.getConnection();
	}

	public static DaoUsuario getInstance() throws SQLException {

		if (instance == null) {
			instance = new DaoUsuario();
		}

		return instance;
	}

	//REGISTRAR USUARIO	
	public boolean registrarUsuario(String nombreUsuarioIn, String passwordIn) throws SQLException {

		String insertSql = "INSERT INTO usuarios (nombre_usuario, password) VALUES (?, ?)";

		try (PreparedStatement statement = conn.prepareStatement(insertSql)) {

			statement.setString(1, nombreUsuarioIn);
			statement.setString(2, passwordIn);

			statement.executeUpdate();

			return true;
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("El nombre de usuario ya existe");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	//ACTUALIZAR PUNTUACIÓN
	public void actualizarPuntuacion(String nombreUsuarioIn, int nuevaPuntuacionIn) throws SQLException{
		
		String updateSql = "UPDATE usuarios SET puntuacion_total = ? WHERE nombre_usuario = ?";
		
		PreparedStatement statementUpdate = conn.prepareStatement(updateSql);
		
		statementUpdate.setInt(1, nuevaPuntuacionIn);
		statementUpdate.setString(2, nombreUsuarioIn);
		
		int regsUpdate = statementUpdate.executeUpdate();
		
		if(regsUpdate > 0) {
			System.out.println("Puntuación actualizada");
		} else {
			System.out.println("No se ha actualizado la puntuación");
		}
		statementUpdate.close();
		}
	
	//LOG-IN USUARIO
	public void loginUsuario(String nombreUsuarioIn, String passwordIn) throws SQLException {
		
		String loginSQL = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND password = ?";
		
		PreparedStatement statementLogin = conn.prepareStatement(loginSQL);
		
		statementLogin.setString(1, nombreUsuarioIn);
		statementLogin.setString(2, passwordIn);
		
		ResultSet resultadoLogin = statementLogin.executeQuery();
		
		if(resultadoLogin.next()) {
			System.out.println("Login correcto. Bienvenido " + nombreUsuarioIn);
		} else {
			System.out.println("Login incorrecto. Inténtelo de nuevo");
		}
		
		 resultadoLogin.close();
		 statementLogin.close();
	}
	
		
	}


	
	