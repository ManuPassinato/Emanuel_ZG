package caixa;

public class Produto {
	
	private float preco;
	private String descricao;
	private Integer id;
	
	public Produto(int id,float preco, String descricao) {
		this.preco=preco;
		this.descricao=descricao;
		this.id=id;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
			
	}
	
}
