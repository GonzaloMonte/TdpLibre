package Entidades;

import Inteligencias.InteligenciaAtaqueAraña;
import Inteligencias.InteligenciaMovimientoAraña;
import Main.Celda;
import Main.Mapa;

public class Araña extends Enemigo{

	public Araña(Celda c) {
		super(c);
		
		im = new InteligenciaMovimientoAraña(this);
		ia = new InteligenciaAtaqueAraña(this);
	}
	
	public void actualizar() {
		int i = celda.getI();
		int j = celda.getJ();
		atacar();
		int iNuevo = celda.getI();
		int jNuevo = celda.getJ();
		boolean cambio = i!=iNuevo || j!=jNuevo;
		if (!cambio) {
			mover();
		}
		celdaPJ = Mapa.getMapa().getPersonaje().getCelda();
	}

	public String queSoy() {
		return "arana";
	}

}
