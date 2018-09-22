package GerenciadorDeDados;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import caixa.Produto;
import caixa.Promocao;
import jxl.read.biff.BiffException;


public class BootStrap {

	private static final String CREAT_TABLERODUTO = "CREATE TABLE produtos"
			+ "(id int NOT NULL PRIMARY KEY,"
			+ "descricao varchar(60),"
			+ "preco decimal(6,2) NOT NULL,"
			+ "idPromocao int references promocao(id));";
	
	private static final String CREAT_TABLEPROMOCAO = "CREATE TABLE promocao"
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
	
	
	public static String lerArquivo(String strCaminho) {

		  try {
		 BufferedReader in = new BufferedReader(new FileReader(strCaminho));
		 String str;
		 StringBuffer buf = new StringBuffer();
		 while (in.ready()) {
		  str = in.readLine();
		  buf.append(str);
		 }
		 in.close();
		 return buf.toString();
		  } catch (Exception e) {
		 e.printStackTrace();
		 return null;
		  }
		}

	public static void preencheProdutos(String caminho) {
		String texto = lerArquivo(caminho);
		
		ArrayList<Produto> produtos = LeitorDeRegex.getProdutos(texto);
		ArrayList<String> promocoes = (ArrayList<String>) LeitorDeRegex.getPromocao(texto);
		
		for(int i=0;i<produtos.size();i++) {
			Produto_DAO.adicionaProduto(produtos.get(i));
			
			if(Integer.parseInt(promocoes.get(i))!=-1) {
				
				Produto_DAO.alteraPromocao(produtos.get(i), Integer.parseInt(promocoes.get(i)));
			}
		}
	}
	
	public static void geradorPromocao(String url) throws SQLException {
		ArrayList<Promocao> promocao;
		try {
			promocao = LeitorExcel.lerPromocao(url);
			for(int i = 0; i<promocao.size();i++) {
				
				Promocao_DAO.adicionaPromocao(promocao.get(i));
			
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
}

	
	
	
	
	
	
	
	
	
	
	

