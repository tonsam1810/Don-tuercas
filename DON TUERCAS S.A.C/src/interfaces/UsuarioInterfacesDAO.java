package interfaces;

import java.util.ArrayList;
import entidad.Usuarios;

// clase Abstracta
public interface UsuarioInterfacesDAO {

	// Determinar los Procesos que realizara la aplicaci�n
	
	// Registrar
	public int registrar(Usuarios u);
	
	// Actualizar
	public int actualizar(Usuarios u);
	
	// Eliminar
	public int eliminar(int codigo);
	
	// buscar usuario por codigo
	public Usuarios buscarUsuarios(int codigo);
	
	// Listar usuarios
	public ArrayList<Usuarios> listarUsuarios();
	
	// Validar Ingreso
	public Usuarios validarAcceso(String user, String clave);
	
	// Listar usuario por cargo
	public ArrayList<Usuarios> listarUsuariosXCargo(int cargo);
	
	// Autogenerar codigo
	public int generarCodigoUsuario();
}
