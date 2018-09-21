package caixa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PromocaoValorAbsoluto_DAO {
	
	
	private static final String ADD_SQLPROMOCAO  = "INSERT INTO promocao (id,descrcao,obs,quant_ativa,preco_final,quant_paga)"
			+ "VALUES (?,?,?,?,?,?);" ;
	
	private static final String Consulta_SQLPROMOCAO  = "SELECT* FROM promocao WHERE id = ?";
	
	private static final String Altera_SQLPROMOCAO  = "UPDATE promocao SET "
			+ "descricao = ?, obs = ?, quant_ativa = ?, preco_final = ? WHERE id = ?";
	
	
	public void adicionaPromocao(PromocaoValorAbsoluto promocao) {
		try(Connection conexao = FabricaConexao.getConexao();
		PreparedStatement adiciona = conexao.prepareStatement(ADD_SQLPROMOCAO)){
			
			adiciona.setLong(1, promocao.getId());
			adiciona.setString(2, promocao.getDescricao());
			adiciona.setString(3, promocao.getObs());
			adiciona.setFloat(4, promocao.getQuant_ativa());
			adiciona.setFloat(5, promocao.getPreco_final());
			adiciona.setInt(6, (Integer) null);
			
			
			adiciona.executeUpdate();
		} 
		catch (SQLException e) {
			
			e.getMessage();
		}}
	
	public PromocaoValorAbsoluto getPromocao(int id) {
		PromocaoValorAbsoluto promocao = new PromocaoValorAbsoluto(id, 0, 0, null, null);
		try(Connection conexao = FabricaConexao.getConexao();
		
		PreparedStatement consulta = conexao.prepareStatement(Consulta_SQLPROMOCAO)){
		ResultSet resultado = consulta.executeQuery();
		
		consulta.setInt(1, id);
		
			promocao.setDescricao(resultado.getString("decicao"));
			promocao.setObs(resultado.getString("obs"));
			promocao.setQuant_ativa(resultado.getInt("quant_ativa"));
			promocao.setPreco_final(resultado.getFloat("preco_final"));	
		
		}
		catch (SQLException e) {
			
			e.getMessage();
		}
		return promocao;
		}
	
	public void AlteraPromocao(PromocaoValorAbsoluto promocao) {
		try(Connection conexao = FabricaConexao.getConexao();
		
		PreparedStatement consulta = conexao.prepareStatement(ADD_SQLPROMOCAO)){
		
		
		consulta.setString(1, promocao.getDescricao());
		consulta.setString(1, promocao.getObs());
		consulta.setInt(1, promocao.getQuant_ativa());
		consulta.setFloat(1, promocao.getPreco_final());
		consulta.setInt(1, promocao.getId());
		}
		catch (SQLException e) {
			
			e.getMessage();
		}
		}
}
