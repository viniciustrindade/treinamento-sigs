package br.com.caelum.jdbc.teste;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.modelo.dao.ContatoDAO;

public class TestaAlterar {

	public static void main(String[] args) {
		
		DateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataFormatada;
		Contato	contato	=	new	Contato();
		contato.setId(2L);
		contato.setNome("Paulo");
		contato.setEmail("Paulo@caelum.com.br");
		contato.setEndereco("R.	São jorge	22	cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO dao= new ContatoDAO();
		
		dao.alterar(contato, 1);
		
		Contato	contato2	=	new	Contato();
		
		contato2=dao.pesquisa(2);
		
		System.out.println("Nome:"+ contato2.getNome());
		System.out.println("Email:"+ contato2.getEmail());
		
		dataFormatada=dateFormat.format(contato2.getDataNascimento().getTime());
		
		System.out.println("Data	de	Nascimento:	" + dataFormatada	+	"\n");

		System.out.println("Endereço:"+ contato2.getEndereco());
		
		
		
	}

}
