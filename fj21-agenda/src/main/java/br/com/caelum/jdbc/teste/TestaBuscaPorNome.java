package br.com.caelum.jdbc.teste;

import java.util.List;
import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaBuscaPorNome {

    public static void main(String[] args) {
        ContatoDao dao = new ContatoDao();
        
        List<Contato> contatosComC = dao.buscarPorNome("C");
        for (Contato contato : contatosComC) {
            System.out.println("nome: " + contato.getNome());
            System.out.println("email: " + contato.getEmail());
            System.out.println("endereco: " + contato.getEndereco());
            System.out.println("nasc.: " + contato.getDataNascimento().getTime());
            System.out.println();
        }
    }
}
