package controladores.ccu.exceptions;

public class CPFInvalidoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpf;
	public CPFInvalidoException(String cpf) {
		// TODO Auto-generated constructor stub
		super("CPF Inv�lido: "+cpf);
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public boolean equals(CPFInvalidoException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage()) && this.cpf.equals(e.getCpf());
	}

}

