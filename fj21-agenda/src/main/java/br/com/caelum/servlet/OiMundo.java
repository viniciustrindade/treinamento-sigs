package br.com.caelum.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/oi")

  public class OiMundo extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(request, response);
		
		PrintWriter	out	=	response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Primeira  Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> Oi	mundo Servlet! </h1>");
		out.println("</body>");
		out.println("</html>");
		
		
	}


	
}
