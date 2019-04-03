package Entidades;

import Inteligencias.InteligenciaAtaqueAra�a;
import Inteligencias.InteligenciaMovimientoAra�a;
import Main.Celda;
import Main.Mapa;

public class Ara�a extends Enemigo{

	public Ara�a(Celda c) {
		super(c);
		
		im = new InteligenciaMovimientoAra�a(this);
		ia = new InteligenciaAtaqueAra�a(this);
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
