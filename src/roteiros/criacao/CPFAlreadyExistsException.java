package roteiros.criacao;

public class CPFAlreadyExistsException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpf;
	
	public CPFAlreadyExistsException(String cpf) {
		super("CPF já cadastrado: "+cpf);
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public boolean equals(CPFAlreadyExistsException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage()) && cpf.equals(e.getCpf());
	}
}
