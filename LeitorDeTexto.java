package caixa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LeitorDeTexto {

	String text = "/home/zg/eclipse-workspace/ZG/src/caixa";
	
public static List<String> getResult(String regex,String text) {
 List<String> participantList = new ArrayList<>();
 
 Pattern pattern = Pattern.compile(regex);
 Matcher matcher = pattern.matcher(text);
 
 while(matcher.find()) {
  String participantName = matcher.group();
  participantList.add(participantName);
 }
 
 return participantList;
}

public static List<String> getId(String text){
	String regex = null;
	return	getResult(regex,text);
}
public static List<String> getPreco(String text){
	String regex = null;
	return getResult(regex,text);
}
public static List<String> getDescicao(String text){
	String regex = null;
	return getResult(regex,text);
}

public static List<String> getPromocao(String text){
	String regex = null;
	return getResult(regex,text);
}

public static ArrayList<Produto> getProdutos(List<String> id,List<String> Preco,List<String> descicao){
	ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	int idProduto;
	String descicaoo;
	float valor;
	
	for(int i=0;i<id.size();i++) {
		
		idProduto = Integer.parseInt(id.get(i));
		descicaoo = descicao.get(i);
		valor = Float.parseFloat( Preco.get(i));
	
	Produto produto = new Produto(idProduto, valor, descicaoo);
	produtos.add(produto);
		
	}
	
	return produtos;
	
}

}