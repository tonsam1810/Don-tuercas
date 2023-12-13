package entidad;

public class Cargo {
	
	// Atributos privados
	
	private int idCargo;
	private String nombCargo;
	
	
	// Constructores
	
	public Cargo () {
		
	}


	public Cargo(int idCargo, String nombCargo) {
		this.idCargo = idCargo;
		this.nombCargo = nombCargo;
	}

	// Métodos de acceso GET y SET

	public int getIdCargo() {
		return idCargo;
	}


	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}


	public String getNombCargo() {
		return nombCargo;
	}


	public void setNombCargo(String nombCargo) {
		this.nombCargo = nombCargo;
	}
	
	
	
	

}
