<<<<<<< HEAD
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
=======
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
>>>>>>> 43bd4e7836329cf1cbfe3d69e9ae2c565c6612aa
