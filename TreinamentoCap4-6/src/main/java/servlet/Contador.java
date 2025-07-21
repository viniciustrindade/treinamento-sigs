package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contador")
public class Contador extends HttpServlet{
	
	private int contador = 0;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		contador++;

		PrintWriter out = res.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=utf-8/>");
		out.println("</head>");
		out.println("<body>");
		out.println("Contador agora é: " + contador);
		out.println("</body>");
		out.println("</html>");
	}
	

}
