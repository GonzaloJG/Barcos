package Paso3;

public class TorreDeControl {
	int entrada;
	int salida;
	
	public TorreDeControl(){
		entrada=0;
		salida=0;
	}
	
	public void permisoEntrada(Barco b) {
		synchronized (this) {	
			while (salida > 0)
				try {
					wait();
				} catch (InterruptedException e) {}
			entrada++;
			System.out.println("El barco "+ b.id+" pide permiso de entrada");
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
			while (entrada > 0)
				try {
					wait();
				} catch (InterruptedException e) {}
			salida++;
			System.out.println("El barco "+ b.id+" pide permiso de salida");
		}
		
	}
	
	public void finSalida(Barco b) {
		synchronized (this) {	
			salida--;
			if(salida==0)
				System.out.println("TODOS LOS BARCOS HAN TERMINADO DE SALIR!");
				notifyAll();
		}
	}
	
}
