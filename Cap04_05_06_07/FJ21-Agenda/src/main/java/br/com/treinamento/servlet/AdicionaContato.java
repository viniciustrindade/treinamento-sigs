package br.com.treinamento.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.treinamento.servlet.dao.ContatoDao;
import br.com.treinamento.servlet.modelo.Contato;

public class AdicionaContato extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataTexto = request.getParameter("dataNascimento");
		
		if(nome.trim().isEmpty() || email.trim().isEmpty() || endereco.trim().isEmpty() || dataTexto.trim().isEmpty()) {
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

	/*
	 * @Override protected void doPost(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException { PrintWriter out =
	 * resp.getWriter();
	 * 
	 * String nome = req.getParameter("nome"); String email =
	 * req.getParameter("email"); String endereco = req.getParameter("endereco");
	 * String dataTexto = req.getParameter("dataNascimento");
	 * 
	 * Calendar dataNascimento = null;
	 * 
	 * // fazendo a conversão da data try { Date date = new
	 * SimpleDateFormat("dd/MM/yyyy").parse(dataTexto); dataNascimento =
	 * Calendar.getInstance(); dataNascimento.setTime(date); } catch (ParseException
	 * e) { out.println("Erro	de	conversão	da	data"); return; // para a
	 * execução do método }
	 * 
	 * // monta um objeto contato Contato contato = new Contato();
	 * contato.setNome(nome); contato.setEndereco(endereco);
	 * contato.setEmail(email); contato.setDataNascimento(dataNascimento);
	 * 
	 * // salva o contato ContatoDao dao = new ContatoDao(); dao.adicionar(contato);
	 * 
	 * // imprime o nome do contato que foi adicionado out.println("<html>");
	 * out.println("<head>"); out.println("<title> Sucesso </title>");
	 * out.println("</head>"); out.println("<body>"); out.println("Contato	" +
	 * contato.getNome() + "	adicionado	com	sucesso"); out.println("</body>");
	 * out.println("</html>"); }
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		// imprime o nome do contato que foi adicionado
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Welcome</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Bem-vindo AO CADASTRO");
		out.println("</body>");
		out.println("</html>");

	}

	/*
	 * @Override protected void doPut(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException { // TODO Auto-generated method
	 * stub super.doPut(req, resp); }
	 * 
	 * 
	 * @Override protected void doDelete(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException { // TODO Auto-generated method
	 * stub super.doDelete(req, resp); }
	 */

}
