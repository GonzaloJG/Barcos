package Paso6;

public class Puerta {
	
	public synchronized void entrar(Barco b) {
		for (int i=0; i<3; i++)
			System.out.println("PUERTA: El barco "+b.id+" ENTRA");
	}
	
	public synchronized void salir(Barco b) {
		for (int i=0; i<3; i++)
			System.out.println("PUERTA: El barco "+b.id+" SALE");
	}
}
