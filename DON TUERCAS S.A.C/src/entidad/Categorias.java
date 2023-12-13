package entidad;

public class Categorias {
	
	// Atributos privados 
	private int codCategoria;
	private String nombCategoria;
	
	// Constructores
	
	public Categorias() {
		
	}

	public Categorias(int codCategoria, String nombCategoria) {
		this.codCategoria = codCategoria;
		this.nombCategoria = nombCategoria;
	}

	
	// Métodos de Acceso SET y GET
	public int getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getNombCategoria() {
		return nombCategoria;
	}

	public void setNombCategoria(String nombCategoria) {
		this.nombCategoria = nombCategoria;
	}
	
	

}
