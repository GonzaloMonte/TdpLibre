package Main;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Inteligencias.EventoTeclado;

public class Ventana extends JFrame {
	protected KeyListener eventoTeclado;
	protected Clip audioFondo;
	protected JLabel[][] celdas;
	protected JPanel panelPrincipal;
	protected Mapa mapa;
	
	public Ventana() {
		super("ZELDITA");
		try {
			audioFondo = AudioSystem.getClip();
			audioFondo.open(AudioSystem.getAudioInputStream(new File("src/sonido/fondo.wav")));
			audioFondo.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		eventoTeclado = EventoTeclado.getEventoTeclado();
		mapa = Mapa.getMapa();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(700,700));
		
		iniciarGUI();
		setVisible(true);
	}
	
	private void iniciarGUI() {
		this.setLayout(new GridLayout(1,1));
		this.setResizable(false);
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(30,30));
		iniciarMatriz();
		this.add(panelPrincipal);
		this.addKeyListener(eventoTeclado);
	}
	
	private void iniciarMatriz() {
		celdas = new JLabel[30][30];
		for (int i=0;i<celdas.length;i++) {
			for (int j=0;j<celdas[0].length;j++) {
				celdas[i][j] = new JLabel();
				String queSoy = Mapa.getMapa().getCelda(i,j).queSoy();
				celdas[i][j].setIcon(new ImageIcon("src/img/"+queSoy+".jpg"));
				panelPrincipal.add(celdas[i][j]);
			}
		}
	}
	
	public void actualizar() {
		mapa.actualizarMapa();
		for (int i=0;i<celdas.length;i++) {
			for (int j=0;j<celdas[0].length;j++) {
				String queSoy = Mapa.getMapa().getCelda(i,j).queSoy();
				celdas[i][j].setIcon(new ImageIcon("src/img/"+queSoy+".jpg"));
			}
		}
	}
}
