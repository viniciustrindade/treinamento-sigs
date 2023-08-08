package br.com.treinamento.mvc.logica;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.treinamento.mvc.conexao.ContatoDao;
import br.com.treinamento.mvc.modelo.Contato;


public class AdicionaContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String idNovoOuAntigo = request.getParameter("id");
		ContatoDao dao = new ContatoDao();
		PrintWriter out = response.getWriter();
		
		//se for um ID nulo ou vazio - se trata de um contato novo
		if(idNovoOuAntigo.trim().isEmpty() || idNovoOuAntigo == null) {
			

			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String endereco = request.getParameter("endereco");
			String dataTexto = request.getParameter("dataNascimento");

			if (nome.trim().isEmpty() || email.trim().isEmpty() 
					|| endereco.trim().isEmpty() || dataTexto.trim().isEmpty()) {
				request.setAttribute("validaCampos", "Todos os campos sao obrigatorios");
			}

			Calendar dataNascimento = null;

			// fazendo a conversão da data
			try {
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
				dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(date);
			} catch (ParseException e) {
				out.println("Erro	de	conversão	da	data");
			}

			// monta um objeto contato
			Contato contato = new Contato();
			contato.setNome(nome);
			contato.setEndereco(endereco);
			contato.setEmail(email);
			contato.setDataNascimento(dataNascimento);

			// salva o contato
			//ContatoDao dao = new ContatoDao();
			dao.adicionar(contato);
			
			
			
			System.out.println("pesquisar como inserir uma mensagem de inserido com sucesso");
			
			return "mvc?logica=NovoContatoLogica";
		}
		//ID ja existente - logo se trata de um Contato anterior
		else {
			Long idParaBuscarNoBanco = Long.parseLong(idNovoOuAntigo);
			Contato contatoUpdate = dao.buscaPorId(idParaBuscarNoBanco);
			
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String endereco = request.getParameter("endereco");
			String dataTexto = request.getParameter("dataNascimento");
			
			if (nome.trim().isEmpty() || email.trim().isEmpty() 
					|| endereco.trim().isEmpty() || dataTexto.trim().isEmpty()) {
				request.setAttribute("validaCampos", "Todos os campos sao obrigatorios");
			}

			Calendar dataNascimento = null;

			// fazendo a conversão da data
			try {
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
				dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(date);
			} catch (ParseException e) {
				out.println("Erro	de	conversão	da	data");
			}
			
			contatoUpdate.setNome(nome);
			contatoUpdate.setEmail(email);
			contatoUpdate.setEndereco(endereco);
			contatoUpdate.setDataNascimento(dataNascimento);
			
			dao.alterar(contatoUpdate);
			return "mvc?logica=ListaContatosLogica";
		}
	}

}
