package br.com.caelum.servlet.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.servlet.ConnectionFactory;
import br.com.caelum.servlet.modelo.Contato;
import br.com.caelum.servlet.modelo.Funcionario;
import br.com.caelum.servlet.modelo.dao.ContatoDAO;
import br.com.caelum.servlet.modelo.dao.FuncionarioDAO;

public class TesteConexao { 

	public static void main(String[] args) throws SQLException{
		
		Connection	connection	=	new	ConnectionFactory().getConnection();
		System.out.println("Conexão	aberta!");
		connection.close();
		
		//Gravar novo contato no banco de dados
		Contato	contato	=	new	Contato();
		contato.setNome("Caelum");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("R.	Vergueiro	3185	cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO dao= new ContatoDAO();
		
		//Adicionando contato
		dao.adiciona(contato);
		System.out.println("Gravado");
		Funcionario funcionario = new Funcionario();
		FuncionarioDAO daoFuncionario=new FuncionarioDAO();	
		funcionario.setNome("Paulo Henrique");
		funcionario.setUsuario("PH");
		funcionario.setSenha("123a");
		daoFuncionario.adiciona(funcionario);
	}
	
	

}
