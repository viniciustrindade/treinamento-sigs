package br.com.treinamento.jdbc.teste;

import java.util.List;

import br.com.treinamento.jdbc.dao.FuncionarioDao;
import br.com.treinamento.modelo.Funcionario;

public class TestarFuncionarioR {

	public static void main(String[] args) {

		FuncionarioDao dao = new FuncionarioDao();

		// listar funcionarios
		System.out.println("Listando funcionarios");
		List<Funcionario> funcionarios = dao.listarFuncionarios();
		for (Funcionario f : funcionarios) {
			System.out.println("ID: " + f.getId() + " Nome: " + f.getNome() + " - " + "Usuario: " + f.getUsuario());
		}

	}

}
