package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion8 {
	// método estatico encargado de realizar la conexión a la bd "Ciberfarma"
	public static Connection getConexion() {
		// declarando un objetivo de tipo Connection
		Connection con = null;
		try {
			// establecer el driver de conexión --> "Ruta del driver" nombre del paquete
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Datos para establecer la conexión 
			// 			  "Driver:protocoloDriver:ubicación & puerto de conexión/nombreBD?/ actualización"
			String url = "jdbc:mysql://localhost:3306/don_tuercas?serverTimezone=UTC";
			
			// usuario
			String usr = "root"; // usuario
			
			// contraseña
			String psw = "mysql"; // contraseña
			
			// se envia los datos a la instruccion
			con = DriverManager.getConnection(url, usr, psw);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no Instalado!!" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error >> de conexión con la BD" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error >> general : " + e.getMessage());
		} 
		return con;
	}

}
