package caixa;
import java.text.DecimalFormat;
import java.util.ArrayList;

import Objetos.Item;
import Objetos.Produto;
public class Caixa {
	
	ArrayList<Item> compra = new ArrayList<Item>();
	
	
	public int verificaItem(Produto produto) {
		
		for(int i = 0;i<compra.size();i++) {
			Item item = compra.get(i);
			
			if(produto == item.produto) {
				return i;
			}
		}
	return -1;
	}
	
	public void addItem(Produto produto) {
		int indiceItem = verificaItem(produto);
		
			if(indiceItem!=-1) {
				Item item = compra.get(indiceItem);	
				item.setQuantidade(item.getQuantidade()+1);
			
			}			
			else{
				
				Item item = new Item(produto);
				item.setQuantidade(item.getQuantidade()+1);
				compra.add(item);	
			}
	}
	
	public void removerItem(Produto produto) {
		
		int indiceItem	=	verificaItem(produto);
		if(indiceItem!=-1) {
			
			Item item = compra.get(indiceItem);	
			item.setQuantidade(item.getQuantidade()-1);
			
			if(item.getQuantidade() == 0) {
				compra.remove(indiceItem);
			}
		}
	}
	
	public String precoTotalCompra() {
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		return df.format(Calcula.getPrecoLiquido(compra));
		
	}
	
	public void rest() {
		compra = new ArrayList<Item>();
	}
	
}
