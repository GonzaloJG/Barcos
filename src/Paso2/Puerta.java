package Paso2;

public class Puerta {
	
	public synchronized void entrar(Barco barco) {
		for (int i=0; i<3; i++)
			System.out.println("El barco "+barco.id+" entra");
	}
	
	public synchronized void salir(Barco barco) {
		for (int i=0; i<3; i++)
			System.out.println("El barco "+barco.id+" sale");
	}
}
