package Paso4;

import java.util.LinkedList;
	 
	public class Cliente {
		public static void main(String[] args) {
			Puerta p=new Puerta();
			TorreDeControl t=new TorreDeControl();
			
			LinkedList <Barco> bList = new LinkedList <Barco>();
			for(int i=0; i<10; i++) {
				Barco b=new Barco(i, 0, p, t);
				bList.add(b);
			}
			for(int i=10; i<20; i++) {
				Barco b=new Barco(i, 1, p, t);
				bList.add(b);
			}
			
			for(int i=0; i<20; i++) {
				bList.get(i).start();
			}
			
			try {
				for (int i=0; i<20;i++) 
					bList.get(i).join();
			} catch (Exception e) {;}
		}
	}