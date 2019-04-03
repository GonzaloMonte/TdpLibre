package Terrenos;

public class Tierra implements Terreno{

	public boolean esCaminable() {
		return true;
	}
	
	public String queSoy() {
		 return "tierra";
	 }
}
