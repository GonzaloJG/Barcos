package Paso6;

import java.util.concurrent.Semaphore;

public class DepositoAgua {

	int cantidad;
	Semaphore mutex;
	
	public DepositoAgua() {
		cantidad=100000;
		mutex = new Semaphore (1);
	}
	
	public void cogerAgua(BarcoPetrolero b) {
		try {
			mutex.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		b.cantidadAgua+=1000;
		cantidad-=1000;
		System.out.println("el barco "+ b.id+ " llena su deposito de agua con "+ b.cantidadAgua);
		
		mutex.release();
	}
	
	
}
