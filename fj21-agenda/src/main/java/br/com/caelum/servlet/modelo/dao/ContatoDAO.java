package br.com.caelum.servlet.modelo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.servlet.ConnectionFactory;
import br.com.caelum.servlet.modelo.Contato;
import br.com.caelum.servlet.modelo.dao.exceptions.DAOException;

public class ContatoDAO {
//	SimpleDateFormat sdf= new SimpleDateFormat();

	private Connection connection;

	public ContatoDAO() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "insert	into contatos" + "(nome,email,endereco,dataNascimento)" + "values(?,?,?,?)";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

	}

	public List<Contato> getLista() {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where nome like 'C%'");
			List<Contato> contatos = new ArrayList<Contato>();
			ResultSet resultados = stmt.executeQuery();
			while (resultados.next()) {
				Contato contato = new Contato();
				contato.setNome(resultados.getString("nome"));
				contato.setId(resultados.getLong("id"));
				contato.setEmail(resultados.getString("email"));
				Calendar data = Calendar.getInstance();

				data.setTime(resultados.getDate("dataNascimento"));

				contato.setDataNascimento(data);
				contato.setEndereco(resultados.getString("endereco"));
				contatos.add(contato);

			}
			resultados.close();
			stmt.close();
			return contatos;

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

	}

	public Contato pesquisa(int id) {
		// Integer.toString(id);
		String sql = "select * from contatos where id=?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet resultados = stmt.executeQuery();

			Contato contato = new Contato();
			while (resultados.next()) {

				contato.setNome(resultados.getString("nome"));
				contato.setId(resultados.getLong("id"));
				contato.setEmail(resultados.getString("email"));
				Calendar data = Calendar.getInstance();

				data.setTime(resultados.getDate("dataNascimento"));

				contato.setDataNascimento(data);
				contato.setEndereco(resultados.getString("endereco"));

			}
			resultados.close();
			stmt.close();
			return contato;

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

	}

	public void alterar(Contato contato, int id) {

		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=?" + " where id=?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

	public void deletar(int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete	from	contatos	where	id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
			System.out.println("deleção feita com sucesso!");
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	
}
