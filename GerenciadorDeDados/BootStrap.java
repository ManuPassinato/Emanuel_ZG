package GerenciadorDeDados;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import caixa.Produto;


public class BootStrap {

	private static final String CREAT_TABLERODUTO = "CREATE TABLE IF NOT EXISTS produtos"
			+ "(id int NOT NULL PRIMARY KEY,"
			+ "descricao varchar(60),"
			+ "preco decimal(6,2) NOT NULL,"
			+ "idPromocao int references promocao(id));";
	
	private static final String CREAT_TABLEPROMOCAO = "CREATE TABLE IF NOT EXISTS promocao"
			+ "(id int NOT NULL PRIMARY KEY,"
			+ "descricao varchar(60),"
			+ "obs varchar(60),"
			+ "quantativa int,"
			+ "precofinal decimal(6,2),"
			+ "quantpaga int);";
	
	
	
	public static void criaTabelas() {
		try(Connection conexao = FabricaConexao.getConexao();
		PreparedStatement CriaProdutos = conexao.prepareStatement(CREAT_TABLERODUTO);
		PreparedStatement CriaPromocoes = conexao.prepareStatement(CREAT_TABLEPROMOCAO)){
						
			CriaPromocoes.executeUpdate();
			CriaProdutos.executeUpdate();
		
		}
		catch (SQLException e) {
						
			e.printStackTrace();
		}

	}

	public static void reencheProdutos(String txt) {
		ArrayList<Produto> produtos = LeitorDeRegex.getProdutos(txt);
		ArrayList<String> promocoes = (ArrayList<String>) LeitorDeRegex.getPromocao(txt);
		
		for(int i=0;i<produtos.size();i++) {
			Produto_DAO.adicionaProduto(produtos.get(i));
			
			if(Integer.parseInt(promocoes.get(i))!=-1) {
				
				Produto_DAO.alteraPromocao(produtos.get(i), Integer.parseInt(promocoes.get(i)));
			}
		}
	}
	
	
}

	
	
	
	
	
	
	
	
	
	
	

