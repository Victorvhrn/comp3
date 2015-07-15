package roteiros.listagem;

import java.sql.SQLException;
import java.util.Collection;

import controladores.ccu.exceptions.BancoException;
import mapeadores.DMRefeicao;
import entidades.Refeicao;
import interfaces.RoteiroListagem;


public class RoteiroListarRefeicao implements RoteiroListagem<Refeicao> {
	public Collection<Refeicao> execute() throws BancoException{
		DMRefeicao dmR = new DMRefeicao();
		Collection<Refeicao> resultado;
		try {
			resultado = dmR.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			throw new BancoException();
		}
		return resultado;
	}
}

