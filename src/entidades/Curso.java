package entidades;


public class Curso {
	private int id;
	private String nome;
	private String sigla;
	private Departamento departamento;
	
	public Curso(String nome,String sigla,Departamento departamento) {
		this.nome = nome;
		this.sigla = sigla;
		this.departamento = departamento;
	}
	public Curso(int id,String nome,String sigla,Departamento departamento) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome(){
		return nome;
	}
	public String getSigla(){
		return sigla;
	}
	public Departamento getDepartamento() {
		return departamento;
	}

}
