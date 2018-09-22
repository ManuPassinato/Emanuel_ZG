package caixa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import GerenciadorDeDados.BootStrap;
import GerenciadorDeDados.FabricaConexao;
import GerenciadorDeDados.LeitorDeRegex;
import GerenciadorDeDados.LeitorExcel;
import GerenciadorDeDados.Produto_DAO;
import jxl.read.biff.BiffException;

public class Main {

	public static void main(String agr[]) {
	
		 	String txt = "/Users/usuário/eclipse-workspace/ZG2/src/GerenciadorDeDados/Data/Arquivo_dados_checkout.txt";
			String url = "/Users/usuário/eclipse-workspace/ZG2/src/GerenciadorDeDados/Data/promoções.xls";
		 	System.out.println("ola word");
		
			Produto produto = Produto_DAO.getProduto(1);
			System.out.println(produto.getDescricao());
}}
