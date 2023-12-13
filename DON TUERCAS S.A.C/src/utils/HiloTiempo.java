package utils;

import javax.swing.JFrame;
import javax.swing.JLabel;

import vista.Logueo;

public class HiloTiempo extends Thread {
	
	private JLabel lblTiempo;
	private JFrame ventana;
	
	public HiloTiempo(JLabel lblTiempo, JFrame ventana) {
		super();
		this.lblTiempo = lblTiempo;
		this.ventana = ventana;
	}

	public void run() {
		
		// contador inicialice en 10 		
		for (int i = 60; i >= 0; i--) {
			// mostrar el contador en el JLabel "lblTiempo"
			lblTiempo.setText(i + "s");
			//System.out.println(i + "s");
			// pausa
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Error en la pausa del contador" +e.getMessage());
			}
		}
		// cerrar el formulario
		ventana.dispose();
	}

}
