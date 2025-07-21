package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDao;
import modelo.Contato;


@WebServlet("/deletarContato")

public class DeletarContato extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		
		Long id = Long.parseLong(req.getParameter("id"));
		
		ContatoDao dao = new ContatoDao();
		
		Contato contato = dao.buscarPorID(id);
		
		dao.remover(id);
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=utf-8/>");
		out.println("</head>");
		out.println("<body>");
		out.println("Contato " + contato.getNome() +" removido com sucesso" + "<br/> <br/>");
		out.println("<p><a href=\"./\">Voltar ao inicio </a> </p>");
		out.println("</body>");
		out.println("</html>");
		

}
	
}
