<<<<<<< HEAD
package controladores.ccu.exceptions;

public class CursoNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CursoNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Curso não encontrado.");
	}
	
	public boolean equals(CursoNotFoundException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage());
	}

}
=======
package controladores.ccu.exceptions;

public class CursoNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CursoNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Curso não encontrado.");
	}
	
	public boolean equals(CursoNotFoundException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage());
	}

}
>>>>>>> 43bd4e7836329cf1cbfe3d69e9ae2c565c6612aa
