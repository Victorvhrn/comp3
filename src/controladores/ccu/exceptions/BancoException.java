
package controladores.ccu.exceptions;

public class BancoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BancoException() {
		super("Ocorreu um problema em nossos servidores. Tente mais tarde.");
	}
}

