package br.com.treinamento.servlet.conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.treinamento.servlet.modelo.Contato;

public class ContatoDao {

	
	private Connection conection;
	List<Contato> contatos = new ArrayList<Contato>();

	public ContatoDao() {
		this.conection = new ConnectionFactory().getConnection();
	}

	public void adicionar(Contato contato) {
		String sql = "INSERT INTO contatos_samuel" + " (nome,email,endereco,dataNascimento)" + " VALUES (?,?,?,?)";
		try {

			PreparedStatement stmt = conection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();
			System.out.println("Dados gravados");
			conection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao gravar");
		} 

		
		System.out.println("Chamou o DAO - INICIO");
		
		System.out.println("Nome: " + contato.getNome() + "\n");
		System.out.println("Email: " + contato.getEmail() + "\n");
		System.out.println("Endereco: " + contato.getEndereco() + "\n");
		System.out.println("Data de nascimento: " + contato.getDataNascimento());
		
		System.out.println("Chamou o DAO - FIM");
		
	}

	public List<Contato> listarContatos() {
		String sql = "SELECT * FROM contatos_samuel";
		Connection conn = new ConnectionFactory().getConnection();
		List<Contato> contatos = new ArrayList<Contato>();

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultaSet = stmt.executeQuery();

			while (resultaSet.next()) {

				Contato contato = new Contato();

				contato.setId(resultaSet.getLong("id"));
				contato.setNome(resultaSet.getString("nome"));
				contato.setEmail(resultaSet.getString("email"));
				contato.setEndereco(resultaSet.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(resultaSet.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}

			resultaSet.close();
			stmt.close();
			conn.close();

			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao fechar a conexao ou ");
		}
	}

	public Contato buscaPorId(Long id) {

		String sql = "SELECT * FROM contatos_samuel WHERE id =?";// + id;
		Connection conn = new ConnectionFactory().getConnection();
		Contato contato = new Contato();

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet resultaSet = stmt.executeQuery();

			if (resultaSet.next()) {

				contato.setId(resultaSet.getLong("id"));
				contato.setNome(resultaSet.getString("nome"));
				contato.setEmail(resultaSet.getString("email"));
				contato.setEndereco(resultaSet.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(resultaSet.getDate("dataNascimento"));
				contato.setDataNascimento(data);

			}

			resultaSet.close();
			stmt.close();
			conn.close();

			return contato;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar por ID ou fechar conexao");
		}

	}

	public List<Contato> buscaPorNome(String nome) {

		String sql = "SELECT * FROM contatos_samuel WHERE nome LIKE ?";
		Connection conn = new ConnectionFactory().getConnection();
		List<Contato> contatos = new ArrayList<Contato>();

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet resultaSet = stmt.executeQuery();

			while (resultaSet.next()) {
				Contato contato = new Contato();
				contato.setId(resultaSet.getLong("id"));
				contato.setNome(resultaSet.getString("nome"));
				contato.setEmail(resultaSet.getString("email"));
				contato.setEndereco(resultaSet.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(resultaSet.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);

			}

			resultaSet.close();
			stmt.close();
			conn.close();

			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar por nome ou fechar conexao");
		}

	}

	public void alterar(Contato contato){

		String sql = "UPDATE contatos_samuel SET nome=?,email=?,endereco=?,dataNascimento=? WHERE id=?";
		Connection conn = new ConnectionFactory().getConnection();
		 
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			
			stmt.execute();
			stmt.close();
			conn.close();
			System.out.println("Dados atualizado");
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao Atualizar");
		}
	}

	
	public void remover(Long id){

		String sql = "DELETE FROM contatos_samuel WHERE id=?";
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

	public List<Contato> getContatos() {
		return listarContatos();
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
}
