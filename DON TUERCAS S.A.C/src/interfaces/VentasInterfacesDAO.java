package interfaces;

import java.util.ArrayList;

import entidad.DetalleFactura;
import entidad.Factura;

public interface VentasInterfacesDAO {

	// Método para generar el nro de factura
	public int generarNumeroFactura();
	
	// Proceso venta para la transaccion
	public int realizarVenta(Factura fac , ArrayList<DetalleFactura> detFac);
}
