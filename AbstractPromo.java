package caixa;

public abstract class AbstractPromo {
	
	public AbstractPromo(String descricao, String obs, int quantativa, Integer id) {
		super();
		this.descricao = descricao;
		this.obs = obs;
		this.quantativa = quantativa;
		this.id = id;
	}
	
	public String descricao,obs;
	public int quantativa;
	public Integer id;

	public abstract float getDesconto(int quantidade,float preco);

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
}
