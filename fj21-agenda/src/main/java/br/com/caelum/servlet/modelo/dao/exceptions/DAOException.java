package br.com.caelum.servlet.modelo.dao.exceptions;

public class DAOException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DAOException(String g) {
		super("Dado invalido:"+ g);
	}
	
	
	
}
