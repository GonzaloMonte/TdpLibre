package Entidades;

import java.util.Random;

import Inteligencias.InteligenciaAtaque;
import Inteligencias.InteligenciaMovimiento;
import Main.Celda;

public abstract class Entidad {
	protected InteligenciaAtaque ia;
	protected InteligenciaMovimiento im;
	protected int vida;
	protected Celda celda;
	protected Celda celdaPJ;
	protected String facing;
	protected int r;
	public Entidad(Celda c) {
		vida = 1;
		celda = c;
		
		facing = "s";
		
		Random rnd = new Random();
		
		r = rnd.nextInt(9);
	}
	
	public String getFacing() {
		return facing;
	}
	
	public void setFacing(String s) {
		facing = s;
	}
	
	public abstract void actualizar();
	public abstract void eliminar();
	public abstract String queSoy();
	
	public Celda getCelda() {
		return celda;
	}
	
	public void setCelda(Celda c) {
		celda = c;
	}
	
	public void setCeldaPJ(Celda pos) {
		celda = pos;
	}
	
	public Celda getCeldaPJ() {
		return celdaPJ;
	}
}
