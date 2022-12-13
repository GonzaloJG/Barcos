package Paso1;

public class Puerta {
	
	public void entrar(Barco barco) {
		for (int i=0; i<3; i++)
			System.out.println("El barco "+barco.id+" entra");
	}
	
	public void salir(Barco barco) {
		for (int i=0; i<3; i++)
			System.out.println("El barco "+barco.id+" sale");
	}
}
