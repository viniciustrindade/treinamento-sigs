package testes;

import dao.FuncionarioDao;
import modelo.Funcionario;

public class TestaInsere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Funcionario	funcionario	=	new	Funcionario();
		funcionario.setNome("Otavio");
		funcionario.setUsuario("Otavio123");
		funcionario.setSenha("12345678");
		
		FuncionarioDao dao = new FuncionarioDao();
		dao.adicionar(funcionario);
		
		System.out.println("Funcionario cadastrado!");

	}

}
