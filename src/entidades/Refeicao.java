
package entidades;

import controladores.ccu.exceptions.DescricaoNotFoundException;
import controladores.ccu.exceptions.OpcaoVeganNotFoundException;

public class Refeicao {
	private int id;
	private Turno turno;
	private String descricao;
	private String opcaoVegan;
	
	public Refeicao(Turno turno,String descricao, String opcaoVegan) throws DescricaoNotFoundException, OpcaoVeganNotFoundException {
		this.turno = turno;
		this.descricao  = validarDescricao(descricao);
		this.opcaoVegan = validarOpcaoVegan(opcaoVegan);
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
	
	private String validarDescricao(String descricao) throws DescricaoNotFoundException {
		if(descricao == null || descricao.equals("")){
			throw new DescricaoNotFoundException();
		}else{
			return descricao;
		}
	}
	
	private String validarOpcaoVegan(String opcaoVegan) throws OpcaoVeganNotFoundException {
		if(opcaoVegan == null || opcaoVegan.equals("")){
			throw new OpcaoVeganNotFoundException();
		}else{
			return opcaoVegan;
		}
	}
	
	public boolean equals(Refeicao r) {
		// TODO Auto-generated method stub
		return turno.equals(r.turno) && descricao.equals(r.descricao) 
				&& opcaoVegan.equals(r.opcaoVegan);
	}
}
