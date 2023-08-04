package br.com.caelum.jdbc.teste;

import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaContato {

	public static void main(String[] args) {
		
		// Cria um novo contato
		Contato caelum = new Contato();
		
		caelum.setNome("Caelum");
		caelum.setEmail("contato@caelum.com.br");
		caelum.setEndereco("R. Vergueiro 3185 cj57");
		caelum.setDataNascimento(Calendar.getInstance());
		
		// Cria outro contato
		Contato alex = new Contato();
		
		alex.setNome("Alex");
		alex.setEmail("alex@email.com.br");
		alex.setEndereco("R. dos Bobos, n 0");
		alex.setDataNascimento(Calendar.getInstance());
		
		// Cria um objeto de manipulação da base de dados
		ContatoDao contatoDAO = new ContatoDao();
		
		// Persiste as informações na base de dados 
		contatoDAO.adiciona(caelum);
		contatoDAO.adiciona(alex);
		
		// Exbibe todos contatos
		System.out.println("Lista de todos contatos");
		exbibeContatos();
		System.out.println();
		
		// Exbibe todos contatos que contenha "x"
		System.out.println("Lista de contatos que contenha a letra x no nome");
		exbibeContatos("x");
		System.out.println();
		
		// Pesquisa pelo contato de id = 2
		Contato contatoPesquisado = contatoDAO.pesquisar(2);
		
		// Modifica a informação
		contatoPesquisado.setNome("Alex A. D. dos Santos");
		contatoPesquisado.setEmail("alex.divino@ufba.br");
		
		// Persiste as alterações na base de dados
		contatoDAO.altera(contatoPesquisado);		
		
		// Exbibe todos contatos
		System.out.println("Lista de contatos pós update");
		exbibeContatos();
		System.out.println();
		
		// Deleta o contato pesquisado
		contatoDAO.remove(contatoPesquisado);
		
		// Exbibe todos contatos
		System.out.println("Lista de contatos pós delete");
		exbibeContatos();
		System.out.println();
	}
	
	public static void exbibeContatos(String filtro) {

		ContatoDao dao = new ContatoDao();

		List<Contato> contatos = dao.getLista(filtro);

		long count = 0;

		for (Contato contato : contatos) {
			System.out.print(++count);
			System.out.print(" - ");
			System.out.print(contato);
			System.out.println();
		}
	}
	
	public static void exbibeContatos() {
		exbibeContatos("");
	}

}
