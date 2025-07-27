package br.com.caelum.jdbc.teste;

import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaPesquisaPorId {

    public static void main(String[] args) {
        ContatoDao dao = new ContatoDao();

        Long idParaBuscar = 1L;
        List<Contato> resultados = dao.pesquisar(idParaBuscar);

        if (resultados.isEmpty()) {
            System.out.println("Nenhum contato encontrado com id = " + idParaBuscar);
        } else {
            for (Contato c : resultados) {
                System.out.println("=== Contato encontrado ===");
                System.out.println("Id:       " + c.getId());
                System.out.println("Nome:     " + c.getNome());
                System.out.println("Email:    " + c.getEmail());
                System.out.println("Endereço: " + c.getEndereco());
                System.out.println("Nasc.:    " + 
                    new java.text.SimpleDateFormat("dd/MM/yyyy")
                        .format(c.getDataNascimento().getTime()));
                System.out.println();
            }
        }
    }
}
