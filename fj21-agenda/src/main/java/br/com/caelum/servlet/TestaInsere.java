package br.com.caelum.servlet;

import java.util.Calendar;

public class TestaInsere {
	public static void main(String args[]) {
		Contato contato = new Contato();
		contato.setNome("Mauricio");
		contato.setEmail("mauriciomatchal@gmail.com");
		contato.setEndereco("Salvador, Imbui");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.adiciona(contato);
		
		System.out.println("Inseriu.");
	}
}
