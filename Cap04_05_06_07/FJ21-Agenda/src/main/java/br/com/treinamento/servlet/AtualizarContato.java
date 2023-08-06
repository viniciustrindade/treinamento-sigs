package br.com.treinamento.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.treinamento.servlet.dao.ContatoDao;
import br.com.treinamento.servlet.modelo.Contato;

public class AtualizarContato extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String idDoContato = request.getParameter("id");
		Long id = Long.parseLong(idDoContato);
		ContatoDao dao = new ContatoDao();
		
		Contato contatoAntigo = dao.buscaPorId(id);
		
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;

		// fazendo a conversão da data
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			out.println("Erro	de	conversão	da	data");
			return; // para a execução do método
		}
		
		System.out.println("################# ID DO CONTATO: " + id);
		System.out.println("################# Novo Nome: " + nome);
		System.out.println("################# Novo Email: " + email);
		System.out.println("################# Novo endereco: " + endereco);
		System.out.println("################# Novo data " + dataNascimento.getTime());

		// monta um objeto contato
		contatoAntigo.setNome(nome);
		contatoAntigo.setEndereco(endereco);
		contatoAntigo.setEmail(email);
		contatoAntigo.setDataNascimento(dataNascimento);
		

		// envia para atualizar o contato 
		dao.alterar(contatoAntigo);
		
		
		response.sendRedirect("lista-contatos.jsp");
		
	}

}
