package utils;

import vista.FrmPreLoader;

public class HiloIniciarBarra extends Thread {
	
	public void run() {
		// contador inicie en 0		
	for (int i = 0; i <= 100; i++) {
		// mostrar el progreso de la barra
		FrmPreLoader.prbCarga.setValue(i);
		
		try {
			Thread.sleep(100);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Error --> en el contador");
		}
	}
		
   }

}
