package Paso5;

public class BarcoMercante extends Barco {
	int contenedor[]=new int [3];
	Plataforma plat;
	
	public BarcoMercante(int id, int direction, Puerta p, TorreDeControl torre, int azucar, int sal, int harina, Plataforma plat ){
		super(id, direction, p, torre );
		this.contenedor[0]=azucar;
		this.contenedor[1]=sal;
		this.contenedor[2]=harina;
		this.plat=plat;
	}
	
	public boolean hayContendor (int valor) {
		switch(valor) {
		case 0:
			if(contenedor[0]==0) {
				return false;
			}
		case 1:
			if(contenedor[1]==0) {
				return false;
			}
		case 2:
			if(contenedor[2]==0) {
				return false;
			}
		}	
		return true;
	}
	
	@Override
	public void run() {
		if(super.direction==0) {
			
			t.permisoEntrada(this);
			p.entrar(this);
			t.finEntrada(this);
			
			System.out.println("BARCO MERCANTE: DESCARGANDO BARCO CON ID: "+id);
			//Azucar
			while(hayContendor(0)) {
				plat.dejar(this, 0);
				contenedor[0]--;
			}
			
			//Sal
			while(hayContendor(1)) {
				plat.dejar(this, 1);
				contenedor[1]--;
			}
			
			//Harina
			while(hayContendor(2)) {
				plat.dejar(this, 2);
				contenedor[2]--;
			}
			
			System.out.println("BARCO MERCANTE: FIN DE DESCARGA DEL BARCO CON ID: "+id);
			
			for(int i=0; i<3; i++) {
				plat.index[i]=0;
			}
			
			t.permisoSalida(this);
			p.salir(this);
			t.finSalida(this);
		}
	}
}
