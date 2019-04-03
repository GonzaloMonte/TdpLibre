package Inteligencias;

import Entidades.Entidad;
import Main.Celda;
import Main.Mapa;

public class InteligenciaAtaqueAraña extends InteligenciaAtaque{

	public InteligenciaAtaqueAraña(Entidad ent) {
		super(ent);
		
	}

	public void atacar() {
		Celda celda = e.getCelda();
		Celda celdaObjetivo = Mapa.getMapa().getCelda(celda.getI()-1, celda.getJ());
		if (celdaObjetivo == null || !celdaObjetivo.estaOcupada()) {
			celdaObjetivo = Mapa.getMapa().getCelda(celda.getI()+1, celda.getJ());
			if (celdaObjetivo == null || !celdaObjetivo.estaOcupada()) {
				celdaObjetivo = Mapa.getMapa().getCelda(celda.getI(), celda.getJ()-1);
				if (celdaObjetivo == null || !celdaObjetivo.estaOcupada()) {
					celdaObjetivo = Mapa.getMapa().getCelda(celda.getI(), celda.getJ()+1);
				}
			}
		}
		if (celdaObjetivo!=null && celdaObjetivo.getEntidad()!=null) {
			celdaObjetivo.getEntidad().eliminar();
			celdaObjetivo.setEntidad(e);
			e.setCelda(celdaObjetivo);
			celda.setEntidad(null);
		}
	}

}
