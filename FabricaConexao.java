package caixa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	public static String url = "jdbc:postgresql://192.168.1.55:5432/checkout_emanuel";
	public static String usuario = "postgres";
	public static String senha = "zg@123";
	
	public static Connection getConexao() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			
			return DriverManager.getConnection(url,usuario,senha);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
	}
}