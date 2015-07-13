package entidades;

public enum Turno {
	MANHA("Manhã",0.5,3), TARDE("Tarde",6,1), NOITE("Noite",6,1);
	private String nome;
	private double valorAluno, valorFuncionario;
	
	private Turno(String nome,double valorAluno, double valorFuncionario) {
		this.nome = nome;
		this.valorAluno = valorAluno;
		this.valorFuncionario = valorFuncionario;
	}
	
	public String getNome(){
		return nome;
	}
	
	public double getValorAluno() {
		return valorAluno;
	}
	
	public double getValorFuncionario() {
		return valorFuncionario;
	}

}
