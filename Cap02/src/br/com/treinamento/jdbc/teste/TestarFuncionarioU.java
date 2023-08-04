package br.com.treinamento.jdbc.teste;

import br.com.treinamento.jdbc.dao.FuncionarioDao;
import br.com.treinamento.modelo.Funcionario;

public class TestarFuncionarioU {

	public static void main(String[] args) {

		FuncionarioDao dao = new FuncionarioDao();

		// atualizar funcionario
		System.out.println("Atualizando funcionario");

		Funcionario funcionarioUpdate = new Funcionario();
		funcionarioUpdate.setNome("Samuel Lima de Farias");
		funcionarioUpdate.setUsuario("samuel.farias");
		funcionarioUpdate.setSenha("9876543210");
		funcionarioUpdate.setId(3L);

		dao.alterar(funcionarioUpdate);
		System.out.println("Dados alterados");

	}

}
