package br.com.caelum.jdbc.teste;

import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;


public class TestaLista {
	public static void main(String args[]) {
		ContatoDao dao = new ContatoDao();
		
		List<Contato> contatos = dao.getLista();
		for (Contato contato : contatos) {
			System.out.println(contato);
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			// Poderia usar um SimpleDateFormat
			System.out.println("Data de nascimento: " + 
						contato.getDataNascimento().getTime() + "\n");
		}
	}
}
