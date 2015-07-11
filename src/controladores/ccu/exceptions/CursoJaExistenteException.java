package controladores.ccu.exceptions;

public class CursoJaExistenteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	
	public CursoJaExistenteException(String nome)
	{
		this.nome = nome;
	}

}
