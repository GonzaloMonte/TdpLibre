package Inteligencias;

import Entidades.Entidad;
import Main.Celda;
import Main.Mapa;

public class InteligenciaMovimientoDisparo extends InteligenciaMovimiento{
	
	public InteligenciaMovimientoDisparo(Entidad ent) {
		super(ent);
	}

	public void mover() {
		String mirando = e.getFacing();
		if (mirando.equals("n")) {
			moverArriba();
		}
		else {
			if (mirando.equals("s")) {
				moverAbajo();
			}
			else {
				if (mirando.equals("e")) {
					moverDerecha();
				}
				else {
					if (mirando.equals("o")) {
						moverIzquierda();
					}
				}
			}
		}
	}
	
	protected void moverArriba() {
		Celda celda = e.getCelda();
		Celda celdaSuperior = Mapa.getMapa().getCelda(celda.getI()-1, celda.getJ());
		if (celdaSuperior != null) {//No estoy en una frontera
			if (celdaSuperior.getTerreno().esCaminable()) {
				if (celdaSuperior.getEntidad()== null) {
					celdaSuperior.setEntidad(e);
					e.setCelda(celdaSuperior);
					celda.setEntidad(null);
				}
				else {
					celdaSuperior.getEntidad().eliminar();
					e.eliminar();
				}
			}
			else {
				e.eliminar();
			}
		}
		else {
			e.eliminar();
		}
	}
	
	protected void moverAbajo() {
		Celda celda = e.getCelda();
		Celda celdaInferior = Mapa.getMapa().getCelda(celda.getI()+1, celda.getJ());
		if (celdaInferior != null) {//No estoy en una frontera
			if (celdaInferior.getTerreno().esCaminable()) {
				if (celdaInferior.getEntidad()== null) {
					celdaInferior.setEntidad(e);
					e.setCelda(celdaInferior);
					celda.setEntidad(null);
				}
				else {
					celdaInferior.getEntidad().eliminar();
					e.eliminar();
				}
			}
			else {
				e.eliminar();
			}
		}
		else {
			e.eliminar();
		}
	}
	
	protected void moverDerecha() {
		Celda celda = e.getCelda();
		Celda celdaDerecha = Mapa.getMapa().getCelda(celda.getI(), celda.getJ()+1);
		if (celdaDerecha != null) {//No estoy en una frontera
			if (celdaDerecha.getTerreno().esCaminable()) {
				if (celdaDerecha.getEntidad()== null) {
					celdaDerecha.setEntidad(e);
					e.setCelda(celdaDerecha);
					celda.setEntidad(null);
				}
				else {
					celdaDerecha.getEntidad().eliminar();
					e.eliminar();
				}
			}
			else {
				e.eliminar();
			}
		}
		else {
			e.eliminar();
		}
	}
	
	protected void moverIzquierda() {
		Celda celda = e.getCelda();
		Celda celdaIzquierda = Mapa.getMapa().getCelda(celda.getI(), celda.getJ()-1);
		if (celdaIzquierda != null) {//No estoy en una frontera
			if (celdaIzquierda.getTerreno().esCaminable()) {
				if (celdaIzquierda.getEntidad()== null) {
					celdaIzquierda.setEntidad(e);
					e.setCelda(celdaIzquierda);
					celda.setEntidad(null);
				}
				else {
					celdaIzquierda.getEntidad().eliminar();
					e.eliminar();
				}
			}
			else {
				e.eliminar();
			}
		}
		else {
			e.eliminar();
		}
	}
}
