package daoDragonBall;
import java.sql.*;
import java.util.Properties;


public class DBConnection {

		public static Connection instance = null;
		
		public static final String JDBC_BDD_URL = "jdbc:mysql://localhost:3306/dragon_ball";
		
		public static Connection getConnection() throws SQLException{
			
			if (instance == null) {
				
				Properties props = new Properties();
				props.put("user", "root");
				props.put("password", "");
				
				instance = DriverManager.getConnection(JDBC_BDD_URL, props);
			}
		
			return instance;
		}
		
		
}

