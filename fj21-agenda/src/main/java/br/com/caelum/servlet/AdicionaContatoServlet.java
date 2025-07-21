package br.com.caelum.servlet;

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

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataNaoFormatada = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		// formata dataNaoFormatada
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataNaoFormatada);
			
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			out.println("Ocorreu um erro");
			System.out.println(e);
			return;
		}
		
		// cria um novo objeto contato que iremos mandar ao banco de dados
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>");
		out.println("Contato " + contato.getNome() + " adicionado com sucesso!");
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
