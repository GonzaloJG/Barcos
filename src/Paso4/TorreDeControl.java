package Paso4;

public class TorreDeControl {
	int entrada;
	int salida;
	boolean prioridadSalida;
	
	public TorreDeControl(){
		entrada=0;
		salida=0;
		prioridadSalida=false;
	}
	
	public void permisoEntrada(Barco b) {
		synchronized (this) {
			System.out.println("El barco "+ b.id+" pide permiso de entrada");
			while (salida > 0 | prioridadSalida)
				try {
					System.out.println("El barco "+ b.id+" esperando para entrar");
					wait();
				} catch (InterruptedException e) {}
			entrada++;
			
		}
	}
	
	public void finEntrada(Barco b) {
		synchronized (this) {
			entrada--;
			if(entrada==0)
				System.out.println("TODOS LOS BARCOS HAN TERMINADO DE ENTRAR!");
				notifyAll();
		}
	}
	
	public void permisoSalida(Barco b) {
		synchronized (this) {
			System.out.println("El barco "+ b.id+" pide permiso de salida");
			prioridadSalida=true;
			while (entrada > 0)
				try {
					System.out.println("El barco "+ b.id+" esperando para salir");
					wait();
				} catch (InterruptedException e) {}
			salida++;
		}
		
	}
	
	public void finSalida(Barco b) {
		synchronized (this) {	
			salida--;
			if(salida==0)
				System.out.println("TODOS LOS BARCOS HAN TERMINADO DE SALIR!");
				prioridadSalida=false;
				notifyAll();
		}
	}
	
}
