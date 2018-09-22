package caixa;

public class PromocaoRetiraValor extends Promocao{

	
	public PromocaoRetiraValor(String descricao, String obs, int quantativa, Integer id, float preco_final) {
		super(descricao, obs, quantativa, id);
		super.preco_final = preco_final;
		super.quantpaga = (Integer) null;
	}


	public float getDesconto(int quantidade,float preco) {
		int verificador;
		verificador=quantidade/quantativa;
		if(verificador>=1){
			return preco*quantativa*verificador- preco_final*verificador;
		}
	return 0;
	}

	public float getPreco_final() {
		return preco_final;
	}

	public void setPreco_final(float preco_final) {
		this.preco_final = preco_final;
	}

}
