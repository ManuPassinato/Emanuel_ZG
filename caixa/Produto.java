package caixa;

import GerenciadorDeDados.Promocao_DAO;

public class Produto {
	
	private float preco;
	private String descricao;
	private Integer id;
	Integer idpromocao;
	
	public Produto(Integer id,float preco, String descricao) {
		this.preco=preco;
		this.descricao=descricao;
		this.id=id;
		this.idpromocao = null;
	}
	
	public Promocao getPromocao() {	
		if(idpromocao != null || idpromocao != 0) {
		return Promocao_DAO.getPromocao(this.idpromocao);
		}
	return null;	
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

	public Integer getIdPromocao() {
		return idpromocao;
	}

	public void setIdPromocao(Integer promocao) {
		this.idpromocao = promocao;
	}
	
}
