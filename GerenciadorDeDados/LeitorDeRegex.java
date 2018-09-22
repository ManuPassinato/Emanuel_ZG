package GerenciadorDeDados;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import caixa.Produto;


public class LeitorDeRegex {

	
	
	public static List<String> getResult(String regex,String text) {
		List<String> participantList = new ArrayList<>();
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
	 
		while(matcher.find()) {
			String participantName = matcher.group();
			System.out.println(participantName);
			participantList.add(participantName);
		}
	 
	 return participantList;
	}
	
	public static List<String> getId(String text){
		String regex = "(?<=id:\\s)[^\\|]+";
		return	getResult(regex,text);
	}
	
	public static List<String> getPreco(String text){
		String regex = "(?<=valor:\\s)[^\\.]+.\\d\\d";
		return getResult(regex,text);
	}
	
	public static List<String> getDescicao(String text){
		String regex = "(?<=descricao:\\s)[^\\|]+";
		return getResult(regex,text);
	}
	
	public static List<String> getPromocao(String text){
		String regex = "(?<=promocao:\\s)[^\\|]+";
		return getResult(regex,text);
	}
	
	public static ArrayList<Produto> getProdutos(String text){
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
			ArrayList<String> idlist = (ArrayList<String>) getId(text); 
			ArrayList<String> precolist = (ArrayList<String>) getPreco(text);
			
			ArrayList<String> descricaolist = (ArrayList<String>) getDescicao(text);
		
			Integer id;
			String descicao;
			Float preco;
			
				for(int i=0;i<idlist.size();i++) {
					
						id = Integer.parseInt(idlist.get(i));
						descicao = 	descricaolist.get(i);
						preco = Float.parseFloat(precolist.get(i));
			
				Produto produto = new Produto(id,preco,descicao);
				produtos.add(produto);
			}
		
		return produtos;	
	}


}