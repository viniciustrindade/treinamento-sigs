package br.com.treinamento.mvc.conexao;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) {
			
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexao aberta");
		try {
			connection.close();
			System.out.println("Conexao fechada");
		} catch (SQLException e) {
			throw new RuntimeException("Erro no fechamento da conexao");
		}
	}

}
