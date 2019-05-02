package Poke;

public class ControladorDeEventos extends Constante{
	
	ListaDeEventos lista = new ListaDeEventos();
	protected static double[][] multiplicador = new double[19][19];
	
	static {
		for(int i = 1; i < 19; i++)
			for(int j = 1; j < 19; j++)
				multiplicador[i][j] = 1;
	}
	
	
	public void adicionaEvento(Evento e) {
		lista.adiciona(e);
	}
	
	
}
