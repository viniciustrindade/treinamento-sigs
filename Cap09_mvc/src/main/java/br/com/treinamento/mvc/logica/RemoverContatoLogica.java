package br.com.treinamento.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.treinamento.mvc.conexao.ContatoDao;

public class RemoverContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {


		//logica de remover
		//receber o id como parametro
		//realiza a remocao
		//exibe uma mensagem e fica na mesma tela de lista-contato
		
		
		String idParaConversao = request.getParameter("id");
		Long idParaRemocao = Long.parseLong(idParaConversao);
		
		ContatoDao dao = new ContatoDao();
		dao.remover(idParaRemocao);
		
		System.out.println("O remover foi chamado");

		return "mvc?logica=ListaContatosLogica";
	}

}
