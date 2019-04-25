package Poke;

abstract class Evento {

	protected Treinador ator, alvo;
	protected int tipoDeEvento;
	
	public Evento(Treinador ator, Treinador alvo, int tipoDeEvento){
		this.ator = ator;
		this.alvo = alvo;
		this.tipoDeEvento = tipoDeEvento;
	}		
	
	public Treinador getAtor() {
		return ator;
	}
	
	public int getTipoDeEvento() {
		return tipoDeEvento;
	}
	
	
	abstract void executa();
	
}
