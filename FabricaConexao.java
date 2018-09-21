package caixa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	public static String url;
	public static String usuario;
	public static String senha;
	
	public static Connection getConexao() throws SQLException{
		
		try {
			Class.forName("");
			
			return DriverManager.getConnection(url,usuario,senha);
			
		}catch(ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}
}
