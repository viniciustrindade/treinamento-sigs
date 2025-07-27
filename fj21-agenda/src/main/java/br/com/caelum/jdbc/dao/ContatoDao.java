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
		String sql = "insert into contatos " +
				"(nome,email,endereco,dataNascimento)" +
				" values (?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
				
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException("Erro ao adicionar contato", e);
		}
	}
	
	public List<Contato> getLista() {
	    try {
	        List<Contato> contatos = new ArrayList<Contato>();
	        PreparedStatement stmt = this.connection.
	        		prepareStatement("SELECT * FROM contatos");
	        ResultSet rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            contatos.add(descricaoContato(rs));
	        }
	        
	        rs.close();
	        stmt.close();
	        return contatos;
	    } catch (SQLException e) {
	        throw new DAOException("Erro ao listar contatos", e);
	    }
	}
	
	public List<Contato> buscarPorNome(String abreviado) {
		 try {
		        List<Contato> contatos = new ArrayList<Contato>();
		        PreparedStatement stmt = this.connection.
		        		prepareStatement("SELECT * FROM contatos WHERE nome LIKE ?");
		        stmt.setString(1, abreviado + "%");
		        ResultSet rs = stmt.executeQuery();
		        
		        while (rs.next()) {
		            contatos.add(descricaoContato(rs));
		        }
		        
		        rs.close();
		        stmt.close();
		        return contatos;
		    } catch (SQLException e) {
		        throw new DAOException("Erro ao buscar por nome", e);
		    }
	}
	
	public List<Contato> pesquisar(Long id) {
		 try {
		        List<Contato> contatos = new ArrayList<Contato>();
		        PreparedStatement stmt = this.connection.
		        		prepareStatement("SELECT * FROM contatos WHERE id = ?");
		        stmt.setLong(1, id);
		        ResultSet rs = stmt.executeQuery();
		        
		        while (rs.next()) {
		            contatos.add(descricaoContato(rs));
		        }
		        
		        rs.close();
		        stmt.close();
		        return contatos;
		    } catch (SQLException e) {
		        throw new DAOException("Erro ao buscar por id", e);
		    }
	}
	
	private Contato descricaoContato(ResultSet rs) throws SQLException {
		Contato contato = new Contato();
        contato.setId(rs.getLong("id"));
        contato.setNome(rs.getString("nome"));
        contato.setEmail(rs.getString("email"));
        contato.setEndereco(rs.getString("endereco"));
        
        Calendar data = Calendar.getInstance();
        data.setTime(rs.getDate("dataNascimento"));
        contato.setDataNascimento(data);
        
        return contato;
	}
	
	
	public void altera(Contato contato) {
	    String sql = "UPDATE contatos SET nome=?, email=?, endereco=?, dataNascimento=? WHERE id=?";
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
	        PreparedStatement stmt = connection.prepareStatement("DELETE FROM contatos WHERE id=?");
	        stmt.setLong(1, contato.getId());
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
}
