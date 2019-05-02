package Poke;

public class Acao extends Constante{

	private Treinador t1;
	private int param1, param2;
	private int tipoEvento;
	private Pokemon poke;

	public Acao(Treinador t, int  evento, int p1) {
		this(t, evento, p1, 0);
	}
	
	public Acao(Treinador t, int  evento) {
		this(t, evento, 0, 0);
	}		
	
	public Acao(Treinador t, int  evento, int p1, int p2) {
		t1 = t;
		param1 = p1;
		param2 = p2;
		tipoEvento = evento;
	}
	
	public Acao(Treinador t, int  evento, int p1, Pokemon poke) {
		t1 = t;
		param1 = p1;
		this.poke = poke;
		tipoEvento = evento;
	}
	
	public Pokemon getPoke() {
		return poke;
	}
	
	public Treinador getTreinador() {
		return t1;
	}
	
	public int getP2() {
		return param2;
	}
	
	public int getP1() {
		return param1;
	}

	public int getTipoEvento() {
		return tipoEvento;
	}
}
