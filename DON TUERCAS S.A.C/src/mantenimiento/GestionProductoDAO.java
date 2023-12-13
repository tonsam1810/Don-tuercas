package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import entidad.Productos;
import interfaces.ProductoInterfacesDAO;
import utils.MySQLConexion8;

public class GestionProductoDAO implements ProductoInterfacesDAO{

	@Override
	public int registrar(Productos p) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			// paso 1: establecer la conexión con la base de datos
			con = MySQLConexion8.getConexion();
			
			// paso 2: determinar la instrucción para registrar
			String sql = "insert into tb_productos values (?,?,?,?,?,?,?);";
			
			// paso 3: crear el objeto pstm y enviar la variable SQL
			pstm = con.prepareStatement(sql);
			
			// paso 4: parametros
			pstm.setInt(1, p.getIdProducto());
			pstm.setString(2, p.getDescripcion());
			pstm.setInt(3, p.getProveedores());
			pstm.setInt(4, p.getStock());
			pstm.setDouble(5, p.getPrecio());
			pstm.setInt(6, p.getIdCategoria());
			pstm.setInt(7, p.getEstadoProd());
			
			// paso 5: ejecutar la instrucci�n
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - registrar "+ e.getMessage());
			
		}finally {
			try {
				if(pstm != null)
					pstm.close();
				if(con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos "+e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public int actualizar(Productos p) {
		int estado = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			// 1. 
			con = MySQLConexion8.getConexion();
			
			// 2. instruccion SQL			
			String sql = "update tb_productos set descripcion =?, id_proveedores =?, stock =?, precio =?, id_categoria =?, id_estadoProd =? where id_productos =?";
			
			// 3. 
			pstm = con.prepareStatement(sql);
			
			// 4. parametros
			pstm.setString(1, p.getDescripcion());
			pstm.setInt(2, p.getProveedores());
			pstm.setInt(3, p.getStock());
			pstm.setDouble(4, p.getPrecio());
			pstm.setInt(5, p.getIdCategoria());
			pstm.setInt(6, p.getEstadoProd());
			pstm.setInt(7, p.getIdProducto());
			
			// 5.
			estado = pstm.executeUpdate();
					
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - ACTUALIZAR "+e.getMessage());
		}finally {
			try { 
				if(pstm != null) pstm.close();
				if(con != null) con.close();
				
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD "+e2.getMessage());
			}
		}
				
				
		
		return estado;
	}

	@Override
	public int eliminar(int idProducto) {
		int estado = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			// 1. Establecer conexion 
			con = MySQLConexion8.getConexion();
			
			// 2. instruccion SQL
			String sql = "delete from tb_productos where id_productos = ?";
			
			// 3. crear el objeto pstm y enviar instrucción SQL
			pstm = con.prepareStatement(sql);
			
			// 4. parametros
			pstm.setInt(1, idProducto);
			
			// 5. Ejecutar
			estado = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - ELIMINAR "+e.getMessage());
		}finally {
			try {
				if(pstm != null)pstm.close();					
				if(con != null)con.close();					
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD "+e2.getMessage());
			}
		}
		return estado;
	}

	@Override
	public Productos buscarProducto(int idProducto) {
		Productos producto = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			// 1.
			con = MySQLConexion8.getConexion();
			// 2. SQL -- consultar por codigo
			String sql = "select * from tb_productos where id_productos=?";
			
			// 3.
			pstm = con.prepareStatement(sql);
			
			// 4.
			pstm.setInt(1, idProducto);
			
			// 5. ejecución de la instrucción -- consulta
			res = pstm.executeQuery();
			
			// 6. validar el resultado de la consulta
			if(res.next()) { // retorna true mientras exista info en la consulta
				// asignar valores a los atributos de la clase usuario
				producto = new Productos(res.getInt(1), 
									   	res.getString(2),
									   	res.getInt(3), 
									   	res.getInt(4), 
									   	res.getDouble(5), 
									   	res.getInt(6),
									   	res.getInt(7)
									   	);
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - consultar por código "+e.getMessage());
		}finally {
			try {
				if(pstm != null) pstm.close();				
				if(res != null) res.close();					
				if(con != null) con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD "+e2.getMessage());
			}
		}
		return producto;
	}

	@Override
	public ArrayList<Productos> buscarProductoXNombre(String descripcion) {
		ArrayList<Productos> lista = new ArrayList<Productos>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Productos prod = null;
		try {
			// 1. Conexión con la BD
			con = MySQLConexion8.getConexion();
			
			// 2. instruccion SQL		
			String sql = "{call sp_buscarProductos(?)}";
			
			// 3. Crear el objeto PSTM y enviar la instruccion SQL
			pstm = con.prepareStatement(sql);
			
			// 4. parametros
			pstm.setString(1, descripcion);
					
			// 5.
			res = pstm.executeQuery();
			// 6. 
			while (res.next()) {
				prod = new Productos(res.getInt(1), 
									res.getString(2), 
									res.getInt(3), 
									res.getInt(4), 
									res.getDouble(5), 
									res.getInt(6),
									res.getInt(7)
									);
				lista.add(prod);
			}
					
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL buscar producto "+e.getMessage());
		}finally {
			try { 
				if(pstm != null) pstm.close();
				if(con != null) con.close();
				if(res != null) res.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD "+e2.getMessage());
			}
		}
		return lista;
	}

	@Override
	public int generarCodigoProd() {
		int numProd = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			// conexion con la BD
			con = MySQLConexion8.getConexion();
			
			// instruccion SQL
			String sql = "select max(id_productos) from tb_productos;";
			
			// Crear el objeto PSTM y enviamos la instruccion
			pstm = con.prepareStatement(sql);
			
			// no hay parametros
			
			// Ejecutar la instruccion
			res = pstm.executeQuery();
			
			// validar 
			if(res.next()) {
				
				numProd = (res.getInt(1)+1);
			}
					
		} catch (Exception e) {
			System.out.println("Error el generar código del producto "+e.getMessage());
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(res != null) res.close();
				if(con != null) con.close();
 			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD "+e2.getMessage());
			}
		}
		
		return numProd;
		
	}

	@Override
	public ArrayList<Productos> listarProductos() {
		ArrayList<Productos> lista = new ArrayList<Productos>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Productos prod = null;
		try {
			// conexion con la BD
			con = MySQLConexion8.getConexion();
			
			// instruccion SQL
			String sql = "select * from tb_productos";
			
			// Crear el objeto PSTM y enviamos la instruccion
			pstm = con.prepareStatement(sql);
			
			// no hay parametros
			
			// Ejecutar la instruccion
			res = pstm.executeQuery();
			
			// bucle 
			while(res.next()) {
				prod = new Productos(res.getInt(1),
								 res.getString(2),
								 res.getInt(3),
								 res.getInt(4),
								 res.getDouble(5),
								 res.getInt(6),
								 res.getInt(7)
								 );
				lista.add(prod);
			}
					
		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL listar productos"+e.getMessage());
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(res != null) res.close();
				if(con != null) con.close();
 			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD "+e2.getMessage());
			}
		}
		
		return lista;
	}

}
