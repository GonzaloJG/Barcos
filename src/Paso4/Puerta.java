package Paso4;

public class Puerta {
	
	public synchronized void entrar(Barco b) {
		for (int i=0; i<3; i++)
			System.out.println("El barco "+b.id+" entra");
	}
	
	public synchronized void salir(Barco b) {
		for (int i=0; i<3; i++)
			System.out.println("El barco "+b.id+" sale");
	}
}
