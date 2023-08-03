package br.com.treinamento.jdbc.teste;

import java.util.Calendar;

import br.com.treinamento.jdbc.dao.ContatoDao;
import br.com.treinamento.modelo.Contato;

public class TestaAtualizar {

	public static void main(String[] args) {

		Contato contatoNovo = new Contato();
		
		contatoNovo.setNome("Homem de Ferro");
		contatoNovo.setEmail("homem.ferro@ufba.br");
		contatoNovo.setEndereco("Stark, 1000, EUA");
		contatoNovo.setDataNascimento(Calendar.getInstance());
		contatoNovo.setId(8L);
		
		ContatoDao dao = new ContatoDao();
		
		dao.alterar(contatoNovo);
		
		System.out.println("Dados atualizados");

	}

}
