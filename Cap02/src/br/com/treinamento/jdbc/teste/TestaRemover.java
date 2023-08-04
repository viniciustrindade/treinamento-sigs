package br.com.treinamento.jdbc.teste;

import br.com.treinamento.jdbc.dao.ContatoDao;

public class TestaRemover {

	public static void main(String[] args) {


		ContatoDao dao = new ContatoDao();
		dao.remover(3L);
		System.out.println("Dados removidos");
		

	}

}
