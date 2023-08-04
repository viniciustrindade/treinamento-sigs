package br.com.treinamento.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		//Class.forName("com.mysql.jdbc.Driver");
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "12345");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
