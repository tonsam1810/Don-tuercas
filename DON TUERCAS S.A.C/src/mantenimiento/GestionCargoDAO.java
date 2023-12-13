package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Cargo;
import interfaces.CargointerfaceDAO;
import utils.MySQLConexion8;

public class GestionCargoDAO implements CargointerfaceDAO {

	@Override
	public ArrayList<Cargo> listarCargo() {
		ArrayList<Cargo> lista = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;	
		try {
			// 1. Establecer la conexion con la BD
			con = MySQLConexion8.getConexion();
			// 2. Establecer instruccion SQL --> consultar tabla tipo
			String sql = "SELECT * FROM tb_cargo";
			// 3. Enviar la instruccion al objeto PSTM
			pstm = con.prepareStatement(sql);
			// 4. No hay parametros
							
			// 5. Ejecutar la instruccion
			res = pstm.executeQuery();
			// 6. Declarar un objeto de tipo "Tipo" 
			Cargo cargo;
			// 7. Crear un bucle para recorrer la tabla mientras tenga registros es verdadero
			while(res.next()) {
				// 8. crear el objeto "Tipo"
				cargo = new Cargo();
				// 9. setear los objetos de la clase usuario --> asignar los registros
				cargo.setIdCargo(res.getInt(1));
				cargo.setNombCargo(res.getString(2)); 								
				// 10. Enviar los datos actualizando el arreglo	
				lista.add(cargo);							
			}
			
		} catch (Exception e) {
			System.out.println("Error en la instruccion consultar tipo "+e.getMessage());
		}finally {
			try {
				if(res != null) res.close();
				if(pstm != null) pstm.close();
				if(con != null) con.close();							
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD "+e2.getMessage());
			}
		}
		return lista;
	}

}
