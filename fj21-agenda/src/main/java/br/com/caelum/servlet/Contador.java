package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contador")
public class Contador extends HttpServlet {

	private int contador = 0;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando a servlet Contador");
	}

	public void destroy() {
		super.destroy();
		log("Destruindo	a servlet Contador");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		contador++;

		// recebe o writer
		PrintWriter out = response.getWriter();

		// escreve o texto
		out.println("<html>");
		out.println("<body>");
		out.println("Contador	agora	é:	" + contador);
		out.println("</body>");
		out.println("</html>");
	}
}
