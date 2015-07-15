package roteiros.listagem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import controladores.ccu.exceptions.BancoException;
import mapeadores.DMCurso;
import entidades.Curso;
import interfaces.RoteiroListagem;

public class RoteiroListarCurso implements RoteiroListagem<Curso>{
	public Collection<Curso> execute() throws BancoException{
		DMCurso dmCurso = new DMCurso();
		Collection<Curso> resultado = new ArrayList<Curso>();
		try {
			resultado = dmCurso.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			throw new BancoException();
		}
		return resultado;
	}
}

