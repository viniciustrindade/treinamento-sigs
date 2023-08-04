package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.modelo.dao.ContatoDAO;

public class TestaDeletar {

	public static void main(String[] args) {
			
		
		ContatoDAO dao=new ContatoDAO();
		int id=2;
		dao.deletar(id);
		

	}

}
