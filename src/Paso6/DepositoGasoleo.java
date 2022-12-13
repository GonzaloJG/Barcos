package Paso6;

import java.util.concurrent.Semaphore;

public class DepositoGasoleo {
	
		//parte de la entrada de barcos
		Semaphore [] barcos = new Semaphore[5];
		int contadorBarcos;
		boolean primero;
		
		//parte de deposito de Gasoleo
		int cantidad[]=new int[5];
		Semaphore [] lleno = new Semaphore [5];		//barcos
		Semaphore [] reponedor = new Semaphore[5]; 	//reponedor
		
	
	public DepositoGasoleo() {
		contadorBarcos=0;
		primero=true;
		
		for(int i=0; i<5;i++) {
			this.barcos[i] = new Semaphore(0);
			
			this.cantidad[i]=1000;
			this.lleno[i]=new Semaphore(0); 	
			this.reponedor[i]=new Semaphore(0);
			 
		}
	}
	
	public void dejarParsarBarco(BarcoPetrolero b) {
		if(contadorBarcos<5) {
			try {
				barcos[b.id].acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(primero) {
			primero=false;
			System.out.println("El BARCO "+b.id+" DESBLOQUEO A TODOS PARA EMPEZAR");
			for(int i=0; i<5; i++) {
				if(i!=b.id)
					barcos[i].release();
			}
		}
	}
	
	public void cogerGasoleo(BarcoPetrolero b) {
		
		b.cantidadGasoleo+=cantidad[b.id];
		cantidad[b.id]=0;
		System.out.println("el barco "+ b.id+ " llena su deposito de gasoleo con "+ b.cantidadGasoleo);
		
		
		if(cantidad[b.id]==0) {
			reponedor[b.id].release();
			try {
				lleno[b.id].acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void llenarGasoleo() {
		for(int i=0; i<5; i++) {
			try {
				reponedor[i].acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("REPONIENDO TODOS LOS DEPOSITO ");
		
		for(int i=0; i<5; i++) {
			cantidad[i]=1000;
			lleno[i].release();
		}
	}
}
