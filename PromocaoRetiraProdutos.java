package caixa;

public class PromocaoRetiraProdutos implements Promocao{
	
	int quant_ativa,quant_paga;
	Integer id;
	public String obs,descricao;
	
	public PromocaoRetiraProdutos(int id,int quant_ativa,int quant_paga,String obs,String descricao) {
		this.quant_ativa=quant_ativa;
		this.quant_paga=quant_paga;
		this.id=id;
		this.obs=obs;
		this.descricao=descricao;
	}
	
	public float getDesconto(int quantidade, float preco) {
		int verificador;
		verificador = quantidade/quant_ativa;
		if(verificador>=1) {
			return preco*((quant_ativa-quant_paga)*verificador);
		}
	return 0;
	}

	public int getQuant_ativa() {
		return quant_ativa;
	}

	public void setQuant_ativa(int quant_ativa) {
		this.quant_ativa = quant_ativa;
	}

	public int getQuant_paga() {
		return quant_paga;
	}

	public void setQuant_paga(int quant_paga) {
		this.quant_paga = quant_paga;
	}

	public int getId() {
		return id;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
