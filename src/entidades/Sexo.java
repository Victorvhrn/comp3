package entidades;

public enum Sexo {
	MASCULINO("M"),FEMININO("F");
	
	private String sexo;
	
	private Sexo(String sexo){
		this.sexo = sexo;
	}
	
	public String getSexo(){
		return sexo;
	}
}

