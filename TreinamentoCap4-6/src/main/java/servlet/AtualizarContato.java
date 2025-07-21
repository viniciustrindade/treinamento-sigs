package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDao;
import modelo.Contato;

@WebServlet("/atualizarContato")

public class AtualizarContato extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		
		
		Long id =  Long.parseLong(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String email = req.getParameter("email");
		String data = req.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		try {
			Date dataformatada = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(dataformatada);
		} catch (ParseException e) {
			out.println("Erro de conversão da data");
			return;
		}
		
		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		ContatoDao	dao	=	new	ContatoDao();
		dao.alterar(contato);
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=utf-8/>");
		out.println("</head>");
		out.println("<body>");
		out.println("Contato " + contato.getNome() +" atualizado com sucesso"+ "<br/> <br/>");	
		out.println("<p><a href=\"./\">Voltar ao inicio </a> </p>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	

}
