package caixa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Produto_DAO {
	private static final String ADD_SQLPRODUTO = "INSERT INTO produtos (id,descrcao,preco)"
			+ "VALUES (?,?,?);" ;
	
	private static final String ADD_SQLPROMOCAO= "INSERT INTO relacionamento (idProduto,idPromocao)"
			+ "VALUES (?,?);" ;
	
	private static final String GET_PRODUTO= "SELECT * FROM produtos where id = ?;"
			+ "VALUES (?,?);" ;
	
	private static final String GET_PRODUTO2= "SELECT * FROM produtos where descricao = ?;"
			+ "VALUES (?,?);" ;
	
	private static final String ALTERA_SQLPRODUTO  = "UPDATE produto SET "
			+ "descicao = ?, preco = ? WHERE id = ?";
	
	
	public static void adicionaProduto(Produto produto,Integer idPromocao) {
		
		try(Connection conexao = FabricaConexao.getConexao();
		PreparedStatement adiciona = conexao.prepareStatement(ADD_SQLPRODUTO)){
			
			adiciona.setLong(1, produto.getId());
			adiciona.setString(2, produto.getDescricao());
			adiciona.setFloat(3, produto.getPreco());
			
			
			if(idPromocao != null) {
				
			Produto_DAO.AddPromocao(produto,idPromocao);
			}
			
			adiciona.executeUpdate();
		} 
		catch (SQLException e) {
			
			e.getMessage();
		}	
		
	}
	
	public static Produto getProduto(int id) {
		Produto produto = new Produto(id,0,null);
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(GET_PRODUTO)){
			
			consulta.setInt(1, id);
			
			ResultSet resultado = consulta.executeQuery();
			
			produto.setDescricao(resultado.getString("descicao"));
			produto.setPreco(resultado.getFloat("preco"));
			
		} 
		catch (SQLException e) {
			
			e.getMessage();
		}
		return produto;
		
	}
	
	public static Produto getProduto(String descricao) {
		Produto produto = new Produto((Integer) null,0,descricao);
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(GET_PRODUTO2)){
			
			consulta.setString(1, descricao);
			
			ResultSet resultado = consulta.executeQuery();
			
			produto.setId(resultado.getInt("id"));
			produto.setPreco(resultado.getFloat("preco"));
			
		} 
		catch (SQLException e) {
			
			e.getMessage();
		}
		return produto;
		
	}
	
		public static void AlteraProduto(Produto produto) {
		      try(Connection conexao = FabricaConexao.getConexao();

		      PreparedStatement altera = conexao.prepareStatement(ALTERA_SQLPRODUTO)){

		      
		      altera.setString(1, produto.getDescricao());
		      altera.setFloat(2, produto.getPreco());
		      altera.setInt(3, produto.getId());
		      }
		      catch (SQLException e) {

			e.getMessage();
		      }
		 }
		
			
		public static void  AddPromocao(Produto produto,Integer idPromocao) {
			 try(Connection conexao = FabricaConexao.getConexao();

			 PreparedStatement altera = conexao.prepareStatement(ADD_SQLPROMOCAO)){

			      
			    altera.setInt(1,produto.getId());
				altera.setInt(2,idPromocao);
				altera.executeUpdate();
					
					
					
			   }
			  catch (SQLException e) {

		       e.getMessage();
			      }
			 }
	
}
	
	

