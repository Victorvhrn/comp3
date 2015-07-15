package roteiros.criacao;

import java.sql.SQLException;

import controladores.ccu.exceptions.BancoException;
import controladores.ccu.exceptions.DescricaoNotFoundException;
import controladores.ccu.exceptions.OpcaoVeganNotFoundException;
import mapeadores.DMRefeicao;
import entidades.Refeicao;
import entidades.Turno;

public class RoteiroCriarRefeicao {
	public void execute(String turno, String descricao, String opcaoVegan) throws DescricaoNotFoundException, OpcaoVeganNotFoundException, BancoException{
		Turno t = null;
		switch (turno) {
		case "Manhã":
			t = Turno.MANHA;
			break;
		case "Tarde":
			t = Turno.TARDE;
			break;
		case "Noite":
			t = Turno.NOITE;
			break;
		default:
			break;
		}
		DMRefeicao dmR = new DMRefeicao();
		Refeicao refeicao = new Refeicao(t, descricao, opcaoVegan);
		try {
			dmR.insert(refeicao);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			throw new BancoException();
		}
	}
}
