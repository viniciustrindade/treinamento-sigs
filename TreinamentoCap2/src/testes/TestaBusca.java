package testes;

import java.util.List;
import java.text.SimpleDateFormat;

import dao.ContatoDao;
import modelo.Contato;

public class TestaBusca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContatoDao dao = new ContatoDao();
		
		List<Contato> contatos = dao.buscarTodos();
		
		SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		for	(Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: "	+ contato.getEndereco());
			System.out.println("Data de Nascimento: " + formatarData.format(contato.getDataNascimento().getTime()) +"\n");
		}

	}

}
