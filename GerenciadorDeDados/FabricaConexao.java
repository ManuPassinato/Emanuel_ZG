package GerenciadorDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	public static String url = "jdbc:postgresql://localhost:5434/ZG";
	public static String usuario = "postgres";
	public static String senha = "123";
	
	public static Connection getConexao() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			
			return DriverManager.getConnection(url,usuario,senha);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
	}
}