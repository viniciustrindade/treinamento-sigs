package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.treinamento.Connectionfactory;
import br.com.treinamento.Contato;
import br.com.treinamento.Funcionario;

public class FuncionarioDAO {
		private Connection connection;

	public FuncionarioDAO() {
		this.connection = new Connectionfactory().getConnection();	
	}
	
	public void adiciona(Funcionario funcionario) {
		String sql = "INSERT INTO funcionario " +
		"(nome,usuario,senha)" +
		" values (?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,funcionario.getNome());
			stmt.setString(2,funcionario.getUsuario());
			stmt.setString(3,funcionario.getSenha());		
			stmt.execute();
			stmt.close();
			connection.close();
			System.out.println("Dados Gravados");
		} catch (SQLException e) {
			throw new RuntimeException
			("Falha ao gravar o Funcionario");
			}
		}
	public List<Funcionario> getLista() {
		try {
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			PreparedStatement stmt = this.connection.
			prepareStatement("SELECT * FROM funcionario");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
			
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
			
			
				funcionarios.add(funcionario);
				}
				rs.close();
				stmt.close();
		return funcionarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
			}
		}
	public void altera(Funcionario funcionario) {
		String sql = "update funcionario set nome=?, usuario=?,"+
		"senha=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(4, funcionario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
			}
		}
	public void remove(Funcionario funcionario) {
		try {
			PreparedStatement stmt = connection.prepareStatement
			("delete from funcionario where id=?");
			stmt.setLong(1, funcionario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
			}
	}
}
