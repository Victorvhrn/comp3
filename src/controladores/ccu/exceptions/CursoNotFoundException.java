package controladores.ccu.exceptions;

public class CursoNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CursoNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Curso n�o encontrado.");
	}
	
	public boolean equals(CursoNotFoundException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage());
	}

}
