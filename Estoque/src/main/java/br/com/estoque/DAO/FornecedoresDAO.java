package br.com.estoque.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.estoque.conexao.ConexaoFactory;
import br.com.estoque.domain.Fornecedores;

public class FornecedoresDAO {

	
	public void salvar(Fornecedores f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("insert into fornecedores ");
		sql.append("(descricao)");
		sql.append("values (?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.executeUpdate();
	}
	
	public void excluir (Fornecedores f) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from fornecedores ");
		sql.append("where codigo = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		comando.executeUpdate();
		
	}
	
	public Fornecedores buscaPorCodigo (Fornecedores f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("Select codigo, descricao ");
		sql.append("from fornecedores ");
		sql.append("where codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setLong(1,f.getCodigo());
		
		ResultSet resultado = comando.executeQuery();
		Fornecedores retorno = null;
		
		if(resultado.next()) {
			retorno = new Fornecedores();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
		}
		return retorno;
	}
	
	public void editar (Fornecedores f) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("update fornecedores ");
		sql.append("set descricao = ?");
		sql.append("where codigo = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1,f.getDescricao());
		comando.setLong(2, f.getCodigo());
		comando.executeUpdate();
	}
	

	
	public static void main(String [] args) {
		
		//TESTE PARA ADICIONAR
		//Fornecedores f1 = new Fornecedores();
		//f1.setDescricao("Descrição 3");
		
		//Fornecedores f2 = new Fornecedores();
		//f2.setDescricao("Descrição 4");
		
		//FornecedoresDAO fdao= new FornecedoresDAO();
		
		//try {
			//fdao.salvar(f1);
			//fdao.salvar(f2);
			//System.out.println("Dados Salvos Com Sucesso!!!");
		//}
		//catch (SQLException e){
			//System.out.println("Erro ao salvar os dados!!!");
			//e.printStackTrace();
		//}
		
		//TESTE PARA EXCLUIR
		//Fornecedores f1 = new Fornecedores();
		//f1.setCodigo(2L);
		//FornecedoresDAO fdao = new FornecedoresDAO();
		
		//try {
			//fdao.excluir(f1);
			
			//System.out.println("Deletado Com Sucesso!!!");
			
		//}
	    //catch(SQLException e) {
	    	//System.out.println("Erro ao deletar!!!");
	    	//e.printStackTrace();
	    //}
		
		//TESTE EDITAR
		//Fornecedores f1 = new Fornecedores();
		//f1.setCodigo(1L);
		//f1.setDescricao("Desc ALterada");
		//FornecedoresDAO fdao = new FornecedoresDAO();
		
		//try {
			//fdao.editar(f1);
			
			//System.out.println("Alterado Com Sucesso!!!");
			
		//}
	    //catch(SQLException e) {
	    	//System.out.println("Erro ao Alterar!!!");
	    	//e.printStackTrace();
	    //}
		
		//TESTE BUSCA POR CODIGO
		Fornecedores f1 = new Fornecedores();
		f1.setCodigo(1L);
				
		Fornecedores f2 = new Fornecedores();
		f2.setCodigo(5L);
				
		FornecedoresDAO fdao= new FornecedoresDAO();
				
		try {
			    Fornecedores f3 = fdao.buscaPorCodigo(f1);
			    Fornecedores f4 = fdao.buscaPorCodigo(f2);
			    System.out.println("Resultado 1:  " +f3);
			    System.out.println("Resultado 2:  " +f4);
			}
		catch (SQLException e){
				System.out.println("Erro ao buscar os dados!!!");
				e.printStackTrace();
		}	
	}
}
