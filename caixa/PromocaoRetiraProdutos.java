package caixa;

public class PromocaoRetiraProdutos extends Promocao{
	
	
	public PromocaoRetiraProdutos(Integer id, String descricao, String obs, int quantativa, int quantpaga) {
		super(descricao, obs, quantativa, id);
		super.quantpaga=quantpaga;
		super.preco_final = (Float) null;
	}

	public float getDesconto(int quantidade, float preco) {
		int verificador;
		verificador = quantidade/quantativa;
		if(verificador>=1) {
			return preco*((quantativa-quantpaga)*verificador);
		}
	return 0;
	}

	public int getQuant_paga() {
		return quantpaga;
	}

	public void setQuant_paga(int quant_paga) {
		this.quantpaga = quant_paga;
	}
	
}
