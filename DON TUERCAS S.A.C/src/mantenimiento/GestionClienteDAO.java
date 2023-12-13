package mantenimiento;

import java.sql.Connection; //import
import java.sql.PreparedStatement; //import
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Cliente; //a�adir
import entidad.Productos;
import entidad.Proveedores;
import interfaces.ClienteInterfaceDAO; //a�adir
import utils.MySQLConexion8;



//Aqui contiene la l�gica del mantenimiento

public class GestionClienteDAO implements ClienteInterfaceDAO{

	 
	public int registrar(Cliente c) {
		//si retorna1 es exitoso
		//diferente de 1 hay errores y no se ha registrado
		
		
		//PASO1: DECLARACION DE VARIABLES Y OBJETOS
		int res=0; //en 0 porque est� empezando
		
		Connection con = null;  //Conexion a la base de datos
		PreparedStatement pstm=null; //  metodo prepared, para las ediciones, instrucciones, procedimientos, mi instruccion SQL se podr� ejecutar
		
		try {
			
			//paso1: Establcer la conexion con la base de datos
			con = MySQLConexion8.getConexion(); //llamo a la capa utils a su clase My.. y al metodo conexion
					
			//paso2: PARA INSERTAR: insert into tb_clientes values (default, "Import Motors", "11147585", "998741562", "Av. Industrial 2210", "compras@imotors.com.pe");
						//se pone el ? porque son los lugares done se va a insertar
			String sql ="insert into tb_clientes values (?, ?, ?, ?, ?, ?);";
				
			
			//paso3: Crear el objeto pstm y enviar la variable sql
			pstm = con.prepareStatement(sql);
			
			//paso4: parametros
			pstm.setInt(1, c.getCodCliente()); //1 porque es el primer campo, entidad cliente
			pstm.setString(2, c.getRazSocial()); 
			pstm.setInt(3, c.getRUC()); 
			pstm.setInt(4, c.getTelefono()); 
			pstm.setString(5, c.getDireccion());
			pstm.setString(6, c.getCorreo());
			
			//paso5: ejecutar la instrucci�n
			res =pstm.executeUpdate(); //si es ok el res es 1
			
			
		} catch (Exception e) {
			System.out.println("Error <<<<<< en la instruccion SQL de registrar " + e.getMessage());
		}finally {
			try {
				
				if(pstm !=null)pstm.close(); //si pstm es difeenite de null se cierra
				if(con!=null)con.close(); //si con es diferente de null se cierra la conexion
				
				
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		
		return res;
	}	
		@Override
		public int actualizar(Cliente c)
		{
			int estado = 0;
			Connection con=null;
			PreparedStatement pstm = null;
				try {
					
					//1- conectarse a BD
					con = MySQLConexion8.getConexion();
					//2- definir intruccion SQL
					String sql = "update tb_clientes set raz_social =?, ruc =?, telefono =?, direccion =?, correo =? where id_clientes =?;";
					//3- enviar instruccion al objeto pstm
					pstm = con.prepareStatement(sql);
					//4- obtener parametros
							
					pstm.setString(1, c.getRazSocial()); 
					pstm.setInt(2, c.getRUC()); 
					pstm.setInt(3, c.getTelefono()); 
					pstm.setString(4, c.getDireccion());
					pstm.setString(5, c.getCorreo());
					pstm.setInt(6, c.getCodCliente());
					
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
	
	}//fin public
		
		@Override
		public int eliminar(int codcliente) {
			int estado = 0;
			Connection con = null;
			PreparedStatement pstm = null;
			try {
				//1
				con = MySQLConexion8.getConexion();
				//2
				String sql = "delete from tb_clientes where id_clientes=?";
				//3
				pstm = con.prepareStatement(sql);
				//4
				pstm.setInt(1, codcliente);
				//5
				estado = pstm.executeUpdate();
								
			
			}catch (Exception e) {
				System.out.println("Error en la instruccion SQL - Eliminar"+e.getMessage());
			
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
		public Cliente buscarCliente(int codcliente) {
			Cliente cliente = null;
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet res = null;
			try{
				//1. conectarse a la bd
				con = MySQLConexion8.getConexion();
				//2. establecer instrucción SQL - consultar 
				String sql = "select * from tb_proveedores where id_proveedores=?";
				//3. enviar la instrucción al objeto "pstm"
				pstm = con.prepareStatement(sql);
				//4 parametros
				pstm.setInt(1, codcliente);
				//5 ejecutar la instrucción 
				res = pstm.executeQuery();
				if(res.next()) {
					cliente = new Cliente( res.getInt(1),
									       res.getString(2),
									       res.getInt(3),
									       res.getInt(4),
									       res.getString(5),
									       res.getString(6)
											);	
				}
			}catch (Exception e) {
				System.out.println("Error en la instruccion SQL - consultar por codigo "+e.getMessage());
			}finally {
				try {
					if (pstm != null) pstm.close(); 
					if (res != null) res.close();
					if (con != null) con.close();
					}catch (SQLException e2) {
						System.out.println("error al cerrar la base de datos "+e2.getMessage());
				}
			}
			return cliente;
		}
		
		@Override
		public ArrayList<Cliente> buscarClienteXRazSocial(String razSocial) {
			ArrayList<Cliente> lista = new ArrayList<Cliente>();
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet res = null;
			Cliente cli = null;
			try {
				// Conexión con la BD
				con = MySQLConexion8.getConexion();
				
				// Instrucción SQL - Buscar Cliente
				String sql = "{call sp_buscarClientes(?)}";
				
				// Enviar la instrucción 
				pstm = con.prepareStatement(sql);
				
				// Parametros
				pstm.setString(1, razSocial);
				
				// Ejecutar la instruccion
				res = pstm.executeQuery();
				
				// Validar el resultado de la consulta
				while (res.next()) {
					cli = new Cliente(res.getInt(1),
									  res.getString(2),
									  res.getInt(3),
									  res.getInt(4),
									  res.getString(5),
									  res.getString(6)
									  );
									
					lista.add(cli);
				}
					
				
				
			} catch (Exception e) {
				System.out.println("Error en la instrucción SQL - Buscar Cliente "+e.getMessage());
			}finally {
				try {
					if(pstm != null) pstm.close();				
					if(con != null) con.close();
					if(res != null) res.close();
				} catch (SQLException e2) {
					System.out.println("Error al cerra la BD "+e2.getMessage());
				}
			}
			return lista;
		}
		@Override
		public int generarCodigoCliente() {
			int codClie = 0;
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet res = null;
			try {
				// conexion con la BD
				con = MySQLConexion8.getConexion();
				
				// instruccion SQL
				String sql = "select max(id_clientes) from tb_clientes;";
				
				// Crear el objeto PSTM y enviamos la instruccion
				pstm = con.prepareStatement(sql);
				
				// no hay parametros
				
				// Ejecutar la instruccion
				res = pstm.executeQuery();
				
				// validar 
				if(res.next()) {					
					codClie = (res.getInt(1)+1);
				}
						
			} catch (Exception e) {
				System.out.println("Error el generar código del cliente "+e.getMessage());
			}finally {
				try {
					if(pstm != null) pstm.close();
					if(res != null) res.close();
					if(con != null) con.close();
	 			} catch (SQLException e2) {
					System.out.println("Error al cerrar la BD "+e2.getMessage());
				}
			}
			
			return codClie;
		}
		@Override
		public ArrayList<Cliente> listarClientes() {
			ArrayList<Cliente> lista = new ArrayList<Cliente>();
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet res = null;
			Cliente clie = null;
			try {
				// conexion con la BD
				con = MySQLConexion8.getConexion();
				
				// instruccion SQL
				String sql = "select * from tb_clientes";
				
				// Crear el objeto PSTM y enviamos la instruccion
				pstm = con.prepareStatement(sql);
				
				// no hay parametros
				
				// Ejecutar la instruccion
				res = pstm.executeQuery();
				
				// bucle 
				while(res.next()) {
					clie = new Cliente(res.getInt(1),
									   res.getString(2),
									   res.getInt(3),
									   res.getInt(4),
									   res.getString(5),
									   res.getString(6)
									   );
					lista.add(clie);
				}
						
			} catch (Exception e) {
				System.out.println("Error en la instruccion SQL listar clientes "+e.getMessage());
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
		
		
}//fin