package Entidades;

import Main.Celda;
import Main.Mapa;

public abstract class Enemigo extends Entidad{
	protected int contadorDisparo;
	protected final int contadorDisparoMax = 5;
	
	public Enemigo(Celda c) {
		super(c);
		contadorDisparo = 0;
	}
	
	public void actualizar() {
		contadorDisparo++;
		if (contadorDisparo == contadorDisparoMax) {
			atacar();
			contadorDisparo = 0;
		}
		else {
			mover();
		}
		celdaPJ = Mapa.getMapa().getPersonaje().getCelda();
	}
	
	public void mover() {
		im.mover();
	}

	public void atacar() {
		ia.atacar();
	}
	
	public void eliminar() {
		Mapa.getMapa().eliminarEntidad(this);
		celda.setEntidad(null);
	}

}
