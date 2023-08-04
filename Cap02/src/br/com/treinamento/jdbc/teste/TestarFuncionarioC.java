package br.com.treinamento.jdbc.teste;

import java.util.List;

import br.com.treinamento.jdbc.dao.FuncionarioDao;
import br.com.treinamento.modelo.Funcionario;

public class TestarFuncionarioC {

	public static void main(String[] args) {

		Funcionario funcionario = new Funcionario();
		FuncionarioDao dao = new FuncionarioDao();

		// inserindo funcionario
		funcionario.setNome("Hulk");
		funcionario.setUsuario("guerraInfinita");
		funcionario.setSenha("12345");

		dao.adicionar(funcionario);

		System.out.println("Dados inseridos");

	}

}
