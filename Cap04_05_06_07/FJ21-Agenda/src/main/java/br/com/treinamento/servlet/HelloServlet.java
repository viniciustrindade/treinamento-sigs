package br.com.treinamento.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		// escreve o texto 
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Hello Servlet </title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h2>Primeira servlet - Hello</h2>");
		
		out.println("</body>");
		
		out.println("</html>");
	}

}
