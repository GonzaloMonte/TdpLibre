package Main;
import java.util.Random;

import Entidades.Entidad;
import Terrenos.Arboleda;
import Terrenos.Pastizal;
import Terrenos.Rocas;
import Terrenos.Terreno;
import Terrenos.Tierra;

public class Celda {
	protected Terreno terreno;
	protected Entidad entidad;
	protected int i,j;
	
	public Celda(int i, int j) {
		this.i = i;
		this.j = j;
		entidad = null;
		crearTerrenoAzar();
	}
	
	public void setTerreno(Terreno t) {
		terreno = t;
	}
	
	private void crearTerrenoAzar() {
		Random rnd = new Random();
		int num = rnd.nextInt(10);
		if (num >= 0 && num<=6) {
			terreno = new Tierra();
		}
		if (num == 7) {
			terreno = new Pastizal();
		}
		if (num == 8) {
			terreno = new Arboleda();
		}
		if (num == 9) {
			terreno = new Rocas();
		}
	}
	
	public void setEntidad(Entidad e) {
		entidad = e;
	}
	
	public boolean estaOcupada() {
		return entidad!=null;
	}
	public String queSoy() {
		String soy;
		if (entidad==null) {
			soy = terreno.queSoy();
		}
		else {
			soy = entidad.queSoy()+terreno.queSoy();
		}
		return soy;
	}
	
	public Terreno getTerreno() {
		return terreno;
	}
	
	public void actualizar() {
		if (entidad != null) {
			entidad.actualizar();
		}
	}
	
	public boolean esTransitable() {
		return terreno.esCaminable() && entidad==null;
	}
	
	public Entidad getEntidad() {
		return entidad;
	}
	
	public int getI() {
		return i;
	}
	
	public int getJ() {
		return j;
	}
	
}
