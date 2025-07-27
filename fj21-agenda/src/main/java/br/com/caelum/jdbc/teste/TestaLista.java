package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {
	
	public static void main (String[] args) {
		
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		for (Contato contato : contatos) {
			 String dataFormatada = sdf.format(contato
                     .getDataNascimento()
                     .getTime());
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " + dataFormatada);
		}
	}
}
