package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Productos;
import entidad.Proveedores;
import interfaces.ProveedoresInterfacesDAO;
import utils.MySQLConexion8;

public class GestionProveedoresDAO implements ProveedoresInterfacesDAO {
	
	public int registrar(Proveedores p) {
		//delaracion variables
		int res=0;
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			//paso 1: establecer la conxion con la base de datos
			con= MySQLConexion8.getConexion();
			//paso 2: determinar la instruccion SQL -- REGISTRAR
			//insert into tb_proveedores values("1","celima","2053655758","987412563","Av jesus de nazaret 345","proveedorcel@celima.com");
			String sql= "insert into tb_proveedores values(?,?,?,?,?,?);";
			//paso 3 crear objeto pstm y enviar instruccion sql
			pstm=con.prepareStatement(sql);
			//paso 4 parametros
			pstm.setInt(1, p.getCodigo());
			pstm.setString(2, p.getRazonSocial());
			pstm.setInt(3, p.getRuc());
			pstm.setInt(4, p.getTelefono());
			pstm.setString(5, p.getDireccion());
			pstm.setString(6, p.getCorreo());
			//paso 5 ejecutar la instruccion
			res= pstm.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("Error<<<<<<< en la instruccion SQL de registrar"+e.getMessage());
			}finally {
				try {
					if(pstm!= null)pstm.close();
					if(con!=null)con.close();
					
				} catch (SQLException e2) {
					System.out.println("error al cerrar la base de datos"+e2.getMessage());				
				}
			}
		return res;
	}

	@Override
	public int actualizar(Proveedores p) {
		int estado = 0;
		Connection con=null;
		PreparedStatement pstm = null;
		try {
			//1- conectarse a BD
			con = MySQLConexion8.getConexion();
			//2- definir intruccion SQL
			String sql = "update tb_proveedores set raz_social =?, ruc =?, telefono =?, direccion =?, correo =? where id_proveedores=?";
			
			//3- enviar instruccion al objeto pstm
			pstm = con.prepareStatement(sql);
			
			//4- obtener parametros
			
			pstm.setString(1, p.getRazonSocial()); 
			pstm.setInt(2, p.getRuc()); 
			pstm.setInt(3, p.getTelefono()); 
			pstm.setString(4, p.getDireccion());
			pstm.setString(5, p.getCorreo());
			pstm.setInt(6, p.getCodigo());
			
			//5- ejecutar la instruccion
			estado = pstm.executeUpdate();
						
		}catch (Exception e) {
				System.out.println("Error en la instruccion SQL - ACTUALIZAR "+ e.getMessage());
		}finally {
			try {
				if (pstm !=null) pstm.close();
				if (con != null) con.close();
							
				}catch (SQLException e2) {
					System.out.println("Error al cerrar la BD "+e2.getMessage());
				}
			}

		return estado;
	}

	@Override
	public int eliminar(int codigo) {
		int estado = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			//1
			con = MySQLConexion8.getConexion();
			//2
			String sql = "delete from tb_proveedores where id_proveedores=?";
			//3
			pstm = con.prepareStatement(sql);
			//4
			pstm.setInt(1, codigo);
			//5
			estado = pstm.executeUpdate();
							
		}catch (Exception e) {
			System.out.println("Error en la instruccion SQL - Eliminar "+e.getMessage());
		
		}finally {  
			try {
				if(pstm != null) pstm.close();
				if(con != null) con.close();
			} catch(SQLException e2){
				System.out.println("Error al cerrar la BD "+e2.getMessage());
			}
		}		
		return estado;
	}

	@Override
	public Proveedores buscarProveedores(int codigo) {
		Proveedores provee = null;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		try {
			//1. conectarse a la bd
			con = MySQLConexion8.getConexion();
			//2. establecer instrucción SQL - consultar 
			String sql = "select * from tb_proveedores where id_proveedores=?";
			//3. enviar la instrucción al objeto "pstm"
			pstm = con.prepareStatement(sql);
			//4 parametros
			pstm.setInt(1, codigo);
			//5 ejecutar la instrucción 
			res = pstm.executeQuery();
			if(res.next()) {
				provee = new Proveedores( res.getInt(1),
								   res.getString(2),
								   res.getInt(3),
								   res.getInt(4),
								   res.getString(5),
								   res.getString(6)
);		
			}
			
		} catch (Exception e) {
			System.out.println("Error >>> en la instrucción SQL - Consultar usuario"+e.getMessage());
		}finally {
			try {
				if(pstm != null)pstm.close();
				if(res != null)res.close();
				if(con != null)con.close();
				
			} catch (SQLException e2) {
				System.out.println("Error >>>> al cerrar la base de datos" +e2.getMessage());
			}
		}
		
		return provee;
		
	}

	@Override
	public int generarCodigoProve() {
		int codProv = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			// conexion con la BD
			con = MySQLConexion8.getConexion();
			
			// instruccion SQL
			String sql = "select max(id_proveedores) from tb_proveedores;";
			
			// Crear el objeto PSTM y enviamos la instruccion
			pstm = con.prepareStatement(sql);
			
			// no hay parametros
			
			// Ejecutar la instruccion
			res = pstm.executeQuery();
			
			// validar 
			if(res.next()) {
				
				codProv = (res.getInt(1)+1);
			}
					
		} catch (Exception e) {
			System.out.println("Error el generar código del proveedor "+e.getMessage());
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(res != null) res.close();
				if(con != null) con.close();
 			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD "+e2.getMessage());
			}
		}
	
		return codProv;
	}
	
	@Override
	public ArrayList<Proveedores> listarProveedores() {
		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Proveedores prov = null;
		try {
			// conexion con la BD
			con = MySQLConexion8.getConexion();
			
			// instruccion SQL
			String sql = "select * from tb_proveedores";
			
			// Crear el objeto PSTM y enviamos la instruccion
			pstm = con.prepareStatement(sql);
			
			// no hay parametros
			
			// Ejecutar la instruccion
			res = pstm.executeQuery();
			
			// bucle 
			while(res.next()) {
				prov = new Proveedores(res.getInt(1),
									   res.getString(2),
								       res.getInt(3),
								       res.getInt(4),
								       res.getString(5),
								       res.getString(6)
								       );
				lista.add(prov);
			}
					
		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL listar proveedores "+e.getMessage());
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
