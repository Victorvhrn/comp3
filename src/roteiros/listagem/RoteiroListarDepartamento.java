package roteiros.listagem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import controladores.ccu.exceptions.BancoException;
import mapeadores.DMDepartamento;
import entidades.Departamento;
import interfaces.RoteiroListagem;


public class RoteiroListarDepartamento implements RoteiroListagem<Departamento>{
	public Collection<Departamento> execute() throws BancoException{
		DMDepartamento dmDepto;
		ArrayList<Departamento> resultado = new ArrayList<Departamento>();
		try {
			dmDepto = new DMDepartamento();
			resultado = (ArrayList<Departamento>) dmDepto.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BancoException();
		}
		return resultado;
	}
}

