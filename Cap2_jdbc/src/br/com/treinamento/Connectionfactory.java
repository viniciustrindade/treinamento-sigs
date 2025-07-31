package br.com.treinamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionfactory {
	public Connection getConnection() {
		try {
		return DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/fj21?autoReconnect=true&useSSL=false",
		"root",
		"12345");
		} catch (SQLException e) {
		throw new RuntimeException(e);
			}
		}
}
