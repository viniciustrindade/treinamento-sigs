package br.com.treinamento.jdbc.teste;

import java.util.List;

import br.com.treinamento.jdbc.dao.FuncionarioDao;
import br.com.treinamento.modelo.Funcionario;

public class TestarFuncionarioCRUD {

	public static void main(String[] args) {

		Funcionario funcionario = new Funcionario();
		FuncionarioDao dao = new FuncionarioDao();

		// inserindo funcionario
		funcionario.setNome("capitao america");
		funcionario.setUsuario("guerraInfinita");
		funcionario.setSenha("12345");

		dao.adicionar(funcionario);

		System.out.println("Dados inseridos");

		// listar funcionarios
		System.out.println("Listando funcionarios");
		List<Funcionario> funcionarios = dao.listarFuncionarios();
		for (Funcionario f : funcionarios) {
			System.out.println("Nome: " + f.getNome() + " - " + "Usuario: " + f.getUsuario());
		}

		// atualizar funcionario
		System.out.println("Atualizando funcionario");
		
		Funcionario funcionarioUpdate = new Funcionario();
		funcionarioUpdate.setNome("Samuel");
		funcionarioUpdate.setUsuario("samuel.farias");
		funcionarioUpdate.setSenha("9876543210");
		funcionarioUpdate.setId(3L);
		
		dao.alterar(funcionarioUpdate);
		System.out.println("Dados alterados");

		// removendo usuario
		System.out.println("Removendo funcionario");
		
		dao.remover(2L);
		System.out.println("Funcionario removido");

	}

}
