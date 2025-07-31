package Testes;

import java.util.Calendar;

import DAO.ContatoDAO;
import br.com.treinamento.Contato;

public class TesteInsere {
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Caelum");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("R. Vergueiro 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO dao = new ContatoDAO();
		
		dao.adiciona(contato);
		System.out.println("Gravado!");
	}
}
