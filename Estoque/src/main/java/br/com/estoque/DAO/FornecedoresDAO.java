package br.com.estoque.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
	
	public ArrayList<Fornecedores> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("Select codigo, descricao ");
		sql.append("from fornecedores ");
		sql.append("order by descricao asc ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Fornecedores>lista= new ArrayList<Fornecedores>();
		
		while(resultado.next()) {

			Fornecedores f = new Fornecedores();
			f.setCodigo(resultado.getLong("codigo"));
			f.setDescricao(resultado.getString("descricao"));
			
			lista.add(f);
		}
		return lista;
	}
	
	public ArrayList<Fornecedores>buscaPorDescricao (Fornecedores f) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("select codigo, descricao ");
		sql.append("select fornecedores ");
		sql.append("where descricao like ? ");
		sql.append("order by descricao asc ");
		
        Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, "%" + f.getDescricao() + "%");
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Fornecedores>lista= new ArrayList<Fornecedores>();
		
		while(resultado.next()) {

			Fornecedores item = new Fornecedores();
			f.setCodigo(resultado.getLong("codigo"));
			f.setDescricao(resultado.getString("descricao"));
			
			lista.add(f);
		}
		return lista;
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
	
	/*Fornecedores f1 = new Fornecedores();
	 * f1.setDescricao("Alt");
	 * FornecedoresDAO fdao = new FornecedoresDAO();
	 * try{
	 *     ArrayList<Fornecedores>lista = fdao.buscarPorDescricao(f1);
	 *     
	 *     for(Fornecedores f : lista){
	 *         System.out.println("Resultado: " + f);
	 *     }
	 * }
	 * catch (SQLException e) {
	 *     System.out.println("Erro ao buscar os dados");
	 *     e.printStackTrace();
	 * }
	 */

	
	
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
		//FornecedoresDAO fdao= new FornecedoresDAO();
				
		//try {

			//ArrayList<Fornecedores>lista = fdao.listar();
			//for(Fornecedores f : lista) {
				//System.out.println("Resultado + " + f);
			//}
			//}
		//catch (SQLException e){
				//System.out.println("Erro ao buscar os dados!!!");
				//e.printStackTrace();
		
		
		//TESTAR BUSCAR FORNCEDORES POR CODIGO--------------------------------
		Fornecedores f1 = new Fornecedores();
		f1.setDescricao("src");
		FornecedoresDAO fdao = new FornecedoresDAO();
		
		try {
			ArrayList<Fornecedores>lista = fdao.listar();
			
			for(Fornecedores f : lista) {
				System.out.println("Resultado + " + f);
			}
		}catch (SQLException e){
			System.out.println("Erro ao buscar os dados!!!");
			e.printStackTrace();
		
		
		}	
	}
}

