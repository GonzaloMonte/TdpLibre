package Inteligencias;

import Entidades.Entidad;
import Main.Celda;
import Main.Mapa;

public abstract class InteligenciaMovimiento {
	protected Entidad e;
	
	public InteligenciaMovimiento(Entidad ent) {
		e = ent;
	}
	
	public abstract void mover();
	
	protected void moverArriba() {
		Celda celda = e.getCelda();
		Celda celdaSuperior = Mapa.getMapa().getCelda(celda.getI()-1, celda.getJ());
		if (celdaSuperior != null) {//No estoy en una frontera
			if (celdaSuperior.esTransitable()) {
				celdaSuperior.setEntidad(e);
				e.setCelda(celdaSuperior);
				celda.setEntidad(null);
				e.setFacing("n");
			}
		}
	}
	
	protected void moverAbajo() {
		Celda celda = e.getCelda();
		Celda celdaInferior = Mapa.getMapa().getCelda(celda.getI()+1, celda.getJ());
		if (celdaInferior != null) {//No estoy en una frontera
			if (celdaInferior.esTransitable()) {
				celdaInferior.setEntidad(e);
				e.setCelda(celdaInferior);
				celda.setEntidad(null);
				e.setFacing("s");
			}
		}
	}
	
	protected void moverDerecha() {
		Celda celda = e.getCelda();
		Celda celdaDerecha = Mapa.getMapa().getCelda(celda.getI(), celda.getJ()+1);
		if (celdaDerecha != null) {//No estoy en una frontera
			if (celdaDerecha.esTransitable()) {
				celdaDerecha.setEntidad(e);
				e.setCelda(celdaDerecha);
				celda.setEntidad(null);
				e.setFacing("e");
			}
		}
	}
	
	protected void moverIzquierda() {
		Celda celda = e.getCelda();
		Celda celdaIzquierda = Mapa.getMapa().getCelda(celda.getI(), celda.getJ()-1);
		if (celdaIzquierda != null) {//No estoy en una frontera
			if (celdaIzquierda.esTransitable()) {
				celdaIzquierda.setEntidad(e);
				e.setCelda(celdaIzquierda);
				celda.setEntidad(null);
				e.setFacing("o");
			}
		}
	}
}
