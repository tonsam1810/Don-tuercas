package interfaces;

import java.util.ArrayList;

import entidad.Proveedores;

public interface ProveedoresInterfacesDAO {
	
		public int registrar (Proveedores p);
		
		public int actualizar(Proveedores p);
		
		public int eliminar(int codigo);

		public Proveedores buscarProveedores(int codigo);
		
		public int generarCodigoProve();
		
		public ArrayList<Proveedores> listarProveedores();

}
