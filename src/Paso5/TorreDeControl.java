package Paso5;

public class TorreDeControl {
	int entrada;
	int salida;
	boolean prioridadSalida;
	
	public TorreDeControl(){
		entrada=0;
		salida=0;
		prioridadSalida=false;
	}
	
	public synchronized void permisoEntrada(Barco b) {
			System.out.println("TORRE: El barco "+ b.id+" pide permiso de entrada.");
			while (salida > 0 | prioridadSalida)
				try {
					System.out.println("TORRE: El barco "+ b.id+" esperando para entrar.");
					wait();
				} catch (InterruptedException e) {}
			entrada++;
			
	}
	
	public synchronized void finEntrada(Barco b) {
			entrada--;
			if(entrada==0) {
				System.out.println("TORRE: TODOS LOS BARCOS HAN TERMINADO DE ENTRAR!");
				notifyAll();
			}
	}
	
	public synchronized void permisoSalida(Barco b) {
		
			System.out.println("TORRE: El barco "+ b.id+" pide permiso de salida");
			prioridadSalida=true;
			while (entrada > 0)
				try {
					System.out.println("TORRE: El barco "+ b.id+" esperando para salir");
					wait();
				} catch (InterruptedException e) {}
			salida++;
		
		
	}
	
	public synchronized void finSalida(Barco b) {
			salida--;
			if(salida==0) {
				System.out.println("TORRE: TODOS LOS BARCOS HAN TERMINADO DE SALIR!");
				prioridadSalida=false;
				notifyAll();
			}
		}
	
}
