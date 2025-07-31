package br.com.treinamento.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	@WebServlet("/contador")
	public class Contador extends HttpServlet {
		
	private int contador = 0;
	
	protected void service(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
		
	contador++; 
	
	PrintWriter out = response.getWriter();
	
	out.println("<html>");
	out.println("<body>");
	out.println("Contagem =" + contador);
	out.println("</body>");
	out.println("</html>");
	
	}
}
