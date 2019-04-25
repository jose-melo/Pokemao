package Poke;

public class ControladorPokemon extends ControladorDeEventos{

	public boolean prioriza(Evento e1, Evento e2) {
		if(e1.getTipoDeEvento() > e2.getTipoDeEvento())
			return true;
		return false;
	}
	
	
	
	private class Fugir extends Evento{
		
		public Fugir(Treinador t1) {
			super(t1, null, FUGIR);
			treinador1 = t1;
		}
		
		void executa() {
			System.out.println(ator.getNome()+"fugiu!!");										
		}
	}	
	private class UsarItem extends Evento{
		
		private int index;
		private Pokemon[] festa;
		private Item item;
		
		public UsarItem(Treinador t1, Item item, int index) {
			super(t1, null, ITEM);
			this.item = item; 
			festa = ator.getFesta();
			this.index = index;
		}
		
		void executa() {
			if(festa[index].atualizaVida(item.getCura()))
				System.out.println(festa[index].getNome() + " foi curado em "+item.getCura());
			else
				System.out.println(festa[index].getNome() + " não pode ser curado.");
		}
	}	
	
	private class Trocar extends Evento{
		
		private int index;
		
		public Trocar(Treinador t1, int index) {
			super(t1, null, TROCAR);
			this.index = index;
		}
		
		void executa() {
			Pokemon anterior = ator.getPokeAtual();
			if(ator.setAtivo(index))
				System.out.println(t1.getNome() + " trocou "+anterior+" por "+ator.getPokeAtual());
			else
				System.out.println("Não foi possivel trocar.");
		}
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
				
				if(!ator_poke.estaVivo())
					return;
				
				Pokemon alvo_poke = alvo.getPokeAtual();
				Ataque att = ator_poke.getAtaque();
				int dano = att.getDano();
				dano = dano*multiplier[ator_poke.getTipo()][alvo_poke.getTipo()];
				
				alvo_poke.atualizaVida(-dano);								
		}
	}	
	
	static executaRound() {
		
		Atacar ataque = new Atacar();
		
		ataque.executa(treinador1, treinador2, 4);
		
	}
	
	
	
	
}
