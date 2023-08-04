package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaFuncionario {

	public static void main(String[] args) {
		//inserindo
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Maria");
		funcionario.setUsuario("maria");
		funcionario.setSenha("123");

		FuncionarioDao dao = new FuncionarioDao();
		dao.adiciona(funcionario);
		System.out.println("Gravado!");
		
		//alterando
		List<Funcionario> funcionarios = dao.getLista();
		funcionario = funcionarios.get(funcionarios.size()-1);
		
		funcionario.setNome("Maria Souza");
		dao.altera(funcionario);
		
		funcionarios = dao.getLista();
		
		for (Funcionario funcionarioAtual : funcionarios) {
			imprimirFuncionario(funcionarioAtual);
		}
		System.out.println("Alterado!");
	
		//removendo
		dao.remove(funcionario);
		
		funcionarios = dao.getLista();
		
		for (Funcionario funcionarioAtual : funcionarios) {
			imprimirFuncionario(funcionarioAtual);
		}
		System.out.println("Removido!");
	}
	
	public static void imprimirFuncionario (Funcionario funcionario) {
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("Usuario: " + funcionario.getUsuario());
		System.out.println("Senha: " + funcionario.getSenha() + "\n");
	}

}
