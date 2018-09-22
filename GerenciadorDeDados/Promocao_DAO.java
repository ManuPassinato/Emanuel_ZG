package GerenciadorDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import caixa.Promocao;
import caixa.PromocaoRetiraProdutos;
import caixa.PromocaoRetiraValor;

public class Promocao_DAO {
	
	

	private static final String ADD_SQLPROMOCAO  = "INSERT INTO promocao (id,descricao,obs,quantativa,precofinal,quantpaga)"
			+ "VALUES (?,?,?,?,?,?);" ;
	
	public static void adicionaPromocao (PromocaoRetiraProdutos promocao) {
		try(Connection conexao = FabricaConexao.getConexao();
		PreparedStatement adiciona = conexao.prepareStatement(ADD_SQLPROMOCAO)){
			
			String tipodepromocao = promocao.conferePromocao(promocao);
			
			if(tipodepromocao.equals("RetiraProduto")) {
				
				adiciona.setLong(1, promocao.getId());
				adiciona.setString(2, promocao.getDescricao());
				adiciona.setString(3, promocao.getObs());
				adiciona.setFloat(4, promocao.getQuantAtiva());
				adiciona.setFloat(5, (Float) null);
				adiciona.setLong(6, promocao.getQuant_paga());
				
			}else if(tipodepromocao.equals("RetiraValor")) {
				
				adiciona.setLong(1, promocao.getId());
				adiciona.setString(2, promocao.getDescricao());
				adiciona.setString(3, promocao.getObs());
				adiciona.setFloat(4, promocao.getQuantAtiva());
				adiciona.setFloat(5, promocao.getPreco_final());
				adiciona.setLong(6, (Integer)null);
				
			}
			
			adiciona.executeUpdate();
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}}
	
	private static final String CONSULTA_SQLPROMOCAO  = "SELECT* FROM promocao WHERE id = ?";

	public static Promocao getPromocao(int id) {
		Promocao promocao = null;
		try(Connection conexao = FabricaConexao.getConexao();
		PreparedStatement consulta = conexao.prepareStatement(CONSULTA_SQLPROMOCAO)){
		
			ResultSet resultado = consulta.executeQuery();
			consulta.setInt(1, id);
			
			if(resultado.getFloat("precofinal") == (Float)null) {
				
				promocao = new PromocaoRetiraProdutos(null, null, id, id, id);
				promocao.setDescricao(resultado.getString("decicao"));
				promocao.setObs(resultado.getString("obs"));
				promocao.setQuantAtiva(resultado.getInt("quantativa"));
				promocao.setQuantpaga(resultado.getInt("quantpaga"));	
				
			}else if(resultado.getInt("quantpaga")== (Integer)null) {
				
				promocao = new PromocaoRetiraValor(null, null, id, id, id);
				promocao.setDescricao(resultado.getString("decicao"));
				promocao.setObs(resultado.getString("obs"));
				promocao.setQuantAtiva(resultado.getInt("quantativa"));
				promocao.setPreco_final(resultado.getFloat("precofinal"));
			}
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return promocao;
		}
	
	
	private static final String ALTERA_SQLPROMOCAO  = "UPDATE promocao SET "
			+ "descricao = ?, obs = ?, quant_ativa = ?, quant_paga = ? ,precofinal = ? WHERE id = ?";
	
	public static void AlteraPromocao(Promocao promocao) {
		try(Connection conexao = FabricaConexao.getConexao();
		PreparedStatement altera = conexao.prepareStatement(ALTERA_SQLPROMOCAO)){
		
		String tipodepromocao = promocao.conferePromocao(promocao);
		
		if(tipodepromocao.equals("RetiraProduto")) {
			
			altera.setString(1, promocao.getDescricao());
			altera.setString(2, promocao.getObs());
			altera.setInt(3, promocao.getQuantAtiva());
			altera.setFloat(4, promocao.getQuantpaga());
			altera.setFloat(5, promocao.getPreco_final());
			altera.setInt(6, promocao.getId());
			
		}else if(tipodepromocao.equals("RetiraValor")) {
			
			altera.setString(1, promocao.getDescricao());
			altera.setString(2, promocao.getObs());
			altera.setInt(3, promocao.getQuantAtiva());
			altera.setFloat(4, promocao.getQuantpaga());
			altera.setFloat(5, promocao.getPreco_final());
			altera.setInt(6, promocao.getId());
		}
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		}
}
