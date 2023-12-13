package utils;

public class Validaciones {
	public static final String NOMBRE = "[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{3,50}";
	public static final String APELLIDOS = "[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{3,50}";
	public static final String Usuario = "[a-zA-Z]{2}[0-9]{3}"; 
	public static final String TEXTO = "[a-zA-ZáéíóúÁÉÍÓÚñÑ,;.:-_   \\s]{3,600}";
	public static final String DNI = "[0-9]{8}";
	public static final String Direccion= "[0-9a-zA-ZáéíóúÁÉÍÓÚñÑ,-_. \\s]{3,80}";
	public static final String Correo= "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String Telefono= "9[0-9]{8}";
	public static final String RUC = "[0-9]{10}";
	public static final String Codigo = "[0-9]{1,5}";  
	public static final String RazonSocial = "[0-9a-zA-ZáéíóúÁÉÍÓÚñÑ,-_. \\s]{3,80}";
}


