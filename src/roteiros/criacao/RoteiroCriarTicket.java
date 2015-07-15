package roteiros.criacao;

import java.sql.SQLException;

import controladores.ccu.exceptions.BancoException;
import entidades.Consumidor;
import entidades.Refeicao;
import entidades.Ticket;
import mapeadores.DMConsumidor;
import mapeadores.DMRefeicao;
import mapeadores.DMTicket;

public class RoteiroCriarTicket {
	public void execute(boolean pago, int consumidorId, int refeicaoId) throws BancoException{
		Consumidor consumidor;
		Refeicao refeicao;
		try {
			consumidor = new DMConsumidor().selectById(consumidorId);
			refeicao = new DMRefeicao().selectById(refeicaoId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			throw new BancoException();
		}
		DMTicket dmT = new DMTicket();
		Ticket ticket = new Ticket(pago, consumidor, refeicao);
		
		try {
			dmT.insert(ticket);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			throw new BancoException();
		}
		
		
	}
}

