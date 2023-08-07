package br.com.treinamento.servlet;

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

import br.com.treinamento.servlet.conexao.ContatoDao;
import br.com.treinamento.servlet.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataTexto = request.getParameter("dataNascimento");

		if (nome.trim().isEmpty() || email.trim().isEmpty() || endereco.trim().isEmpty()
				|| dataTexto.trim().isEmpty()) {
			request.setAttribute("validaCampos", "Todos os campos sao obrigatorios");
			response.sendRedirect("adiciona-contato.jsp");
		}

		Calendar dataNascimento = null;

		// fazendo a conversão da data
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			out.println("Erro	de	conversão	da	data");
			return; // para a execução do método
		}

		// monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);

		// salva o contato
		ContatoDao dao = new ContatoDao();
		dao.adicionar(contato);

		// imprime o nome do contato que foi adicionado

		/**
		 * Ao inves de exibir esse HTML para o usuario, eu estou redirecionando ele para a pagina de listagem
		 */
		
		/*
		 * out.println("<html>"); out.println("<head>");
		 * out.println("<title> Sucesso </title>"); out.println("</head>");
		 * out.println("<body>"); out.println("Contato	" + contato.getNome() +
		 * "	adicionado	com	sucesso"); out.println("</body>");
		 * out.println("</html>");
		 */

		response.sendRedirect("lista-contatos.jsp");
		
		
	}
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Metodo init sendo chamado aqui");
		super.init(config);
	}

	@Override
	public void destroy() {
		System.out.println("Metodo destroy sendo chamado aqui");
		super.destroy();
	}
	
	

}





