package entidad;

public class Productos {
	
	private int idProducto;
	private String descripcion;
	private int proveedores;
	private int stock;
	private double precio;
	private int idCategoria;
	private int estadoProd;
	
	public Productos() {
		
	}
	
	public Productos(int idProducto, String descripcion, int proveedores, int stock, double precio, int idCtegoria, int estadoProd) {
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.proveedores = proveedores;
		this.stock = stock;
		this.precio = precio;
		this.idCategoria = idCtegoria;
		this.estadoProd = estadoProd;
	}

	

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getProveedores() {
		return proveedores;
	}

	public void setProveedores(int proveedores) {
		this.proveedores = proveedores;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCtegoria) {
		this.idCategoria = idCtegoria;
	}

	public int getEstadoProd() {
		return estadoProd;
	}

	public void setEstadoProd(int estadoProd) {
		this.estadoProd = estadoProd;
	}
	
	
	

}
