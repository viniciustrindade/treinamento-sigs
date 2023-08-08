package br.com.caelum.servlet.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.servlet.ConnectionFactory;
import br.com.caelum.servlet.model.exceptions.DAOException;
import br.com.caelum.servlet.modelo.Funcionario;

public class FuncionarioDAO {
//	SimpleDateFormat sdf= new SimpleDateFormat();

	private Connection connection;

	public FuncionarioDAO() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Funcionario funcionario) {
		String sql = "insert	into funcionarios" + "(nome,usuario,senha)" + "values(?,?,?)";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

	}

	public List<Funcionario> getLista() {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from funcionarios");
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			ResultSet resultados = stmt.executeQuery();
			while (resultados.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(resultados.getString("nome"));
				funcionario.setId(resultados.getLong("id"));
				funcionario.setUsuario(resultados.getString("usuario"));
				Calendar data = Calendar.getInstance();

			

			
				funcionario.setSenha(resultados.getString("senha"));
				funcionarios.add(funcionario);

			}
			resultados.close();
			stmt.close();
			return funcionarios;

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

	}
	public List<Funcionario> getFuncionarioComwhere() {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from funcionarios where nome like 'C%'");
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			ResultSet resultados = stmt.executeQuery();
			while (resultados.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(resultados.getString("nome"));
				funcionario.setId(resultados.getLong("id"));
				funcionario.setUsuario(resultados.getString("usuario"));
				Calendar data = Calendar.getInstance();

			

			
				funcionario.setSenha(resultados.getString("senha"));
				funcionarios.add(funcionario);

			}
			resultados.close();
			stmt.close();
			return funcionarios;

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

	}
	
	
	

	public Funcionario pesquisa(int id) {
		// Integer.toString(id);
		String sql = "select * from funcionarios where id=?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet resultados = stmt.executeQuery();

			Funcionario funcionario = new Funcionario();
			while (resultados.next()) {

				funcionario.setNome(resultados.getString("nome"));
				funcionario.setId(resultados.getLong("id"));
				funcionario.setUsuario(resultados.getString("usuario"));
				
				funcionario.setSenha(resultados.getString("senha"));

			}
			resultados.close();
			stmt.close();
			return funcionario;

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

	}

	public void alterar(Funcionario funcionario, int id) {

		String sql = "update funcionarios set nome=?, usuario=?, senha=?" + " where id=?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(5, funcionario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

	public void deletar(int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete	from	funcionarios	where	id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
			System.out.println("deleção feita com sucesso!");
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

}
