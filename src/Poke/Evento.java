package Poke;

abstract class Evento {

	private String ator, tipoDeEvento;
	public String getAtor() {
		return ator;
	}
	
	abstract void executa();
	
}
