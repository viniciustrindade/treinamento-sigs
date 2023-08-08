package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

@WebServlet("/adicionarContato")
public class AdicionaContatoServlet extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando a servlet");
	}

	public void destroy() {
		super.destroy();
		log("Destruindo a servlet");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// busca o writer
		PrintWriter out = response.getWriter();

		// buscando os parâmetros no request
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		if(!dataEmTexto.equals("")) {
			
		// fazendo a conversão da data
			try {
				
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dataEmTexto);
				dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(date);
				
			} catch (ParseException e) {
				out.println("Erro	de	conversão	da	data");
				return; // para a execução do método
			}
		}

		//	monta	um	objeto	contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		// salva o contato
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		// imprime o nome do contato que foi adicionado
		out.println("<!DOCTYPE html>");
		out.println("<html lang='pt-br'>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9' crossorigin='anonymous'>");
		out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js' integrity='sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm' crossorigin='anonymous'></script>");
		out.println("<title>Operação realizada com sucesso</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container mt-3'>");
		out.println("<div class='alert alert-success' role='alert'>Contado <strong>" + contato.getNome() + "</strong> adicionado com sucesso.</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
