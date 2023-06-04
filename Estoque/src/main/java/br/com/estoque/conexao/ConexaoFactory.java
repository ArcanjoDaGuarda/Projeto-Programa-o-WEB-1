package br.com.estoque.conexao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ConexaoFactory {
    
	
    //String serverName = "localhost:3306";  
    //String mydatabase = "test";  
    private static final String USUARIO = "root";
    private static final String SENHA = "kali";
    private static final String URL = "jdbc:mysql://localhost:3306/estoque";

    public static Connection conectar() throws SQLException{
    	    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            return conexao;
        }
    
    public static void main (String[] args) {
    	try {
    		Connection conexao = ConexaoFactory.conectar();
    		System.out.println("Conexao realizada com sucesso! ");
    	}
    	
    	catch(SQLException erro){
    		System.out.println("Erro ao conectar com o banco de dados:  " + erro);
    	}
    }
}
