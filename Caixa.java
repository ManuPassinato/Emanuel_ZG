package caixa;
import java.util.ArrayList;
public class Caixa {
	
	ArrayList<Item> compra = new ArrayList<Item>();
	
	public enum adicionaRemove{
		Adiciona,Remove;
	}
	
	//recebe as informacoes e as processa
	
	
	//verifica se o item ja esta na lista de compas, se sim pega seu indicie na lista
	public int verificaItem(Produto produto) {
		for(int i = 0;i<compra.size();i++) {
			if(produto == compra.get(i).produto) {
				return i;
			}
		}
	return -1;
	}
	
	public void addItem(Produto produto) {
		int indiceItem;
		
		indiceItem=verificaItem(produto);
		if(indiceItem!=-1) {
			compra.get(indiceItem).setQuantidade(compra.get(indiceItem).getQuantidade()+1);
		}			
		else {
			Item item = new Item(produto);
			item.setQuantidade(item.getQuantidade()+1);
			compra.add(item);
		}
	}
	
	public void removerItem(Produto produto) {
		int indiceItem=verificaItem(produto);
		
		if(indiceItem!=-1) {
			compra.get(indiceItem).setQuantidade(compra.get(indiceItem).getQuantidade()-1);
			if(compra.get(indiceItem).getQuantidade() == 0) {
				compra.remove(indiceItem);
			}
		}
	}
	
	public float getPrecoLiquido() {
		
		float precoLiquido=0;
		precoLiquido=Calcula.getPrecoBruto(compra)-Calcula.getDesconto(compra);
		return precoLiquido;
	}
	
	public void rest() {
		compra = new ArrayList<Item>();
	}
	
}
