package Inteligencias;

import java.util.Random;

import Entidades.Entidad;

public class InteligenciaMovimientoDuende extends InteligenciaMovimiento{
	protected int mareo;
	public InteligenciaMovimientoDuende(Entidad ent) {
		super(ent);
		
		mareo = 2;
	}

	public void mover() {
		if (mareo == 0) {
			moverHaciaPersonaje();
			mareo = 3;
		}
		else {
			muevoAlAzar();
		}
		mareo--;
	}
	
	private void moverHaciaPersonaje() {
		int iPer = e.getCeldaPJ().getI();
		int jPer = e.getCeldaPJ().getJ();
		int i = e.getCelda().getI();
		int j = e.getCelda().getJ();
		if (i>iPer) {
			moverIzquierda();
		}
		else {
			if (i<iPer) {
				moverDerecha();
			}
			else {
				if (j>jPer) {
					moverAbajo();
				}
				else {
					if (j<jPer) {
						moverArriba();
					}
				}
			}
		}
	}
	
	private void muevoAlAzar() {
		Random rnd = new Random();
		int num = rnd.nextInt(4);
		if (num == 0) {
			moverArriba();
		}
		else {
			if (num == 1) {
				moverAbajo();
			}
			else {

				if (num == 2) {
					moverDerecha();
				}
				else {
					if (num == 3) {
						moverIzquierda();
					}
				}
			}
		}
	}

}
