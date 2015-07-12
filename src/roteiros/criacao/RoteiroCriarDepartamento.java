package roteiros.criacao;

import java.sql.SQLException;
import java.util.ArrayList;

import controladores.ccu.exceptions.BancoException;
import controladores.ccu.exceptions.NomeNotFoundException;
import controladores.ccu.exceptions.SiglaAlreadyExistsException;
import controladores.ccu.exceptions.SiglaNotFoundException;
import entidades.Departamento;
import mapeadores.DMDepartamento;

public class RoteiroCriarDepartamento {
	public void execute(String nome, String sigla) throws NomeNotFoundException, SiglaNotFoundException, BancoException, SiglaAlreadyExistsException{
		ArrayList<Departamento> resultado = new ArrayList<Departamento>();
		try {
			DMDepartamento dm = new DMDepartamento();
			resultado = (ArrayList<Departamento>) dm.selectByCampo("sigla", sigla);
			if(resultado.isEmpty()){
				Departamento depto = new Departamento(nome, sigla);
				dm.insert(depto);
			}else{
				throw new SiglaAlreadyExistsException(sigla);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BancoException();
		}
	}
}
