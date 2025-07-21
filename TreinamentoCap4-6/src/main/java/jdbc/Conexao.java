package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	


		public	Connection	getConnection()	{
			try	{
				Class.forName("com.mysql.jdbc.Driver");
				return	DriverManager.getConnection( "jdbc:mysql://localhost/bancotreinamento", "root", "root");
			}	
			catch(SQLException | ClassNotFoundException	e)	{
				throw new RuntimeException(e); 
			} 
		}

}