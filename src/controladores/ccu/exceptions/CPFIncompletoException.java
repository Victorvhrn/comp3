
package controladores.ccu.exceptions;

public class CPFIncompletoException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpf;
	
	public CPFIncompletoException(String cpf) {
		// TODO Auto-generated constructor stub
		super("CPF Incompleto: "+cpf);
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public boolean equals(CPFIncompletoException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage()) && this.cpf.equals(e.getCpf());
	}
	
}

