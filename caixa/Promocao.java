package caixa;

public abstract class Promocao {
	
	public Promocao(String descricao, String obs, int quantativa, Integer id) {
		super();
		this.descricao = descricao;
		this.obs = obs;
		this.quantativa = quantativa;
		this.id = id;
	}


	public String descricao,obs;
	public int quantativa;
	public Integer id;
	Float preco_final;
	Integer quantpaga;

	public abstract float getDesconto(int quantidade,float preco);
	
	
	public String conferePromocao(Promocao promocao) {
		
		if(promocao.getQuantpaga() == (Integer)null) {
			return "RetiraValor";
		}
		else if(promocao.getPreco_final() == (Float)null) {
			return "RetiraProduto";
		}
		
		return null;
	}
	

	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getObs() {
		return obs;
	}



	public void setObs(String obs) {
		this.obs = obs;
	}



	public int getQuantAtiva() {
		return quantativa;
	}



	public void setQuantAtiva(int quantativa) {
		this.quantativa = quantativa;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Float getPreco_final() {
		return preco_final;
	}

	public void setPreco_final(float preco_final) {
		this.preco_final = preco_final;
	}

	public Integer getQuantpaga() {
		return quantpaga;
	}

	public void setQuantpaga(int quantpaga) {
		this.quantpaga = quantpaga;
	}
}
