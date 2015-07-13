package roteiros.listagem;

import java.sql.SQLException;
import java.util.Collection;

import controladores.ccu.exceptions.BancoException;
import controladores.ccu.exceptions.CPFIncompletoException;
import controladores.ccu.exceptions.CPFInvalidoException;
import controladores.ccu.exceptions.NomeNotFoundException;
import mapeadores.DMTicket;
import entidades.Ticket;
import interfaces.RoteiroListagem;

public class RoteiroListarTicket implements RoteiroListagem<Ticket> {
	public Collection<Ticket> execute() throws BancoException, CPFInvalidoException, CPFIncompletoException, NomeNotFoundException{
		DMTicket dmTicket = new DMTicket();
		Collection<Ticket> resultado;
		try {
			resultado = dmTicket.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BancoException();
		}
		return resultado;
	}
}

