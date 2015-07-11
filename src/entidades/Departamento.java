package entidades;

public class Departamento {
	private int id;
	private String nome;
	private String sigla;
	
	public Departamento(String nome, String sigla) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.sigla = sigla;
	}
	public Departamento(int id, String nome, String sigla) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}
	
	public int getId(){
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSigla() {
		return sigla;
	}
}
