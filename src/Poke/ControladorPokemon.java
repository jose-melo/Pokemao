package Poke;

public class ControladorPokemon extends ControladorDeEventos{

	public boolean prioriza(Evento e1, Evento e2) {
		if(e1.getTipoDeEvento() > e2.getTipoDeEvento())
			return true;
		
		if(e1.getTipoDeEvento() == e2.getTipoDeEvento())
			if(e1.getAtor().getIndex() > e1.getAtor().getIndex())
				return true;
		return false;
	}
	
	public Evento criaEvento(Acao ativa, Acao passiva) {
		
		switch(ativa.getTipoEvento()) {
			case ATACAR:
				return new Atacar(ativa.getTreinador(), passiva.getTreinador(), ativa.getP1());
			case ITEM:
				Item item = ativa.getTreinador().getItens(ativa.getP1());
				return new UsarItem(ativa.getTreinador(), item, ativa.getP2());
			case FUGIR:
				return new Fugir(ativa.getTreinador());
			case TROCAR:
				return new Trocar(ativa.getTreinador(), ativa.getP1());
		}
		return null;
	}
	
	private class Fugir extends Evento{
		
		public Fugir(Treinador t1) {
			super(t1, null, FUGIR);
		}
		
		public void executa() {
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
		
		public void executa() {
			if(festa[index].atualizaVida(item.getCura()))
				System.out.println(festa[index].getNome() + " foi curado em "+item.getCura());
			else
				System.out.println(festa[index].getNome() + " não pode ser curado.");
		}
	}	
	
	private class Trocar extends Evento{
		
		private int index;
		private Treinador treinador1;
		public Trocar(Treinador t1, int index) {
			super(t1, null, TROCAR);
			treinador1 = t1;
			this.index = index;
		}
		
		public void executa() {
			Pokemon anterior = ator.getPokeAtual();
			if(ator.setAtivo(index))
				System.out.println(treinador1.getNome() + " trocou "+anterior+" por "+ator.getPokeAtual());
			else
				System.out.println("Não foi possivel trocar: o pokemón está morto");
		}
	}	
	
	private class Atacar extends Evento{
		
		private int ataque;
		
		public Atacar(Treinador t1, Treinador t2, int atack) {
			super(t1, t2, ATACAR);
			ataque = atack;
		}
		
		public void executa() {
			
				Pokemon ator_poke = ator.getPokeAtual();
				
				if(!ator_poke.estaVivo())
					return;
				
				Pokemon alvo_poke = alvo.getPokeAtual();
				Ataque att = ator_poke.getAtaque(ataque);
				int dano = att.getDano();
				dano = dano * multiplicador[ator_poke.getTipo()][alvo_poke.getTipo()];
				
				alvo_poke.atualizaVida(-dano);								
		}
	}	
	
	public static void executaRound(Acao a1,Acao a2) {
		
		ControladorPokemon control = new ControladorPokemon();
		Evento eventoT1 = control.criaEvento(a1, a2);
		Evento eventoT2 = control.criaEvento(a2, a1);
		
		if(control.prioriza(eventoT1, eventoT2)) {
			eventoT1.executa();
			eventoT2.executa();
		}else {
			eventoT2.executa();
			eventoT1.executa();
		}			
	}	
}
