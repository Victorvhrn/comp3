package controladores.ccu.exceptions;

public class DescricaoNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DescricaoNotFoundException() {
		super("O campo descricao não foi preenchido.");
	}

	public boolean equals(DescricaoNotFoundException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage());
	}
}
