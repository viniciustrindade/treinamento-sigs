package br.com.caelum.servlet.teste;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.servlet.modelo.Contato;
import br.com.caelum.servlet.modelo.Funcionario;
import br.com.caelum.servlet.modelo.dao.ContatoDAO;
import br.com.caelum.servlet.modelo.dao.FuncionarioDAO;

public class TestaLista {

	public static void main(String[] args) throws ClassNotFoundException {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataFormatada;
		ContatoDAO dao = new ContatoDAO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Contato> contatos = dao.getLista();

		List<Funcionario> funcionarios = funcionarioDAO.getLista();

		for (Contato contato : contatos) {
			System.out.println("Nome:" + contato.getNome());
			System.out.println("Email:" + contato.getEmail());

			dataFormatada = dateFormat.format(contato.getDataNascimento().getTime());

			System.out.println("Data	de	Nascimento:	" + dataFormatada + "\n");

			System.out.println("Endereço:" + contato.getEndereco());

		}
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome:" + funcionario.getNome());
			System.out.println("Email:" + funcionario.getUsuario());

			System.out.println("Endereço:" + funcionario.getSenha()+"\n");
			

		}
	}
}
