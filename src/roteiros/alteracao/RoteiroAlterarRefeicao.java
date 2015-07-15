package roteiros.alteracao;

import java.sql.SQLException;

import controladores.ccu.exceptions.BancoException;
import controladores.ccu.exceptions.DescricaoNotFoundException;
import controladores.ccu.exceptions.OpcaoVeganNotFoundException;
import mapeadores.DMRefeicao;
import entidades.Refeicao;

public class RoteiroAlterarRefeicao {
	public void execute(int id, String descricao, String opcaoVegan) throws BancoException, DescricaoNotFoundException, OpcaoVeganNotFoundException{
		
		DMRefeicao dmR = new DMRefeicao();
		Refeicao refeicao;
		try {
			refeicao = dmR.selectById(id);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new BancoException();
		}
		refeicao.setDescricao(descricao);
		refeicao.setOpcaoVegan(opcaoVegan);
		
		try {
			dmR.update(id, refeicao);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new BancoException();
		}
	}
}
