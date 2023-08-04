package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) {

		ContatoDao dao = new ContatoDao();

		List<Contato> contatos = dao.getLista();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		long count = 0;

		for (Contato contato : contatos) {
			System.out.print(++count);
			System.out.print(" - ");
			System.out.print("Nome: " + contato.getNome());
			System.out.print(" | ");
			System.out.print("Email: " + contato.getEmail());
			System.out.print(" | ");
			System.out.print("Endereço: " + contato.getEndereco());
			System.out.print(" | ");
			System.out.print("Data de Nascimento: " + sdf.format(contato.getDataNascimento().getTime()) + "\n");
			System.out.println();
		}

	}

}
