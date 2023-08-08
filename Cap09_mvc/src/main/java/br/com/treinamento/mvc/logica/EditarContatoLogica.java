package br.com.treinamento.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.treinamento.mvc.conexao.ContatoDao;
import br.com.treinamento.mvc.modelo.Contato;

public class EditarContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// recebe os parametros, checa e realiza a edicao, fica na mesma tela e exibe
		// uma mensagem

		String parametroDoId = request.getParameter("id");
		Long idParaBuscarNoBanco = Long.parseLong(parametroDoId);
		
		ContatoDao dao = new ContatoDao();
		
		Contato contatoParaEdicao = dao.buscaPorId(idParaBuscarNoBanco);
	
		request.setAttribute("contatoEdicao", contatoParaEdicao);
		
		return "adiciona-contato.jsp";

	}

}
