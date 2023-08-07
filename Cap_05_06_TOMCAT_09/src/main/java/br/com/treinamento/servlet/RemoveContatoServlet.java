package br.com.treinamento.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.treinamento.servlet.conexao.ContatoDao;

@WebServlet("/removerContato")
public class RemoveContatoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String idDoContato = request.getParameter("id");

		System.out.println("Id do contato: " + idDoContato);

		Long idRemover = Long.parseLong(idDoContato);

		ContatoDao dao = new ContatoDao();
		dao.remover(idRemover);

		response.sendRedirect("lista-contatos.jsp");
	}

}
