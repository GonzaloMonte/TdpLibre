package Entidades;

import Inteligencias.InteligenciaMovimientoDisparo;
import Main.Celda;
import Main.Mapa;

public class Disparo extends Entidad{
	
	protected int vidaUtil;
	
	public Disparo(Celda c, int vidaUtilMax) {
		super(c);
		
		vidaUtil = vidaUtilMax+90;
		im = new InteligenciaMovimientoDisparo(this);
	}
	
	public void actualizar() {
		im.mover();
		vidaUtil--;
		if (vidaUtil == 0) {
			eliminar();
		}
	}
	
	public void mover() {
		im.mover();
	}

	public void eliminar() {
		Mapa.getMapa().eliminarEntidad(this);
		celda.setEntidad(null);
	}
	
	public String queSoy() {
		return "disparo";
	}
}
