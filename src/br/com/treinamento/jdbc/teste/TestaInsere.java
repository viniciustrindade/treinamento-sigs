package br.com.treinamento.jdbc.teste;

import java.util.Calendar;

import br.com.treinamento.jdbc.dao.ContatoDao;
import br.com.treinamento.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {

		Contato contato = new Contato();
		
		contato.setNome("Vegeta");
		contato.setEmail("vegeta@ufba.br");
		contato.setEndereco("federacao-salvador-bahia");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.adicionar(contato);
		
		System.out.println("Gravado");

	}

}
