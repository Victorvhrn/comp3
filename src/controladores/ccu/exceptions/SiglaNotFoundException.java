package controladores.ccu.exceptions;

public class SiglaNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SiglaNotFoundException() {
		// TODO Auto-generated constructor stub
		super("O campo sigla n�o foi preenchido.");
	}
	
	public boolean equals(SiglaNotFoundException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage());
	}
}
