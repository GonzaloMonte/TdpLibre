package Inteligencias;

import Entidades.Entidad;

public class InteligenciaMovimientoPersonaje extends InteligenciaMovimiento{

	protected EventoTeclado et;
	
	public InteligenciaMovimientoPersonaje(Entidad ent) {
		super(ent);
		
		et = EventoTeclado.getEventoTeclado();
	}
	
	public EventoTeclado getEventoTeclado() {
		return et;
	}
	
	public void mover() {
		String tecla = et.getTecla();
		if (tecla=="up") {
			moverArribaP();
			et.setTecla("");
		}
		else {
			if (tecla=="down") {
				moverAbajoP();
				et.setTecla("");
			}
			else {
				if (tecla=="left") {
					moverIzquierdaP();
					et.setTecla("");
				}
				else {
					if (tecla=="right") {
						moverDerechaP();
						et.setTecla("");
					}
				}
			}
		}
		
	}
	
	private void moverAbajoP() {
		if (e.getFacing()=="s") {
			moverAbajo();
		}
		else {
			e.setFacing("s");
		}
	}
	
	private void moverArribaP() {
		if (e.getFacing()=="n") {
			moverArriba();
		}
		else {
			e.setFacing("n");
		}
	}
	
	private void moverDerechaP() {
		if (e.getFacing()=="e") {
			moverDerecha();
		}
		else {
			e.setFacing("e");
		}
	}
	
	private void moverIzquierdaP() {
		if (e.getFacing()=="o") {
			moverIzquierda();
		}
		else {
			e.setFacing("o");
		}
	}

}
