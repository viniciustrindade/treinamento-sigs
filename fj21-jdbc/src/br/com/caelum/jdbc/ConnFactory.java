package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnFactory {
	public Connection getConnection() {
		try {
			return (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/fj21","root","12345"
					);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


}

