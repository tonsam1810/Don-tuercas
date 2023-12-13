package entidad;

public class Factura {

	// Atributos privados
	private int idFactura;
	private String fecha;
	private int idCliente;
	private int idUsuario;
	private double totFactura;
	
	// Constructores
	public Factura() {
		
	}

	public Factura(int idFactura, String fecha, int idCliente, int idUsuario, double totFactura) {
		this.idFactura = idFactura;
		this.fecha = fecha;
		this.idCliente = idCliente;
		this.idUsuario = idUsuario;
		this.totFactura = totFactura;
	}
	
	// Métodos de Acceso SET y GET

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public double getTotFactura() {
		return totFactura;
	}

	public void setTotFactura(double totFactura) {
		this.totFactura = totFactura;
	}
	
	
	
}
