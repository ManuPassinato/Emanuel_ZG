package caixa;

import GerenciadorDeDados.Produto_DAO;

public class PromocaoRetiraValor extends Promocao{

	
	public PromocaoRetiraValor(Integer id,String descricao, String obs, int quantativa,  float preco_final) {
		super(descricao, obs, quantativa, id);
		super.preco_final = preco_final;
		super.quantpaga = (Integer) null;
	}


	public float getDesconto(int quantidade,float preco) {
		int verificador;
		verificador=quantidade/quantativa;
		
		if(verificador>=1){
			
			Float desconto = quantativa*preco*verificador - preco_final*verificador;
			
			if(desconto>0) {
				return desconto;
			}
		}
		
	return 0;
	}

	public Float getPreco_final() {
		return preco_final;
	}

	public void setPreco_final(float preco_final) {
		this.preco_final = preco_final;
	}

}
