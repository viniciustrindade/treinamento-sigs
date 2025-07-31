package br.com.treinamento.servlet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.treinamento.servlet.Connectionfactory;
import br.com.treinamento.servlet.Contato;

public class ContatoDAO {
	private Connection connection;
	
	
	public ContatoDAO() {
		this.connection = new Connectionfactory().getConnection();
		}
	

	public void adiciona(Contato contato) {
		String sql = "INSERT INTO contatos " +
		"(nome,email,endereco,dataNascimento)" +
		" values (?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4, new Date(
			contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			connection.close();
			System.out.println("Dados Gravados");
		} catch (SQLException e) {
			throw new RuntimeException
			("Falha ao gravar os dados");
			}
		}

	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.
			prepareStatement("SELECT * FROM contatos");
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
	
	public void altera(Contato contato) {
		String sql = "update contatos set nome=?, email=?,"+
		"endereco=?, dataNascimento=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
				.getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
			}
		}
	//Método de remover contato por id
	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = connection.prepareStatement
			("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
			}
	}

	
}
