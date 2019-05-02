package Poke;

public class Mapa {

	private int[][] mapa = new int[51][51];
	private int x = 1, y = 1;
	private int tile;
	
	public void cima() {
		if(y > 1) {
			y--;
			tile = mapa[x][y];
		}	
	}
	
	
	
}
