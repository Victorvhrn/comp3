<<<<<<< HEAD
package controladores.ccu.exceptions;

public class DescricaoNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DescricaoNotFoundException() {
		super("O campo descricao n�o foi preenchido.");
	}

	public boolean equals(DescricaoNotFoundException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage());
	}
}
=======
package controladores.ccu.exceptions;

public class DescricaoNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DescricaoNotFoundException() {
		super("O campo descricao n�o foi preenchido.");
	}

	public boolean equals(DescricaoNotFoundException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage());
	}
}
>>>>>>> 43bd4e7836329cf1cbfe3d69e9ae2c565c6612aa
