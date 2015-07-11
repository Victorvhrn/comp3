package entidades;

public class Refeicao {
	private int id;
	private Turno turno;
	private String descricao;
	private String opcaoVegan;
	
	public Refeicao(Turno turno,String descricao, String opcaoVegan) {
		this.turno = turno;
		this.descricao  = descricao;
		this.opcaoVegan = opcaoVegan;
	}
	
	public Refeicao(int id, Turno turno,String descricao, String opcaoVegan) {
		this.id = id;
		this.turno = turno;
		this.descricao  = descricao;
		this.opcaoVegan = opcaoVegan;
	}
	
	public int getId() {
		return id;
	}
	
	public Turno getTurno() {
		return turno;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getOpcaoVegan() {
		return opcaoVegan;
	}
}
