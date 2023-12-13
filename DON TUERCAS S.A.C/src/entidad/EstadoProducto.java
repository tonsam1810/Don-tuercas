package entidad;

public class EstadoProducto {

	// Atributos Privados
	private int codEstado;
	private String nombEstado;
	
	// Constructores
	public EstadoProducto() {
		
	}

	public EstadoProducto(int codEstado, String nombEstado) {
		this.codEstado = codEstado;
		this.nombEstado = nombEstado;
	}

	// Métodos de acceso SET y GET
	public int getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(int codEstado) {
		this.codEstado = codEstado;
	}

	public String getNombEstado() {
		return nombEstado;
	}

	public void setNombEstado(String nombEstado) {
		this.nombEstado = nombEstado;
	}
	
	
}
