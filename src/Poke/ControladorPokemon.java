package Poke;

public class ControladorPokemon extends ControladorDeEventos{

	private static boolean continua = true;
	
	public boolean prioriza(Evento e1, Evento e2) {
		if(e1.getTipoDeEvento() > e2.getTipoDeEvento())
			return true;
		
		if(e1.getTipoDeEvento() == e2.getTipoDeEvento())
			if(e1.getAtor().getIndex() < e2.getAtor().getIndex())
				return true;
		return false;
	}
	
	public Evento criaEvento(Acao ativa, Acao passiva) {
		
		switch(ativa.getTipoEvento()) {
			case ATACAR:
				return new Atacar(ativa.getTreinador(), passiva.getTreinador(), ativa.getP1());
			case ITEM:
				Item item = ativa.getTreinador().getItens(ativa.getP1());
				return new UsarItem(ativa.getTreinador(), item, ativa.getP2(), ativa.getPoke());
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
			continua = false;
		}
	}	
	
	private class UsarItem extends Evento{
		
		private int index;
		private Pokemon[] festa;
		private Item item;
		private Pokemon poke;
		
		public UsarItem(Treinador t1, Item item, int index, Pokemon poke) {
			super(t1, null, ITEM);
			this.item = item; 
			festa = ator.getFesta();
			this.index = index;
			this.poke = poke;
		}
		
		public void executa() {
			if(item.getNome() == "Potion") {	
				if(festa[index].atualizaVida(item.getCura())) 
					System.out.println(">>> "+festa[index].getNome() + " foi curado em "+item.getCura()+"\n");
				else
					System.out.println(">>> "+festa[index].getNome() + " não pode ser curado, pois já está morto.\n");
			}
			if(item.getNome() == "Pokesfera") {	
				if(RNG.rolaDado(100 - 100*poke.getHp()/poke.getHpMax())) {
					System.out.println(">>> Parabéns, voce capturou "+poke.getNome());
					continua = false;	
				}else {
					System.out.println(">>> Que pena, "+poke.getNome()+" fugiu de você. ;C");
				}			
			}
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
				System.out.println(">>> "+treinador1.getNome() + " trocou "+anterior.getNome()+" por "+ator.getPokeAtual().getNome()+"\n");
			else
				System.out.println(">>> Não foi possivel trocar: o pokemón está morto\n");
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
				
				if(!ator_poke.estaVivo()) {
					System.out.println(">>> O ataque de "+ator.getNome()+" falhou pois "+ator.getPokeAtual().getNome()+" esta morto!!\n");
					return;
				}
				
				Pokemon alvo_poke = alvo.getPokeAtual();
				Ataque att = ator_poke.getAtaque(ataque);
				double dano = att.getDano();
				dano = dano * multiplicador[ator_poke.getTipo()][alvo_poke.getTipo()];
				System.out.println(">>> "+ator_poke.getNome()+" usou "+att.getNome()+" sobre "+ alvo_poke.getNome()+"\n");
				if(!alvo_poke.atualizaVida(-(int)dano)) {
					alvo.addPokeMortos(1);
					System.out.println(">>> "+alvo_poke.getNome()+" sofreu "+ dano+" pontos de dano e morreu!!!\n");
				}else {
					System.out.println(">>> "+alvo_poke.getNome()+" sofreu "+ dano+" pontos de dano\n");
					}
		}
	}
	
	public boolean captura(Treinador t, Pokemon poke) {
		
		if(RNG.rolaDado(100 - 100*poke.getHp()/poke.getHpMax())) {
			System.out.println(">>> Parabéns, voce capturou "+poke.getNome());
			return true;
		}
		return false;
	}
	
	
	public static int anda(int dir, Mapa mapinha) {
		
		int tile;
		switch(dir) {
		case CIMA:
			mapinha.cima();
			
			break;
		case BAIXO:
			mapinha.baixo();
			break;
		case ESQUERDA:
			mapinha.esq();
			break;
		case DIREITA:
			mapinha.dir();
			break;
		}
		
		int id_poke = 0;
		int chance = 0;
		tile = mapinha.getTile();
		if(tile == '#')chance = 50;
		
		if(chance != 0 && RNG.rolaDado(chance)) {
			for(int i = 0; i < 10; i++)
				id_poke = RNG.rolaPoke(6);
			return id_poke;
		}
		return -1;
	}
	
	public static void continuaset(boolean b) {
		continua = b;
	}
	
	public static boolean executaRound(Acao a1,Acao a2) {
		
		ControladorPokemon control = new ControladorPokemon();
		
		Evento eventoT1 = control.criaEvento(a1, a2);
		Evento eventoT2 = control.criaEvento(a2, a1);
		
		if(control.prioriza(eventoT1, eventoT2)) {
			eventoT1.executa();
			if(continua)eventoT2.executa();
			
		}else {
			eventoT2.executa();
			if(continua)eventoT1.executa();
		}	
		return continua;
	}	
}
