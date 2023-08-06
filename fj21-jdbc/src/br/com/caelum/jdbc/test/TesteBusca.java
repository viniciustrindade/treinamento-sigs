package br.com.caelum.jdbc.test;


import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.models.Contatos;
import br.com.caelum.jdbc.models.DAO.*;
public class TesteBusca {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ContatoDao ctt = new ContatoDao();
		List<Contatos> listaCtt = ctt.busca();
		
		for(Contatos elemento: listaCtt) {
			String nome = elemento.getNome();
			System.out.println(nome);
		}
	}

}
