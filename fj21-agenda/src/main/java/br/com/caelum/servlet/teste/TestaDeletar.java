package br.com.caelum.servlet.teste;

import br.com.caelum.servlet.modelo.dao.ContatoDAO;

public class TestaDeletar {

	public static void main(String[] args) throws ClassNotFoundException {
			
		
		ContatoDAO dao=new ContatoDAO();
		int id=2;
		dao.deletar(id);
		

	}

}
