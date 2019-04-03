package Entidades;

import Inteligencias.InteligenciaAtaqueDuende;
import Inteligencias.InteligenciaMovimientoDuende;
import Main.Celda;

public class Duende extends Enemigo {

	public Duende(Celda c) {
		super(c);

		ia = new InteligenciaAtaqueDuende(this);
		im = new InteligenciaMovimientoDuende(this);
	}
	
	public String queSoy() {
		return "duende";
	}

}
