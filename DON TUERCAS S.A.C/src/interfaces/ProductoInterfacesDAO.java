package interfaces;

import java.util.ArrayList;

import entidad.Productos;

public interface ProductoInterfacesDAO {
	
	// Registrar 
	public int registrar (Productos p);
	
	// Actualizar 
	public int actualizar (Productos p);
	
	// Eliminar 
	public int eliminar (int idProducto);
	
	// Buscar producto por codigo
	public Productos buscarProducto(int idProducto);
	
	// Buscar producto por nombre
	public ArrayList<Productos> buscarProductoXNombre(String descripcion);
	
	// Método para generar codigo
	public int generarCodigoProd();
	
	// listar productos
	public ArrayList<Productos> listarProductos();

}
