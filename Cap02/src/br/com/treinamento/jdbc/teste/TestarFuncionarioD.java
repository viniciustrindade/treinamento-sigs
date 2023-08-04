package br.com.treinamento.jdbc.teste;

import br.com.treinamento.jdbc.dao.FuncionarioDao;

public class TestarFuncionarioD {

	public static void main(String[] args) {

		FuncionarioDao dao = new FuncionarioDao();

		// removendo usuario
		System.out.println("Removendo funcionario");

		dao.remover(5L);
		System.out.println("Funcionario removido");

	}

}
