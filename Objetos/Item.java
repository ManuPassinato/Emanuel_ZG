package Objetos;

public class Item {
	
	public Produto produto;
	private int quantidade;
	
	public Item(Produto produto) {
		this.produto = produto;
		quantidade = 0;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Float getPrecoItem() {
		Float precoProduto = produto.getPreco();
		Integer quantidade = getQuantidade();	
		Float precoItem = precoProduto * quantidade;
		
		return precoItem;
	}
	
	public Float getDescontoItem() {
		Promocao promocao = produto.getPromocao();
		
		Float descontoitem = promocao.getDesconto(getQuantidade(), produto.getPreco());
		
		return descontoitem;
	}
}
