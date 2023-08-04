package br.com.treinamento.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.treinamento.jdbc.ConnectionFactory;
import br.com.treinamento.modelo.Funcionario;

public class FuncionarioDao {

	private Connection conection;

	public FuncionarioDao() {
		this.conection = new ConnectionFactory().getConnection();
	}

	public void adicionar(Funcionario funcionario) {
		String sql = "INSERT INTO funcionario_samuel" + " (nome,usuario,senha)" + " VALUES (?,?,?)";
		try {

			PreparedStatement stmt = conection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());

			stmt.execute();
			stmt.close();
			System.out.println("Dados gravados");
			conection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao gravar");
		}
	}

	public List<Funcionario> listarFuncionarios() {
		String sql = "SELECT * FROM funcionario_samuel";
		Connection conn = new ConnectionFactory().getConnection();
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultaSet = stmt.executeQuery();

			while (resultaSet.next()) {

				Funcionario funcionario = new Funcionario();

				funcionario.setId(resultaSet.getLong("id"));
				funcionario.setNome(resultaSet.getString("nome"));
				funcionario.setUsuario(resultaSet.getString("usuario"));
				funcionario.setSenha(resultaSet.getString("senha"));

				funcionarios.add(funcionario);
			}

			resultaSet.close();
			stmt.close();
			conn.close();

			return funcionarios;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao fechar a conexao ou ");
		}
	}

	public void alterar(Funcionario funcionario) {

		String sql = "UPDATE funcionario_samuel SET nome=?,usuario=?,senha=? WHERE id=?";
		Connection conn = new ConnectionFactory().getConnection();

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(4, funcionario.getId());

			stmt.execute();
			stmt.close();
			conn.close();
			System.out.println("Dados atualizado");
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao Atualizar");
		}
	}

	public void remover(Long id) {
		
		String sql = "DELETE FROM funcionario_samuel WHERE id=?";
		Connection conn = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1, id);
			
			stmt.execute();
			stmt.close();
			conn.close();
			System.out.println("Dado removido");
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao Remover");
		}

	}
}












