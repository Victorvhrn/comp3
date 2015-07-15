package roteiros.listagem;

import java.sql.SQLException;
import java.util.Collection;

import controladores.ccu.exceptions.BancoException;
import controladores.ccu.exceptions.CPFIncompletoException;
import controladores.ccu.exceptions.CPFInvalidoException;
import controladores.ccu.exceptions.NomeNotFoundException;
import mapeadores.DMConsumidor;
import entidades.Consumidor;
import interfaces.RoteiroListagem;

public class RoteiroListarConsumidor implements RoteiroListagem<Consumidor> {
	public Collection<Consumidor> execute() throws  CPFInvalidoException, CPFIncompletoException, NomeNotFoundException, BancoException{
		DMConsumidor dmC = new DMConsumidor();
		Collection<Consumidor> resultado;
		try {
			resultado = dmC.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			throw new BancoException();
		}
		return resultado;
	}
}

