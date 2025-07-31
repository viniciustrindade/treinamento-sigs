package Principal;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.treinamento.Connectionfactory;

public class main {
	public static void main(String[] args) throws SQLException {
		Connection connection = new Connectionfactory().getConnection();
		System.out.println("Conexão aberta!");
		connection.close();
	}
}
