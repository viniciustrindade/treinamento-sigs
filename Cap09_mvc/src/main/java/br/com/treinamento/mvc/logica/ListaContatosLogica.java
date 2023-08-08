package br.com.treinamento.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.treinamento.mvc.conexao.ContatoDao;
import br.com.treinamento.mvc.modelo.Contato;

public class ListaContatosLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.listarContatos();
		request.setAttribute("contatos", contatos);
		
		return "lista-contatos.jsp";
	}

}
