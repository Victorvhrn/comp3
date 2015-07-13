<<<<<<< HEAD
package controladores.ccu.exceptions;

public class CriacaoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CriacaoException() {
		// TODO Auto-generated constructor stub
		super("Não foi definido se o consumidor é aluno ou funcionário.");
	}
	
	public boolean equals(CriacaoException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage());
	}
}
=======
package controladores.ccu.exceptions;

public class CriacaoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CriacaoException() {
		// TODO Auto-generated constructor stub
		super("Não foi definido se o consumidor é aluno ou funcionário.");
	}
	
	public boolean equals(CriacaoException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage());
	}
}
>>>>>>> 43bd4e7836329cf1cbfe3d69e9ae2c565c6612aa
