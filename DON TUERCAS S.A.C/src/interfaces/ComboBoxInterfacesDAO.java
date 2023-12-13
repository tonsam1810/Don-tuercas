package interfaces;

import java.util.ArrayList;

import entidad.Categorias;
import entidad.EstadoProducto;
import entidad.Proveedores;

public interface ComboBoxInterfacesDAO {
	
	// Listar proveedores de productos
	public ArrayList<Proveedores> listarProveedor();
	
	// Listar categorias de productos
	public ArrayList<Categorias> listarCategorias();
	
	// Listar estados de los productos
	public ArrayList<EstadoProducto> listarEstadoProd();

}
