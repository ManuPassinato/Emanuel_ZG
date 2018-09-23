package GerenciadorDeDados;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import GerenciadorDeDados.Data.LeitorDeRegex;
import GerenciadorDeDados.Data.LeitorExcel;
import Objetos.Produto;
import Objetos.Promocao;


public class BootStrap {
	
	private static String produtoSQL = "/Users/usuário/eclipse-workspace/ZG2/src/GerenciadorDeDados/Data/produtoSQL.txt";
	private static final String CREAT_TABLERODUTO = LeitorDeRegex.lerArquivo(produtoSQL);
	
	private static String promocaoSQL = "/Users/usuário/eclipse-workspace/ZG2/src/GerenciadorDeDados/Data/promocaoSQL.txt";
	private static final String CREAT_TABLEPROMOCAO = LeitorDeRegex.lerArquivo(promocaoSQL);
		
	
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
	
	public static void preencheProdutos(String caminho) {
		
		String texto = LeitorDeRegex.lerArquivo(caminho);
		
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

	
	
	
	
	
	
	
	
	
	
	

