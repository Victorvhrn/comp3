package controladores.ccu.exceptions;

public class OpcaoVeganNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public OpcaoVeganNotFoundException() {
		// TODO Auto-generated constructor stub
		super("O campo op��o vegetariana n�o foi preenchido.");
	}

	public boolean equals(OpcaoVeganNotFoundException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage());
	}
}

