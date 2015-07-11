package entidades;

public abstract class Consumidor {
	private int id;
	private String nome;
	private int matricula;
	private int anoIngresso;
	private Sexo sexo;
	private Titulo titulo;
	private CPF cpf;
	
	public Consumidor(int id, String nome, int matricula, int anoIngresso, Sexo sexo, Titulo titulo, CPF cpf) {
		this.nome = nome;
		this.matricula = matricula;
		this.anoIngresso = anoIngresso;
		this.sexo = sexo;
		this.titulo = titulo;
		this.cpf = cpf;
	}
	
	public Consumidor(String nome, int matricula, int anoIngresso, Sexo sexo, Titulo titulo, CPF cpf) {
		this.nome = nome;
		this.matricula = matricula;
		this.anoIngresso = anoIngresso;
		this.sexo = sexo;
		this.titulo = titulo;
		this.cpf = cpf;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public int getAnoIngresso() {
		return anoIngresso;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public CPF getCpf() {
		return cpf;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public void setAnoIngresso(int anoIngresso) {
		this.anoIngresso = anoIngresso;
	}
}
