package br.com.estoque.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.*;
import javax.faces.model.ListDataModel;

import br.com.estoque.domain.Fornecedores;
import br.com.estoque.DAO.FornecedoresDAO;

public class FornecedoresBean {

	private ListDataModel<Fornecedores>itens;
	
	public ListDataModel<Fornecedores> getItens(){
		return itens;
	}
	
	public void setItens (ListDataModel<Fornecedores> itens) {
		this.itens = itens;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			ArrayList<Fornecedores> lista = fdao.listar();
			itens = new ListDataModel<Fornecedores>(lista);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
