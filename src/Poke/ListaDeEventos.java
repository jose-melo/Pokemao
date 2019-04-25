package Poke;

public class ListaDeEventos {

	private Evento[] FilaDeEventos = new Evento[100];
	private int num_eventos, idx;
	
	public void adiciona(Evento evento) {
		if(num_eventos != 100) {
			FilaDeEventos[idx++] = evento;
			num_eventos++;
		}
	}
	
	public boolean estaVazia() {
		if(num_eventos == 0) 
			return true;
		return false;
	}
	
	public void remove() {
		if(num_eventos != 0) {
			idx--;
			num_eventos--;
		}
	}
	
	public Evento inicioDaFila() {
		if(!estaVazia())
			return FilaDeEventos[0];
		return null;
	}
	
	public Evento fimDaFila() {
		if(num_eventos != 100)
			return FilaDeEventos[idx - 1];
		return null;
	}	
	
	
}
