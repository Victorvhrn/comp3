
package roteiros.criacao;

import java.sql.SQLException;
import java.util.Collection;

import controladores.ccu.exceptions.BancoException;
import controladores.ccu.exceptions.NomeNotFoundException;
import controladores.ccu.exceptions.SiglaAlreadyExistsException;
import controladores.ccu.exceptions.SiglaNotFoundException;
import entidades.Curso;
import entidades.Departamento;
import mapeadores.DMCurso;
import mapeadores.DMDepartamento;

public class RoteiroCriarCurso {
	public void execute(String nome, String sigla, int departamentoId) throws BancoException, NomeNotFoundException, SiglaNotFoundException, SiglaAlreadyExistsException{
		DMDepartamento dmd = new DMDepartamento();
		try {
			DMCurso dmc = new DMCurso();
			Collection<Curso> resultado = dmc.selectByCampo("sigla", sigla);
			if(resultado.isEmpty()){
				Departamento departamento = dmd.selectById(departamentoId);
				Curso curso = new Curso(nome, sigla, departamento);
				dmc.insert(curso);
			}else{
				throw new SiglaAlreadyExistsException(sigla);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new BancoException();
		}
	}
}

