package caixa;
import java.util.List;
public class Calcula {
	
	public static float getPrecoBruto(List<Item> compra){
		float precoTotal=0;
		
		
		for(int i=0;i<compra.size();i++) {
			
			Float precoProduto = compra.get(i).produto.getPreco();
			Integer quantidade = compra.get(i).getQuantidade();	
		
			Float precoItem = precoProduto * quantidade;
		
			precoTotal += precoItem;
		}
		
	return precoTotal;
	}
	
	
	public static float getDesconto(List<Item> compra) {
		float descontoTotal=0;
		
		for(int i=0;i<compra.size();i++) {
			Item item = compra.get(i);
			
			if(item.produto.getPromocao()!=null)
			{
				Float descontoItem = item.produto.getPromocao().getDesconto(item.getQuantidade(), item.produto.getPreco());
				
				descontoTotal += descontoItem;
				
			}
		}
	return descontoTotal;
	}
	
public static float getPrecoLiquido(List<Item> compra) {
		
		float precoLiquido=0;
		precoLiquido=	getPrecoBruto(compra)	-	getDesconto(compra);
		return precoLiquido;
	}
	
}
