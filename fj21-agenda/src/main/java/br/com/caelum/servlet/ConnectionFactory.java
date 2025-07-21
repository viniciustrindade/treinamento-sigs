package br.com.caelum.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/fj21?allowPublicKeyRetrieval=true&useSSL=false", 
					"root", "12345");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Driver JDBC não encontrado.");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}
}
