package Poke;

public class ControladorDeEventos {
	
	ListaDeEventos lista = new ListaDeEventos();
	protected final int FUGIR = 0;
	protected final int TROCAR = 1;
	protected final int ITEM = 2;
	protected final int ATACAR = 3;
	protected static int[][] multiplicador = new int[19][19];
	
	static {
		
		for(int i = 1; i < 19; i++)
			for(int j = 1; j < 19; j++)
				multiplicador[i][j] = 1;
		
		
	}
	
	
	public void adicionaEvento(Evento e) {
		lista.adiciona(e);
	}
	
	
}
