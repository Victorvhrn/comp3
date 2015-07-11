package controladores.ccu.exceptions;

public class CursoJaExistenteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	
	public CursoJaExistenteException(String nome)
	{
		super("Curso já existe: "+nome);
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public boolean equals(CursoJaExistenteException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage()) && nome.equals(e.getNome());
	}

}
