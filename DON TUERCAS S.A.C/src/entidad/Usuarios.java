package entidad;

public class Usuarios {
	// Atributos Privados
	private int codigo;
	private String nombre;
	private String apellido;
	private String usuario;
	private String clave;
	private int dni;
	private int cargo;
	
	// Constructores
	
	public Usuarios() {
		
	}

	public Usuarios(int codigo, String nombre, String apellido, String usuario, String clave, int dni, int cargo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.clave = clave;
		this.dni = dni;
		this.cargo = cargo;
	}
	
	// Métodos de acceso SET y GET

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	
	
	
	

}
