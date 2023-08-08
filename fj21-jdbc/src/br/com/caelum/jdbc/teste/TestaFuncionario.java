package br.com.caelum.jdbc.teste;

import java.util.List;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaFuncionario {

	public static void main(String[] args) {
		
		// Cria um novo funcionario
		Funcionario caelum = new Funcionario();
		
		caelum.setNome("Caelum");
		caelum.setUsuario("caleum.santos");
		caelum.setSenha("12345");
		
		// Cria outro funcionario
		Funcionario alex = new Funcionario();
		
		alex.setNome("Alex");
		alex.setUsuario("alex.santos");
		alex.setSenha("54321");
		
		// Cria um objeto de manipulação da base de dados
		FuncionarioDao funcionarioDAO = new FuncionarioDao();
		
		// Persiste as informações na base de dados 
		funcionarioDAO.adiciona(caelum);
		funcionarioDAO.adiciona(alex);
		
		// Exbibe todos funcionarios
		System.out.println("Lista de todos funcionarios");
		exbibeFuncionarios();
		System.out.println();
		
		// Exbibe todos funcionarios que contenha "x"
		System.out.println("Lista de funcionarios que contenha a letra x no nome");
		exbibeFuncionarios("x");
		System.out.println();
		
		// Pesquisa pelo funcionario de id = 2
		Funcionario funcionarioPesquisado = funcionarioDAO.pesquisar(2);
		
		// Modifica a informação
		funcionarioPesquisado.setUsuario("alex.divino");
		
		// Persiste as alterações na base de dados
		funcionarioDAO.altera(funcionarioPesquisado);		
		
		// Exbibe todos funcionarios
		System.out.println("Lista de funcionarios pós update");
		exbibeFuncionarios();
		System.out.println();
		
		// Deleta o funcionario pesquisado
		funcionarioDAO.remove(funcionarioPesquisado);
		
		// Exbibe todos funcionarios
		System.out.println("Lista de funcionarios pós delete");
		exbibeFuncionarios();
		System.out.println();
	}
	
	public static void exbibeFuncionarios(String filtro) {

		FuncionarioDao dao = new FuncionarioDao();

		List<Funcionario> funcionarios = dao.getLista(filtro);

		long count = 0;

		for (Funcionario funcionario : funcionarios) {
			System.out.print(++count);
			System.out.print(" - ");
			System.out.print(funcionario);
			System.out.println();
		}
	}
	
	public static void exbibeFuncionarios() {
		exbibeFuncionarios("");
	}

}
