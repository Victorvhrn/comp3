
package entidades;

import controladores.ccu.exceptions.NomeNotFoundException;
import controladores.ccu.exceptions.SiglaNotFoundException;

public class Departamento {
	private int id;
	private String nome;
	private String sigla;
	
	public Departamento(String nome, String sigla) throws NomeNotFoundException, SiglaNotFoundException {
		// TODO Auto-generated constructor stub
		this.nome = validarNome(nome);
		this.sigla = validarSigla(sigla);
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
	
	private String validarNome(String nome) throws NomeNotFoundException {
		if(nome == null || nome.equals("")){
			throw new NomeNotFoundException();
		}else{
			return nome;
		}
	}
	
	private String validarSigla(String sigla) throws SiglaNotFoundException {
		if(sigla == null || sigla.equals("")){
			throw new SiglaNotFoundException();
		}else{
			return sigla;
		}
	}

	public boolean equals(Departamento d) {
		// TODO Auto-generated method stub
		return sigla.equals(d.sigla);
	}
}
