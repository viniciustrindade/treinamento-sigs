package br.com.treinamento.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("Executando a primeira logica .... ");
		
		
		return "primeira-logica.jsp";
	}

}
