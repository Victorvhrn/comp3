<<<<<<< HEAD
package entidades;

public class Ticket {
	private int id;
	private boolean pago;
	private Consumidor consumidor;
	private Refeicao refeicao;
	
	public Ticket(boolean pago, Consumidor consumidor, Refeicao refeicao) {
		this.pago = pago;
		this.consumidor = consumidor;
		this.refeicao = refeicao;
	}
	
	public Ticket(int id, boolean pago, Consumidor consumidor, Refeicao refeicao) {
		this.id = id;
		this.pago = pago;
		this.consumidor = consumidor;
		this.refeicao = refeicao;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isPago() {
		return pago;
	}
	
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	
	public Consumidor getConsumidor() {
		return consumidor;
	}
	
	public Refeicao getRefeicao() {
		return refeicao;
	}

	public boolean equals(Ticket t) {
		// TODO Auto-generated method stub
		return consumidor == t.consumidor && refeicao == t.refeicao;
	}
}
=======
package entidades;

public class Ticket {
	private int id;
	private boolean pago;
	private Consumidor consumidor;
	private Refeicao refeicao;
	
	public Ticket(boolean pago, Consumidor consumidor, Refeicao refeicao) {
		this.pago = pago;
		this.consumidor = consumidor;
		this.refeicao = refeicao;
	}
	
	public Ticket(int id, boolean pago, Consumidor consumidor, Refeicao refeicao) {
		this.id = id;
		this.pago = pago;
		this.consumidor = consumidor;
		this.refeicao = refeicao;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isPago() {
		return pago;
	}
	
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	
	public Consumidor getConsumidor() {
		return consumidor;
	}
	
	public Refeicao getRefeicao() {
		return refeicao;
	}

	public boolean equals(Ticket t) {
		// TODO Auto-generated method stub
		return consumidor == t.consumidor && refeicao == t.refeicao;
	}
}
>>>>>>> 43bd4e7836329cf1cbfe3d69e9ae2c565c6612aa
