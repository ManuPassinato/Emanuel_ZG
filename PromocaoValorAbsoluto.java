package caixa;

public class PromocaoValorAbsoluto implements Promocao{
	
	int quant_ativa,id;
	float preco_final;
	String obs,descricao;
	public PromocaoValorAbsoluto(int id,int leve,float valor,String obs,String descricao) {
		this.quant_ativa=leve;
		this.preco_final=valor;
		this.id=id;
		this.obs=obs;
		this.descricao=descricao;
	}
	
	public float getDesconto(int quantidade,float preco) {
		int verificador;
		verificador=quantidade/quant_ativa;
		if(verificador>=1){
			return preco*quant_ativa*verificador- preco_final*verificador;
		}
	return 0;
	}

	public int getQuant_ativa() {
		return quant_ativa;
	}

	public void setQuant_ativa(int quant_ativa) {
		this.quant_ativa = quant_ativa;
	}

	public int getId() {
		return id;
	}

	public float getPreco_final() {
		return preco_final;
	}

	public void setPreco_final(float preco_final) {
		this.preco_final = preco_final;
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
