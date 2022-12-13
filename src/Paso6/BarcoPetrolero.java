package Paso6;

public class BarcoPetrolero implements Runnable {

	final int MAX_Gasoleo=3000;
	final int MAX_Agua=5000;
	
	int id;
	int cantidadGasoleo;
	int cantidadAgua;
	DepositoGasoleo gasoleo;
	DepositoAgua agua;
	
	public BarcoPetrolero(int id, DepositoGasoleo gasoleo, DepositoAgua agua) {
		this.id=id;
		this.cantidadGasoleo=0;
		this.cantidadAgua=0;
		this.gasoleo=gasoleo;
		this.agua=agua;
		
	}
	
	public void run() {
		gasoleo.contadorBarcos++;
		gasoleo.dejarParsarBarco(this);
		
		//System.out.println("Barco "+id+" entra a zana de carga");
		
		while(cantidadGasoleo<MAX_Gasoleo) {
			gasoleo.cogerGasoleo(this);
		}
			
		while(cantidadAgua<MAX_Agua) {
			agua.cogerAgua(this);
		}	
	}
}
