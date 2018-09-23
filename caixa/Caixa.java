package caixa;
import java.text.DecimalFormat;
import java.util.ArrayList;
public class Caixa {
	
	ArrayList<Item> compra = new ArrayList<Item>();
	
	
	public int verificaItem(Produto produto) {
		
		for(int i = 0;i<compra.size();i++) {
			
			if(produto == compra.get(i).produto) {
				return i;
			}
		}
	return -1;
	}
	
	public void addItem(Produto produto) {
	
		int indiceItem = verificaItem(produto);
		
			if(indiceItem!=-1) {
				
				compra.get(indiceItem).setQuantidade(compra.get(indiceItem).getQuantidade()+1);
			
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
			compra.get(indiceItem).setQuantidade(compra.get(indiceItem).getQuantidade()-1);
			
			if(compra.get(indiceItem).getQuantidade() == 0) {
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
