package entidad;

public class DetalleFactura {

	// Atributos privados
	private int idfactura;
	private int idProductos;
	private int cantPedidos;
	private double precioVenta;
	private double precioTotal;
	
	// Constructor
	public DetalleFactura() {
		
	}

	public DetalleFactura(int idfactura, int idProductos, int cantPedidos, double precioVenta, double precioTotal) {
		this.idfactura = idfactura;
		this.idProductos = idProductos;
		this.cantPedidos = cantPedidos;
		this.precioVenta = precioVenta;
		this.precioTotal = precioTotal;
	}
	
	// Métodos de acceso SET y GET

	public int getIdfactura() {
		return idfactura;
	}

	public void setIdfactura(int idfactura) {
		this.idfactura = idfactura;
	}

	public int getIdProductos() {
		return idProductos;
	}

	public void setIdProductos(int idProductos) {
		this.idProductos = idProductos;
	}

	public int getCantPedidos() {
		return cantPedidos;
	}

	public void setCantPedidos(int cantPedidos) {
		this.cantPedidos = cantPedidos;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
}
