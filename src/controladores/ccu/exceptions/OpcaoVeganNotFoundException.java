<<<<<<< HEAD
package controladores.ccu.exceptions;

public class OpcaoVeganNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public OpcaoVeganNotFoundException() {
		// TODO Auto-generated constructor stub
		super("O campo opção vegetariana não foi preenchido.");
	}

	public boolean equals(OpcaoVeganNotFoundException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage());
	}
}
=======
package controladores.ccu.exceptions;

public class OpcaoVeganNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public OpcaoVeganNotFoundException() {
		// TODO Auto-generated constructor stub
		super("O campo opção vegetariana não foi preenchido.");
	}

	public boolean equals(OpcaoVeganNotFoundException e) {
		// TODO Auto-generated method stub
		return getMessage().equals(e.getMessage());
	}
}
>>>>>>> 43bd4e7836329cf1cbfe3d69e9ae2c565c6612aa
