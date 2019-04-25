package Poke;

public class ControladorPokemon extends ControladorDeEventos{

	
	Treinador treinador1, treinador2;

	public boolean prioriza(Evento e1, Evento e2) {
		if(e1.getTipoDeEvento() > e2.getTipoDeEvento())
			return true;
		return false;
	}
	
	
	
	private class Atacar extends Evento{
		
		private int ataque;
		
		public Atacar(Treinador t1, Treinador t2, int atack) {
			super(t1, t2, ATACAR);
			treinador1 = t1;
			treinador2 = t2;
			ataque = atack;
		}
		
		void executa() {
			
				Pokemon ator_poke = ator.getPokeAtual();
				Pokemon alvo_poke = alvo.getPokeAtual();
				Ataque att = ator_poke.getAtaque();
				int dano = att.getDano();
				alvo_poke.atualizaVida(-dano);
				
				
				
			
		}
	}	
	
	static executaRound() {
		
		Atacar ataque = new Atacar();
		
		ataque.executa(treinador1, treinador2, 4);
		
	}
	
	
	
	
}
