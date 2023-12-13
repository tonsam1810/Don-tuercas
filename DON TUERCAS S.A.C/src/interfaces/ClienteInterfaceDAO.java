package interfaces;

import java.util.ArrayList;

import entidad.Cliente;

//Clase Abstracta
public interface ClienteInterfaceDAO {

	//Se determina los procesos (metodos) que reaizar� la aplicaci�n
	//Si el proceso de la BD es exitoso te devuelve 1
	
	// PASO 1: metodos 
	//REGISTRAR
	public int registrar(Cliente c);
	//ACTUALIZAR
	public int actualizar(Cliente c);
	//Eliminar
	public int eliminar(int codigo);
	//Buscar Usuario por codigo
	public Cliente buscarCliente(int codigo);
	
	// Buscar cliente por nombre
	public ArrayList<Cliente> buscarClienteXRazSocial(String razSocial);
	
	// Generar Codigo automatico
	public int generarCodigoCliente();
	
	// listar clientes
	public ArrayList<Cliente> listarClientes();
}//fin