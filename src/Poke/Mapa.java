package Poke;

public class Mapa {
	private  final int tam_mapa = 8;
	private int[][] mapa = new int[tam_mapa + 1][tam_mapa + 1];
	private int x = 1, y = 1;
	private int tile;
	
	public void geraMapa() {
		for(int i = 0; i < tam_mapa; i++)
			for(int j = 0; j < tam_mapa; j++)
				if(RNG.rolaDado(50))
					mapa[i][j] = '#';
				else
					mapa[i][j] = '.';
		
		for(int i = 0; i < tam_mapa; i++)
			mapa[0][i] = mapa[i][0] = mapa[tam_mapa][i] = mapa[i][tam_mapa] = 'X';
		tile = mapa[1][1];
	}
	
	
	public void cima() {
		if(x > 1) {
			x--;
			tile = mapa[x][y];
		}	
	}
	
	public void baixo() {
		if(x < 49) {
			x++;
			tile = mapa[x][y];
		}	
	}
	
	public void dir() {
		if(y > 1) {
			y--;
			tile = mapa[x][y];
		}	
	}
	
	public void esq() {
		if(y < 49) {
			y++;
			tile = mapa[x][y];
		}	
	}
	
	public int getX() {
		return x;
	}
	
	public int getPos(int i, int j) {
		return mapa[i][j];
	}
	
	public int getY() {
		return y;
	}
	
	public int getTile() {
		return tile;
	}
	
	public void imprimeMapa() {
		for(int i =  0; i <= tam_mapa; i++) {
			for(int j = 0; j <= tam_mapa; j++)
				if(i == x && j == y)
					System.out.print("P ");
				else
					System.out.print((char) mapa[i][j]+" ");
			System.out.println("");
		}
	}
	
	
	
}
