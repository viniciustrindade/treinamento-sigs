package testes;

import java.text.SimpleDateFormat;

import dao.ContatoDao;
import modelo.Contato;

public class TestaBuscaPorID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContatoDao dao = new ContatoDao();
		
		Contato contato = dao.buscarPorID(1);
		
		SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		if(contato != null) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: "	+ contato.getEndereco());
			System.out.println("Data de Nascimento: " + formatarData.format(contato.getDataNascimento().getTime()));
		}
	}

}
