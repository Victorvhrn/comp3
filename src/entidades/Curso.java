package entidades;

import controladores.ccu.exceptions.NomeNotFoundException;
import controladores.ccu.exceptions.SiglaNotFoundException;


public class Curso {
	private int id;
	private String nome;
	private String sigla;
	private Departamento departamento;
	
	public Curso(String nome,String sigla,Departamento departamento) throws NomeNotFoundException, SiglaNotFoundException {
		this.nome = validarNome(nome);
		this.sigla = validarSigla(sigla);
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
	
	private String validarNome(String nome) throws NomeNotFoundException {
		if(nome == null || nome.equals("")){
			throw new NomeNotFoundException();
		}else{
			return nome;
		}
	}
	
	private String validarSigla(String sigla) throws SiglaNotFoundException {
		if(nome == null || nome.equals("")){
			throw new SiglaNotFoundException();
		}else{
			return nome;
		}
	}
	
	public boolean equals(Curso c) {
		// TODO Auto-generated method stub
		return sigla.equals(c.sigla);
	}

}
