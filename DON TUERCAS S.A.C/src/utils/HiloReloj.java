package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class HiloReloj extends Thread {
	
	private JLabel lblReloj;
	
	public HiloReloj(JLabel lblReloj) {
		super();
		this.lblReloj = lblReloj;
		
	}

	public void run() {
		
		while(true) {
		//1.  obtener la hora del sistema 
		 Date fecha = new Date();
		 //2. Formatear la fecha seg�n el requerimiento
		 SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
		 //3. mostrar la hora en la etiqueta "lblReloj"
		  lblReloj.setText(sdf.format(fecha));
		  
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Error -->  en la hora" + e.getMessage());
		}
		 		 
		}
	}

}
