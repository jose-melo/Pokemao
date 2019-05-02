package Poke;

public class Mapa {

	private int[][] mapa = new int[51][51];
	private int x = 1, y = 1;
	private int tile;
	
	public void geraMapa() {
		for(int i = 0; i < 50; i++)
			for(int j = 0; j < 50; j++)
				if(RNG.rolaDado(50))
					mapa[i][j] = '#';
				else
					mapa[i][j] = '.';
		
		for(int i = 0; i < 50; i++)
			mapa[0][i] = mapa[i][0] = mapa[50][i] = mapa[i][50] = 'X';
		tile = mapa[x][y];
	}
	
	
	public void cima() {
		if(y > 1) {
			y--;
			tile = mapa[x][y];
		}	
	}
	
	public void baixo() {
		if(y < 49) {
			y++;
			tile = mapa[x][y];
		}	
	}
	
	public void esq() {
		if(x > 1) {
			x--;
			tile = mapa[x][y];
		}	
	}
	
	public void dir() {
		if(x < 49) {
			x++;
			tile = mapa[x][y];
		}	
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getTile() {
		return tile;
	}
	
	public void imprimeMapa() {
		tile = mapa[x][y];
		for(int i =  0; i <= 50; i++) {
			for(int j = 0; j <= 50; j++)
				if(mapa[i][j] == tile)
					System.out.print("P ");
				else
					System.out.print((char) mapa[i][j]+" ");
			System.out.println("");
		}
	}
	
	
	
}
