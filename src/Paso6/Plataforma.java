package Paso6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Plataforma {

	boolean hayContenedor;
	int contenedor;	//0->azucar, 1->sal, 2->harina
	int[] index=new int [3];
	
	final Lock mutex;       
	final Condition gPuerto;
	final Condition gBarco; 
	
	public Plataforma() {
		hayContenedor=false;
		mutex=new ReentrantLock();
		gPuerto = mutex.newCondition();
		gBarco = mutex.newCondition();
		index[0]=0; index[1]=0; index[2]=0;
	}
	
	public void dejar(BarcoMercante b, int tipoContenedor) {
		mutex.lock();
		try{
			while(hayContenedor) {
				try {
					gBarco.await();
				} catch (InterruptedException e) {}
			}
			index[tipoContenedor]++;
			System.out.println("PLATAFORMA: "+index[tipoContenedor]+".- Dejando el contenedor del tipo "+tipoContenedor);
			contenedor=tipoContenedor;
			hayContenedor=true;
			gPuerto.signalAll();
			
			
		}finally {
			mutex.unlock();
		}
	}
	
	public void coger(Grua g) {
		mutex.lock();
		try{
			while(!hayContenedor || g.getId()!=contenedor) {
				try {
					gPuerto.await();
				} catch (InterruptedException e) {}
			}
			System.out.println("PLATAFORMA: Cogiendo el contenedor la Grua "+g.getId());
			hayContenedor=false;
			gBarco.signal();
			
		}finally {
			mutex.unlock();
		}
	}
}

