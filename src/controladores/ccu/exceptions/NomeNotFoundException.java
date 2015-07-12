package controladores.ccu.exceptions;

public class NomeNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NomeNotFoundException() {
		super("O campo nome não foi preenchido.");
	}
	
	public boolean equals(NomeNotFoundException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage());
	}
}
