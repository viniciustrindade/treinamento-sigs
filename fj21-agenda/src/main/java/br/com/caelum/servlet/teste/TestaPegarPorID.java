package br.com.caelum.servlet.teste;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import br.com.caelum.servlet.modelo.Contato;
import br.com.caelum.servlet.modelo.dao.ContatoDAO;

public class TestaPegarPorID {
public static void main(String[] args) {
		
		
		DateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataFormatada;
		ContatoDAO	dao	=	new	ContatoDAO();
		//List<Contato>	contatos	=	dao.getLista();
		Contato contato = dao.pesquisa(5);
		
		
		
			System.out.println("Nome:"+ contato.getNome());
			System.out.println("Email:"+ contato.getEmail());
			
			dataFormatada=dateFormat.format(contato.getDataNascimento().getTime());
			
			System.out.println("Data	de	Nascimento:	" + dataFormatada	+	"\n");

			System.out.println("Endereço:"+ contato.getEndereco());
			
			
		}

}
