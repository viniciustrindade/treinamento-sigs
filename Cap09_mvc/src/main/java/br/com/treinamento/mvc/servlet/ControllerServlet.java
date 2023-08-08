package br.com.treinamento.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.treinamento.mvc.logica.Logica;


@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String parametroUrl = req.getParameter("logica");
		String nomeDaClass = "br.com.treinamento.mvc.logica." + parametroUrl;
		
		
		try {
			Class classe = Class.forName(nomeDaClass);
			
			Logica logica = (Logica) classe.newInstance();
			String paginaJsp = logica.executa(req, resp);
			
			req.getRequestDispatcher(paginaJsp).forward(req, resp);
			
		} catch (Exception e) {
			throw new ServletException("Deu algum erro na logica - corrigir", e);
		}
		
	}
	

}
