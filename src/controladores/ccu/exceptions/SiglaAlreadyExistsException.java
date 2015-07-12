package controladores.ccu.exceptions;

public class SiglaAlreadyExistsException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sigla;

	public SiglaAlreadyExistsException(String sigla) {
		super("Já existe uma sigla igual cadastrada: "+sigla);
		this.sigla = sigla;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	
	public boolean equals(SiglaAlreadyExistsException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage()) && sigla.equals(e.getSigla());
	}
}
