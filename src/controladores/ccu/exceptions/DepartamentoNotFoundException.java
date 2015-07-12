package controladores.ccu.exceptions;

public class DepartamentoNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DepartamentoNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Departamento não encontrado.");
	}
	
	public boolean equals(DepartamentoNotFoundException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage());
	}
}
