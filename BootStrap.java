package caixa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BootStrap {

	private static final String CREAT_TABLERODUTO = "CREATE TABLE produtos IF NOT EXISTS"
			+ "(id int NOT NULL PRIMERY KEY,"
			+ "decicao varchar(60),"
			+ "preco decimal(6,2) NOT NULL);";
	
	private static final String CREAT_TABLEPROMOCAO = "CREATE TABLE promocao IF NOT EXISTS"
			+ "(id int NOT NULL PRIMERY KEY,"
			+ "decicao varchar(60),"
			+ "obs varchar(60)"
			+ "quant_ativa int"
			+ "preco_final decimal(6,2) "
			+ "quant_paga int);";
	
	private static final String CREAT_TABLERELACIONAMENTO = "CREATE TABLE relacionamento IF NOT EXISTS"
			+ "(idProduto int references produtos(id),"
			+ "idPromocao int references promocao(id));";
	
	
	public static void CriaTabelas() {
		try(Connection conexao = FabricaConexao.getConexao();
		PreparedStatement CriaProdutos = conexao.prepareStatement(CREAT_TABLERODUTO)){
				
			CriaProdutos.executeUpdate();
		
		PreparedStatement CriaPromocoes = conexao.prepareStatement(CREAT_TABLEPROMOCAO);
					
			CriaPromocoes.executeUpdate();
		
		PreparedStatement CriaRelacionamento = conexao.prepareStatement(CREAT_TABLERELACIONAMENTO);
						
			CriaRelacionamento.executeUpdate();
		}
		catch (SQLException e) {
						
			e.getMessage();
		}

	}
	
	
}

	
	
	
	
	
	
	
	
	
	
	

