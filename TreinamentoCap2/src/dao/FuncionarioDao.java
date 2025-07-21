package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.Conexao;
import modelo.Funcionario;

public class FuncionarioDao {
	
	private	Connection	connection;
	
	public FuncionarioDao() {
			this.connection	=	new	Conexao().getConnection();
	}
	
	public void adicionar(Funcionario funcionario) {
		
		String sql = "insert into funcionarios "+ "(nome, usuario, senha)" + 
		" values(?, ?, ?)";
		
		try	{

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1,funcionario.getNome());
			stmt.setString(2,funcionario.getUsuario());
			stmt.setString(3,funcionario.getSenha());

			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Funcionario> buscarTodos(){
		
		try {
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			
			PreparedStatement stmt = connection.prepareStatement("select * from funcionarios");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
			}	
			
			rs.close();
			stmt.close();
			
			return funcionarios;
			
		} catch	(SQLException e) {
			throw new RuntimeException(e);
		}				
	}
	
	public Funcionario buscarPorID(long id) {
		
		try {
			 Funcionario funcionario = new Funcionario();
			
			PreparedStatement stmt = connection.prepareStatement("select * from funcionarios where id = ?");
			
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
						
				rs.close();
				stmt.close();
				return funcionario;
				
			} else {
			    System.out.println("ID não foi encontrado.");
			    return null;
			}
			
		} catch	(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Funcionario funcionario) {
		 
		String sql = "update funcionarios set nome=?, usuario=?, senha=?," + " where id=?";
			
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
				
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(4,	funcionario.getId());
				
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remover(long id) {
		
		try	{ 
			PreparedStatement stmt = connection.prepareStatement("delete from funcionarios where id=?");
			
			stmt.setLong(1, id);
	        
			int linhasAfetadas = stmt.executeUpdate();
			
			if(linhasAfetadas!= 0) {
				System.out.println("Funcionario deletado!");
			} else { 
				System.out.println("Funcionario não encontrado");
			}

			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
