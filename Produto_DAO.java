package caixa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Produto_DAO {
	private static final String ADD_SQLPRODUTO = "INSERT INTO produtos (id,descrcao,preco)"
			+ "VALUES (?,?,?);" ;
	
	public void adicionaProduto(Produto produto) {
		try(Connection conexao = FabricaConexao.getConexao();
		PreparedStatement adiciona = conexao.prepareStatement(ADD_SQLPRODUTO)){
			
			adiciona.setLong(1, produto.getId());
			adiciona.setString(2, produto.getDescricao());
			adiciona.setFloat(3, produto.getPreco());
			
			adiciona.executeUpdate();
		} 
		catch (SQLException e) {
			
			e.getMessage();
		}	
		
	}

	
	}
	
	

