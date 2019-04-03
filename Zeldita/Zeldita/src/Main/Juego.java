package Main;

public class Juego{
	public static void main(String a[]) {
		Ventana ventana = new Ventana();
		while (true) {
			ventana.actualizar();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
