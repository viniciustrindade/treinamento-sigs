package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
	public Connection getConnection() {
	    try {
	        Class.forName("com.mysql.jdbc.Driver"); 
	        return DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/fj21"
	                + "?useSSL=false"
	                + "&allowPublicKeyRetrieval=true"
	                + "&serverTimezone=UTC",
	            "root",
	            "12345");
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
