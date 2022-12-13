package Paso6;

public class Reponedor implements Runnable{
	
	DepositoGasoleo dG;
	
	public Reponedor(DepositoGasoleo dG){
		this.dG=dG;
	}
	
	public void run() {
		int i=0;
		while(i<3) {
			dG.llenarGasoleo();
			i++;
		}
	}
}
