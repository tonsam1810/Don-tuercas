package entidad;

public class Cliente {
	//PASO1: ATRIBUTOS de la base de datos
	
		private int CodCliente;
		private String RazSocial; 
		private int RUC;
		private int Telefono;
		private String Direccion;
		private String Correo;
				

		//PASO2: CONSTRUCTOR : siempre es bueno crear dos constructores, 1vacio y otro cn campos
		public Cliente() {
			
			// constructor vacio con superclass
		}



		public Cliente(int codigo, String razsocial, int ruc, int telefono, String direccion, String correo)
		{
			
			this.CodCliente = codigo;
			this.RazSocial = razsocial;
			this.RUC = ruc;
			this.Telefono = telefono;
			this.Direccion = direccion;
			this.Correo = correo;
			
		}

		
		//PASO3: METODOS DE ACCESO GET/sET
		
		public int getCodCliente() {
			return CodCliente;
		}

		
		public void setCodCliente(int codigo) {
			this.CodCliente = codigo;
		}
		
		
		public String getRazSocial() {
			return RazSocial;
		}



		public void setRazSocial(String razSocial) {
			this.RazSocial = razSocial;
		}



		public int getRUC() {
			return RUC;
		}



		public void setRUC(int ruc) {
			this.RUC = ruc;
		}



		public int getTelefono() {
			return Telefono;
		}



		public void setTelefono(int telefono) {
			this.Telefono = telefono;
		}



		public String getDireccion() {
			return Direccion;
		}



		public void setDireccion(String direccion) {
			this.Direccion = direccion;
		}



		public String getCorreo() {
			return Correo;
		}



		public void setCorreo(String correo) {
			this.Correo = correo;
		}

			
		
		//PASO 4: OPERACIONES ADICIONALES
		
	
		
		
		
		
	}//Fin
