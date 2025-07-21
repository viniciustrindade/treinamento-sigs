package testes;

import java.util.Calendar;

import dao.ContatoDao;
import modelo.Contato;

public class TestaAlterar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ContatoDao dao = new ContatoDao();
		
		Contato	contato	=	new	Contato();
		
		contato.setNome("Marcos");
		contato.setEmail("marcos@ufba.br");
		contato.setEndereco("Av Anita Garibaldi s/n");
		contato.setDataNascimento(Calendar.getInstance());
		contato.setId(1);
		
		dao.alterar(contato);
		
		System.out.println("Contato alterado!");

	}

}
