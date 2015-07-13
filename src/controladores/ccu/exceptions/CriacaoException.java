
package controladores.ccu.exceptions;

public class CriacaoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CriacaoException() {
		// TODO Auto-generated constructor stub
		super("N�o foi definido se o consumidor � aluno ou funcion�rio.");
	}
	
	public boolean equals(CriacaoException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage());
	}
}

