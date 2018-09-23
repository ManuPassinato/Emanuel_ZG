package GerenciadorDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Objetos.Promocao;
import Objetos.PromocaoRetiraProdutos;
import Objetos.PromocaoRetiraValor;

public class Promocao_DAO {
	
	

	private static final String ADD_SQLPROMOCAO1  = "INSERT INTO promocao (id,descricao,obs,quantativa,quantpaga)"
			+ "VALUES (?,?,?,?,?);" ;
	private static final String ADD_SQLPROMOCAO2  = "INSERT INTO promocao (id,descricao,obs,quantativa,precofinal)"
			+ "VALUES (?,?,?,?,?);" ;
	
	public static void adicionaPromocao (Promocao promocao) {
		try(Connection conexao = FabricaConexao.getConexao();
		PreparedStatement adicionaRetiraValor = conexao.prepareStatement(ADD_SQLPROMOCAO2);
		PreparedStatement adicionaRetiraProduto = conexao.prepareStatement(ADD_SQLPROMOCAO1)){
			
			String tipodepromocao = promocao.conferePromocao(promocao);
			
			if(tipodepromocao.equals("RetiraProduto")) {
				
				adicionaRetiraProduto.setLong(1, promocao.getId());
				adicionaRetiraProduto.setString(2, promocao.getDescricao());
				adicionaRetiraProduto.setString(3, promocao.getObs());
				adicionaRetiraProduto.setFloat(4, promocao.getQuantAtiva());
				adicionaRetiraProduto.setFloat(5, promocao.getQuantpaga());
				
				adicionaRetiraProduto.executeUpdate();
			}else if(tipodepromocao.equals("RetiraValor")) {
				
				adicionaRetiraValor.setLong(1, promocao.getId());
				adicionaRetiraValor.setString(2, promocao.getDescricao());
				adicionaRetiraValor.setString(3, promocao.getObs());
				adicionaRetiraValor.setFloat(4, promocao.getQuantAtiva());
				adicionaRetiraValor.setFloat(5, promocao.getPreco_final());
				
				adicionaRetiraValor.executeUpdate();
				
			}
			
			
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}}
	
	private static final String CONSULTA_SQLPROMOCAO  = "SELECT* FROM promocao WHERE id = ?";

	public static Promocao getPromocao(Integer id) {
		
		if(id == 0) {
			return null;
		}
		
		Promocao promocao = null;
		try(Connection conexao = FabricaConexao.getConexao();
		PreparedStatement consulta = conexao.prepareStatement(CONSULTA_SQLPROMOCAO)){
			
			consulta.setInt(1, id);
			
			ResultSet resultado = consulta.executeQuery();
			resultado.next();
			
			Float precofinal = resultado.getFloat("precofinal");
			Integer quantpaga = resultado.getInt("quantpaga");
			if(precofinal == 0) {
				
				promocao = new PromocaoRetiraProdutos(id, null, null, id, id);
				promocao.setDescricao(resultado.getString("descricao"));
				promocao.setObs(resultado.getString("obs"));
				promocao.setQuantAtiva(resultado.getInt("quantativa"));
				promocao.setQuantpaga(resultado.getInt("quantpaga"));	
				
			}else if(quantpaga == 0) {
				
				promocao = new PromocaoRetiraValor(id, null, null, id, id);
				promocao.setDescricao(resultado.getString("descricao"));
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
