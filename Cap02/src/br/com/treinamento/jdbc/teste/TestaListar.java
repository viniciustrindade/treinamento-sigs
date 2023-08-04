package br.com.treinamento.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.treinamento.jdbc.dao.ContatoDao;
import br.com.treinamento.modelo.Contato;

public class TestaListar {

	public static void main(String[] args) {


		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.listarContatos();
		
		SimpleDateFormat formataDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
		
		System.out.println("\n ## ---------- Listando os contatos ----------- ## \n");
		for(Contato c : contatos) {
			System.out.println("Nome: " + c.getNome());
			System.out.println("E-mail: " + c.getEmail());
			System.out.println("Endereco: " + c.getEndereco());
			System.out.println("Data de nascimento: " + formataDataHora.format(c.getDataNascimento().getTime()) + "\n");
		}
		
		System.out.println("\n ## ---------- Buscando por ID ------ ## \n");
		
		Contato contato = dao.buscaPorId(2l);
		System.out.println("Busca por ID = 2");
		System.out.println("Nome: " + contato.getNome());
		System.out.println("E-mail: " + contato.getEmail());
		System.out.println("Endereco: " + contato.getEndereco());
		System.out.println("Data de nascimento: " + formataDataHora.format(contato.getDataNascimento().getTime()) + "\n");
		
		System.out.println("\n ## ------------ Buscando por nome ----- ## \n");
		
		List<Contato> contatosPorNome = dao.buscaPorNome("me");
		System.out.println("Busca por Nome");
		for(Contato c : contatosPorNome) {
			System.out.println("Nome: " + c.getNome());
			System.out.println("E-mail: " + c.getEmail());
			System.out.println("Endereco: " + c.getEndereco());
			System.out.println("Data de nascimento: " + formataDataHora.format(c.getDataNascimento().getTime()) + "\n");
		}
		
		System.out.println("\n ## ----------------------------- ## \n");
		
	
		

	}

}
