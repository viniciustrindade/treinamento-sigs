package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {

	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {

		String sql = "insert	into	contatos	" + "(nome,email,endereco,dataNascimento)" + "	values	(?,?,?,?)";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Contato contato) {

		String sql = "update	contatos	set	nome=?,	email=?," + "endereco=?,	dataNascimento=?	where	id=?";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Contato contato) {

		try {

			PreparedStatement stmt = connection.prepareStatement("delete	from	contatos	where	id=?");

			stmt.setLong(1, contato.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Contato pesquisar(int id) {

		try {

			Contato contato = new Contato();

			PreparedStatement stmt = this.connection.prepareStatement("select	*	from	contatos where id = ?");

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

			}

			rs.close();
			stmt.close();

			return contato;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista(String pesquisa) {

		try {

			List<Contato> contatos = new ArrayList<Contato>();

			PreparedStatement stmt;

			if (pesquisa.equals("")) {
				stmt = this.connection.prepareStatement("select * from contatos");
			} else {
				stmt = this.connection.prepareStatement("select * from contatos where nome like ?");
				stmt.setString(1, "%" + pesquisa + "%");
			}

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}

			rs.close();
			stmt.close();

			return contatos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista() {
		return getLista("");
	}
}