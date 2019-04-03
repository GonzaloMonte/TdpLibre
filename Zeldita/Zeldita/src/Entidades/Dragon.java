package Entidades;

import Inteligencias.InteligenciaAtaqueDragon;
import Inteligencias.InteligenciaMovimientoDragon;
import Main.Celda;

public class Dragon extends Enemigo {

	public Dragon(Celda c) {
		super(c);

		im = new InteligenciaMovimientoDragon(this);
		ia = new InteligenciaAtaqueDragon(this);
	}
	
	public String queSoy() {
		return "dragon";
	}

}
