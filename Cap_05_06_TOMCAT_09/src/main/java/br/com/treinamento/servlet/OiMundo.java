package br.com.treinamento.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "OiMundo", urlPatterns = "/oi")
public class OiMundo extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter saidaHtml = resp.getWriter();
		String refatorando = "Ola mundo servlet com Tomcat 9 e java 8";
		
		saidaHtml.write("<html>");
		saidaHtml.write("<head><title>Ola mundo</title></head>");
		saidaHtml.write("<body>");
		saidaHtml.write("<h1>" + refatorando + "</h1>");
		saidaHtml.write("</body>");
		saidaHtml.write("</html>");
		
	}
	

}
