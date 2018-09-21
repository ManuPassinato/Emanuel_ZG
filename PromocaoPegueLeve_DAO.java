package caixa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PromocaoPegueLeve_DAO {
	
	private static final String ADD_SQLPROMOCAO  = "INSERT INTO promocao (id,descrcao,obs,quant_ativa,preco_final,quant_paga)"
			+ "VALUES (?,?,?,?,?,?);" ;
	
    private static final String Consulta_SQLPROMOCAO  = "SELECT* FROM promocao WHERE id = ?";
	
	private static final String Altera_SQLPROMOCAO  = "UPDATE promocao SET "
			+ "descricao = ?, obs = ?, quant_ativa = ?, quant_paga = ? WHERE id = ?";


	public void adicionaPromocao (PromocaoPagueLeve promocao) {
		try(Connection conexao = FabricaConexao.getConexao();
		PreparedStatement adiciona = conexao.prepareStatement(ADD_SQLPROMOCAO)){
			
			adiciona.setLong(1, promocao.getId());
			adiciona.setString(2, promocao.getDescricao());
			adiciona.setString(3, promocao.getObs());
			adiciona.setFloat(4, promocao.getQuant_ativa());
			adiciona.setFloat(5, (Float) null);
			adiciona.setLong(6, promocao.getQuant_paga());
			
			
			adiciona.executeUpdate();
		} 
		catch (SQLException e) {
			
			e.getMessage();
		}}

}
