package testes;

import dao.ContatoDao;

public class TestaDeletar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContatoDao dao = new ContatoDao();
		
		dao.remover(2);
		
	}

}
