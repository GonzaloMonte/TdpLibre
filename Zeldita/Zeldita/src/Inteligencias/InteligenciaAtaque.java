package Inteligencias;

import Entidades.Entidad;

public abstract class InteligenciaAtaque{
	protected Entidad e;
	
	public InteligenciaAtaque(Entidad ent) {
		e = ent;
	}
	public abstract void atacar();
}
