package Main;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import Entidades.Araña;
import Entidades.Dragon;
import Entidades.Duende;
import Entidades.Entidad;
import Entidades.Personaje;
import Terrenos.Tierra;

public class Mapa {
	
	static private Mapa mapa;
	protected Celda[][] celdas;
	protected Personaje personaje;
	protected Collection<Entidad> entidades;
	protected Collection<Entidad> entidadesAEliminar;
	protected Collection<Entidad> entidadesAAgregar;
	
	private Mapa() {
		celdas = new Celda[30][30];
		for (int i = 0; i < celdas.length; i++) {
			for (int j = 0; j < celdas[0].length; j++) {
				celdas[i][j] = new Celda(i,j);
			}
		}
		entidades = new CopyOnWriteArrayList<Entidad>();
		entidadesAAgregar = new LinkedList<Entidad>();
		entidadesAEliminar = new LinkedList<Entidad>();
		poblarCeldas();
		
		celdas[15][15].setTerreno(new Tierra());
		personaje = new Personaje(celdas[15][15]);
		personaje.setCeldaPJ(personaje.getCelda());
		celdas[15][15].setEntidad(personaje);
		
		llenarColeccionEntidades();
	}
	
	private void agregarEntidades() {
		for (Entidad e : entidadesAAgregar) {
			entidades.add(e);
			Celda celda = e.getCelda();
			celdas[celda.getI()][celda.getJ()].setEntidad(e);
		}
		entidadesAAgregar.removeAll(entidadesAAgregar);
	}
	
	public void reiniciarPersonaje() {	
		celdas[15][15].setTerreno(new Tierra());
		personaje = new Personaje(celdas[15][15]);
		personaje.setCeldaPJ(personaje.getCelda());
		celdas[15][15].setEntidad(personaje);
		agregarEntidad(personaje);
	}
	
	private void eliminarEntidades() {
		for (Entidad e : entidadesAEliminar) {
			e.getCelda().setEntidad(null);
			entidades.remove(e);
		}
		entidadesAEliminar.removeAll(entidadesAEliminar);
	}
	
	public Celda getCelda(int i,int j) {
		if (i>29 || i<0 || j<0 || j>29) {
			return null;
		}
		return celdas[i][j];
	}
	
	public Personaje getPersonaje() {
		return personaje;
	}
	
	public Collection<Entidad> getEntidades() {
		return entidades;
	}
	
	static public Mapa getMapa() {
		if (mapa==null) {
			mapa=new Mapa();
		}
		return mapa;
	}
	
	private void llenarColeccionEntidades() {
		for (int i = 0; i < celdas.length; i++) {
			for (int j = 0; j < celdas[0].length; j++) {
				if (celdas[i][j].getEntidad()!=null) {
					entidades.add(celdas[i][j].getEntidad());
				}
			}
		}
	}
	
	public void actualizarMapa() {
		Iterator<Entidad> it = entidades.iterator();
		while (it.hasNext()) {
			Entidad e = it.next();
			e.actualizar();
		}
		agregarEntidades();
		eliminarEntidades();
	}
	
	private void poblarCeldas() {
		for (int i = 0; i < celdas.length; i++) {
			for (int j = 0; j < celdas[0].length; j++) {
				if (celdas[i][j].esTransitable()) {
					Random rnd = new Random();
					int num = rnd.nextInt(50);
					if (num == 0) {
						Entidad entidad = crearEntidad(celdas[i][j]);
						celdas[i][j].setEntidad(entidad);
					}
				}
			}
		}
	}
	
	public void agregarEntidad(Entidad e) {
		entidadesAAgregar.add(e);
	}
	
	public void eliminarEntidad(Entidad e) {
		entidadesAEliminar.add(e);
	}
	
	private Entidad crearEntidad(Celda c) {
		Entidad e;
		Random rnd = new Random();
		int num = rnd.nextInt(3);
		if (num == 0) {
			e = new Duende(c);
		}
		else {
			if (num == 1) {
				e = new Dragon(c);
			}
			else {
				e = new Araña(c);
			}
		}
		return e;
	}
}
