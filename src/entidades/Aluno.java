package entidades;


public class Aluno extends Consumidor{
	private Curso curso;

	public Aluno(int id,String nome, int matricula, int anoIngresso, Sexo sexo, Titulo titulo, CPF cpf, Curso curso) {
		super(id,nome,matricula,anoIngresso,sexo,titulo,cpf);
		this.curso = curso;
	}
	
	public Curso getCurso() {
		return curso;
	}
}
