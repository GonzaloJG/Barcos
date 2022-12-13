package Paso2;

public class Barco extends Thread{
	int id;
	int direction;	//si es 0 el barco entra, 1 el barco sale
	Puerta p;
	
	public Barco(int id, int direction, Puerta p) {
		this.id=id;
		this.direction=direction;
		this.p=p;
	}
	
	public void run() {
		if(direction==0) {
			p.entrar(this);
		} else {
			p.salir(this);
		}
	}
}
