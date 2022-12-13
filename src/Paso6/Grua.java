package Paso6;

public class Grua implements Runnable{
	int id;
	Plataforma p;
	
	public Grua(int id, Plataforma p){
		this.id=id;
		this.p=p;
	}
	
	public int getId() {
		return id;
	}
	
	public void run() {
		while(true)
			p.coger(this);
	}
}
