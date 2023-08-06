package br.com.caelum.jdbc.models.DAO;

import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnFactory;
import br.com.caelum.jdbc.models.Contatos;

public class ContatoDao {

	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnFactory().getConnection();
		System.out.println("Conectado com sucesso.");
	}
	
	public void adiciona(Contatos contato) {
		String sql = "insert into contatos "+ 
		"(nome,email,endereco,dataNascimento)"+
		"values (?,?,?,?)";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			
			long dataEmMiliseg = contato.getDataNascimento().getTimeInMillis();
			java.sql.Date dataSql = new java.sql.Date(dataEmMiliseg);
			
			stmt.setDate(4, dataSql);
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public List<Contatos> busca()throws SQLException{
		try {
			List<Contatos> contatos = new ArrayList<Contatos>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Contatos ctt = new Contatos();
				ctt.setId(rs.getLong("id"));
				ctt.setNome(rs.getString("nome"));
				ctt.setEmail(rs.getString("email"));
				ctt.setEndereco("endereco");
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				ctt.setDataNascimento(data);
				
				contatos.add(ctt);
			}
			
			rs.close();
			stmt.close();
			
			return contatos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
