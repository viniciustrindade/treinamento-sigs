//		Contatos ctt = new Contatos();
//		
//		java.util.Date utilDate = new java.util.Date();
//	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//	    System.out.println("utilDate:" + utilDate);
//	    System.out.println("sqlDate:" + sqlDate);

package br.com.caelum.jdbc.test;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.models.Contatos;
import br.com.caelum.jdbc.models.DAO.ContatoDao;

public class TesteContato {

	public static void main(String[] args) throws SQLException {
		Contatos ctt = new Contatos();
		ctt.setNome("Marcelo");
		ctt.setEmail("marcelo@marcelo.com.br");
		ctt.setEndereco("R. xxxx num 000");
		ctt.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.adiciona(ctt);
		
		System.out.println("Gravado.");
		
	}

}
