package Testes;

import DAO.ContatoDAO;
import br.com.treinamento.Contato;

public class TesteRemove {
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setId(1L);
		ContatoDAO dao = new ContatoDAO();
		dao.remove(contato);
		System.out.println("Contato teste removido");
	}
}
