package caixa;

import java.sql.SQLException;

import GerenciadorDeDados.BootStrap;
import GerenciadorDeDados.LeitorDeRegex;

public class Main {

	public static void main(String agr[]) {
	
		 	String txt = "/Users/usuário/eclipse-workspace/ZG2/src/GerenciadorDeDados/Data/Arquivo_dados_checkout.txt";
			System.out.println("ola word");
			BootStrap.preencheProdutos(txt);
			//LeitorDeRegex.getDescicao(txt);
			//LeitorDeRegex.getId(txt);
			//LeitorDeRegex.getPreco(txt);
			//LeitorDeRegex.getPreco(txt);
			//LeitorDeRegex.getPromocao(txt);
			
}}
