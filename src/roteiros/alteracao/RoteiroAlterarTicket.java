
package roteiros.alteracao;

import java.sql.SQLException;

import controladores.ccu.exceptions.BancoException;
import controladores.ccu.exceptions.CPFIncompletoException;
import controladores.ccu.exceptions.CPFInvalidoException;
import controladores.ccu.exceptions.NomeNotFoundException;
import entidades.Ticket;
import mapeadores.DMTicket;

public class RoteiroAlterarTicket {
	public void execute(int ticketId, boolean pago) throws CPFInvalidoException, CPFIncompletoException, NomeNotFoundException, BancoException{
		DMTicket dmT = new DMTicket();
		Ticket ticket;
		try {
			ticket = dmT.selectById(ticketId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			throw new BancoException();
		}
		ticket.setPago(pago);
		try {
			dmT.update(ticketId, ticket);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
