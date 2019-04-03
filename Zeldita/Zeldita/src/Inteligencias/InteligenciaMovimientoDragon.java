package Inteligencias;

import java.util.Random;

import Entidades.Entidad;

public class InteligenciaMovimientoDragon extends InteligenciaMovimiento{

	public InteligenciaMovimientoDragon(Entidad ent) {
		super(ent);
	}

	public void mover() {
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
