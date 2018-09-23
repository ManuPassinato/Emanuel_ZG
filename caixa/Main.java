package caixa;

import java.sql.SQLException;

import GerenciadorDeDados.BootStrap;
import GerenciadorDeDados.Produto_DAO;
import Objetos.Produto;


public class Main {

	public static void main(String agr[]) throws SQLException {
	
		 	String txt = "/Users/usuário/eclipse-workspace/ZG2/src/GerenciadorDeDados/Data/Arquivo_dados_checkout.txt";
			String url = "/Users/usuário/eclipse-workspace/ZG2/src/GerenciadorDeDados/Data/promoções.xls";
			
			System.out.println("Espero que esteja tudo certo hehe");
		 	
		 	BootStrap.criaTabelas();
		 	BootStrap.geradorPromocao(url);
		 	BootStrap.preencheProdutos(txt);
			
		 	Caixa supermecado = new Caixa();
		 	
		 	Produto produto = Produto_DAO.getProduto(22);
			Produto produto2 = Produto_DAO.getProduto(3);
		 	
		 	System.out.println("\nvalor esperado: 183.79 \nvalor pelo programa: ");
		 	supermecado.addItem(produto2);
		 	supermecado.addItem(produto2);
		 	supermecado.addItem(produto2);
		 	supermecado.addItem(produto2);
		 	supermecado.addItem(produto2);
		 	supermecado.addItem(produto);
		 	supermecado.addItem(produto);
		 	supermecado.addItem(produto);
		 	System.out.println(supermecado.precoTotalCompra());
		 	
		 	Caixa supermecado2 = new Caixa();
		 	
		 	Produto produto3 = Produto_DAO.getProduto(1);
			Produto produto4 = Produto_DAO.getProduto(23);
		 	
		 	System.out.println("\nvalor esperado: 104,42 \nvalor pelo programa: ");
		 	supermecado2.addItem(produto3);
		 	supermecado2.addItem(produto3);
		 	supermecado2.addItem(produto3);
		 	supermecado2.addItem(produto3);
		 	supermecado2.addItem(produto4);
		 	supermecado2.addItem(produto4);
		 	supermecado2.addItem(produto4);
		 	System.out.println(supermecado2.precoTotalCompra());
		 	
		 	Caixa supermecado3 = new Caixa();
		 	
		 	Produto produto5 = Produto_DAO.getProduto(2);
			Produto produto6 = Produto_DAO.getProduto(23);
		 	
		 	System.out.println("\nvalor esperado: 248.93 \nvalor pelo programa: ");
		 	supermecado3.addItem(produto5);
		 	supermecado3.addItem(produto5);
		 	supermecado3.addItem(produto5);
		 	supermecado3.addItem(produto5);
		 	supermecado3.addItem(produto6);
		 	supermecado3.addItem(produto6);
		 	supermecado3.addItem(produto6);
		 	System.out.println(supermecado3.precoTotalCompra());
		 	
		 	Caixa supermecado4 = new Caixa();
		 	
		 	Produto produto7 = Produto_DAO.getProduto(45);
			
		 	
		 	System.out.println("\nvalor esperado: 0.00 \nvalor pelo programa: ");
		 	supermecado4.addItem(produto7);
		 	supermecado4.addItem(produto7);
		 	supermecado4.removerItem(produto7);
		 	supermecado4.removerItem(produto7);
		 		 	
		 	System.out.println(supermecado4.precoTotalCompra());
		 	
	
}}
