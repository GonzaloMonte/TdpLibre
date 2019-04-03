package Entidades;

import Inteligencias.InteligenciaAtaquePersonaje;
import Inteligencias.InteligenciaMovimiento;
import Inteligencias.InteligenciaMovimientoPersonaje;
import Main.Celda;
import Main.Mapa;

public class Personaje extends Entidad{
	
	public Personaje(Celda c) {
		super(c);
		
		ia = new InteligenciaAtaquePersonaje(this);
		im = new InteligenciaMovimientoPersonaje(this);
	}
	
	public void actualizar() {
		im.mover();
		ia.atacar();
	}
	
	public InteligenciaMovimiento getInteligenciaMovimiento() {
		return im;
	}
	
	public void eliminar() {
		celda.setEntidad(null);
		Mapa.getMapa().eliminarEntidad(this);
		Mapa.getMapa().reiniciarPersonaje();
	}
	
	public String queSoy() {
		return "personaje";
	}
}
