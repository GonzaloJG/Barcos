package Paso5;

import java.util.LinkedList;
	 
	public class Cliente {
		public static void main(String[] args) {
			
			  Puerta p=new Puerta();
			  TorreDeControl t=new TorreDeControl();
			  
			  Plataforma plat=new Plataforma();
			  
			  LinkedList <Thread> tList = new LinkedList <Thread>();
			  
			  for(int i=0; i<3; i++) {
				  Thread t1=new Thread(new Grua(i,plat));
				  tList.add(t1);
			  }
			  
			  BarcoMercante bar=new BarcoMercante(66, 0, p, t, 12, 20, 5, plat);
			  Thread tBM=new Thread(bar);
			  tList.add(tBM);
			  
			  for(int i=0; i<10; i++){ 
				  	Barco b=new Barco(i, 0, p, t); 
				  	Thread tBarco=new Thread(b);
				  	tList.add(tBarco);
			  } 
			  
			  for(int i=10; i<20; i++) {
				  Barco b=new Barco(i, 1, p, t); 
				  Thread tBarco=new Thread(b);
				  tList.add(tBarco); 
			  }
			  
			  for(int i=0; i<24; i++) { 
				  tList.get(i).start(); 
			  }
			  
			  try { 
				  for (int i=0; i<24;i++)	
					  tList.get(i).join();

			  } catch (Exception e) {;}
			
		}
	}