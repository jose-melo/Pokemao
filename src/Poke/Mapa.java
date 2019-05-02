package Poke;

public class Mapa {

	private int[][] mapa = new int[51][51];

	public void geraMapa() {
	
		for(int i = 1; i <= 50; i++)
			for(int j = 1; j <= 50; j++)
				if(RNG.rolaDado() == 1)
					mapa[i][j] = "#";
				else
					mapa[i][j] = ".";	
	
	}
	
	
	
	
}
