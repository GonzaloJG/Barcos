package Paso5;

public class Barco implements Runnable{
	int id;
	int direction;	//si es 0 el barco entra, 1 el barco sale
	Puerta p;
	TorreDeControl t;
	
	public Barco(int id, int direction, Puerta p, TorreDeControl torre) {
		this.id=id;
		this.direction=direction;
		this.p=p;
		this.t=torre;
	}
	
	@Override
	public void run() {
		if(direction==0){
			t.permisoEntrada(this);
			p.entrar(this);
			t.finEntrada(this);
			
		} else {
			t.permisoSalida(this);
			p.salir(this);
			t.finSalida(this);
			
		}
	}
}
