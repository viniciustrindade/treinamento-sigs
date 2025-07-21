package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/oi")
public class OiMundo extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter	out	=	res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Testando a primeira servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Oi mundo! Eu sou a primeira servlet</h1>");
		out.println("</body>");
		out.println("</html>");
	}
	
}
