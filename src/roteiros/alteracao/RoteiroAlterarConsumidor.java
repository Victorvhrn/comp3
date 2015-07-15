
package roteiros.alteracao;

import java.sql.SQLException;

import controladores.ccu.exceptions.BancoException;
import controladores.ccu.exceptions.CPFIncompletoException;
import controladores.ccu.exceptions.CPFInvalidoException;
import controladores.ccu.exceptions.NomeNotFoundException;
import mapeadores.DMConsumidor;
import entidades.Consumidor;
import entidades.Sexo;

public class RoteiroAlterarConsumidor {
	public void execute(int consumidorId, String nome, int matricula, String sexo,
						int anoIngresso) throws  CPFInvalidoException, CPFIncompletoException, NomeNotFoundException, BancoException{
		Sexo sex = (sexo.equals("Masculino")) ? Sexo.MASCULINO : Sexo.FEMININO;
		
		DMConsumidor dmC = new DMConsumidor();
		
		try {
			Consumidor consumidor = dmC.selectById(consumidorId);
			consumidor.setNome(nome);
			consumidor.setMatricula(matricula);
			consumidor.setSexo(sex);
			consumidor.setAnoIngresso(anoIngresso);
			dmC.update(consumidorId, consumidor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			throw new BancoException();
		}
		
	}
}

