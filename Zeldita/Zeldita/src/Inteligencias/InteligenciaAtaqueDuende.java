package Inteligencias;

import Entidades.Disparo;
import Entidades.Entidad;
import Main.Celda;
import Main.Mapa;

public class InteligenciaAtaqueDuende extends InteligenciaAtaque{

	public InteligenciaAtaqueDuende(Entidad ent) {
		super(ent);
	}

	public void atacar() {
		switch (e.getFacing()) {
		case "n" : {
			atacarArriba();
			break;
		}
		case "s" : {
			atacarAbajo();
			break;
		}
		case "e" : {
			atacarDerecha();
			break;
		}
		case "o" : {
			atacarIzquierda();
			break;
		}
		}
	}
	
	protected void atacarArriba() {
		Celda celda = e.getCelda();
		Celda celdaSiguiente = Mapa.getMapa().getCelda(celda.getI()-1, celda.getJ());
		if (celdaSiguiente!=null && celdaSiguiente.getTerreno().esCaminable()) {
			if (celdaSiguiente.getEntidad() == null) {
				Disparo disparo = new Disparo(celdaSiguiente,5);
				disparo.setFacing("n");
				Mapa.getMapa().getEntidades().add(disparo);
			}
			else {
				celdaSiguiente.getEntidad().eliminar();
			}
		}
	}
	
	protected void atacarAbajo() {
		Celda celda = e.getCelda();
		Celda celdaSiguiente = Mapa.getMapa().getCelda(celda.getI()+1, celda.getJ());
		if (celdaSiguiente!=null && celdaSiguiente.getTerreno().esCaminable()) {
			if (celdaSiguiente.getEntidad() == null) {
				Disparo disparo = new Disparo(celdaSiguiente,5);
				disparo.setFacing("s");
				Mapa.getMapa().getEntidades().add(disparo);
			}
			else {
				celdaSiguiente.getEntidad().eliminar();
			}
		}
	}

	protected void atacarIzquierda() {
		Celda celda = e.getCelda();
		Celda celdaSiguiente = Mapa.getMapa().getCelda(celda.getI(), celda.getJ()-1);
		if (celdaSiguiente!=null && celdaSiguiente.getTerreno().esCaminable()) {
			if (celdaSiguiente.getEntidad() == null) {
				Disparo disparo = new Disparo(celdaSiguiente,5);
				disparo.setFacing("o");
				Mapa.getMapa().getEntidades().add(disparo);
			}
			else {
				celdaSiguiente.getEntidad().eliminar();
			}
		}
	}

	protected void atacarDerecha() {
		Celda celda = e.getCelda();
		Celda celdaSiguiente = Mapa.getMapa().getCelda(celda.getI(), celda.getJ()+1);
		if (celdaSiguiente!=null && celdaSiguiente.getTerreno().esCaminable()) {
			if (celdaSiguiente.getEntidad() == null) {
				Disparo disparo = new Disparo(celdaSiguiente,5);
				disparo.setFacing("e");
				Mapa.getMapa().agregarEntidad(disparo);
			}
			else {
				celdaSiguiente.getEntidad().eliminar();
			}
		}
	}

}
