package entidades;

public enum Titulo {
	ESPECIALIZACAO("Especializacao"), MESTRADO("Mestrado"), DOUTORADO("Doutorado");
	
	private String titulo; 
	
	private Titulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	public String getTitulo() {
		return titulo;
	}
}
