package Inteligencias;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventoTeclado implements KeyListener{
	protected String tecla;
	protected static EventoTeclado ev;
	
	private EventoTeclado() {
		tecla = "";
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			tecla = "up";

		}
		else {
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				tecla = "down";
			}
			else {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					tecla = "left";
				}
				else {
					if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						tecla = "right";
					}
					else {
						if (e.getKeyCode() == KeyEvent.VK_SPACE) {
							tecla = " ";
						}
					}
				}
			}
		}
	}
	
	public String getTecla() {
		return tecla;
	}
	
	public void setTecla(String t) {
		tecla = t;
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	public static EventoTeclado getEventoTeclado() {
		if (ev==null) {
			ev=new EventoTeclado();
		}
		return ev;
	}
}
