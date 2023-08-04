package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		
		Contato pesquisarContato = dao.pesquisar(1);
		imprimirContato(pesquisarContato);
		
		pesquisarContato.setNome("Carlos");
		dao.altera(pesquisarContato);
		
		pesquisarContato = dao.pesquisar(1);
		imprimirContato(pesquisarContato);
		
		dao.remove(pesquisarContato);
		
		List<Contato> contatos = dao.getLista();
		
		for (Contato contato : contatos) {
			imprimirContato(contato);
		}
	}
	
	public static void imprimirContato (Contato contato) {
		System.out.println("Nome: " + contato.getNome());
		System.out.println("Email: " + contato.getEmail());
		System.out.println("Endereço: " + contato.getEndereco());
		
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		String dataNasc = fmt.format(contato.getDataNascimento().getTime());

		System.out.println("Data de Nascimento: " + dataNasc + "\n");
	}
}
