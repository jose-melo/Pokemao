package Poke;

/*
 * tipos:
 * 1 = normal 10 = fogo
 * 2 = lutador 11 = agua
 * 3 = voador 12 = grama
 * 4 = veneno 13 = eletrico
 * 5 = terra 14 = psiquico
 * 6 = pedra 15 = gelo
 * 7 = inseto 16 = dragão
 * 8 = fantasma 17 = trevas
 * 9 = aço 18 = fada
 */
public class Ataque {
	private String nome;
	private int dano;
	private int tipo;
	private int accuracy;
	
	public Ataque(String nome, int dmg, int type) {
		this(nome,dmg,type, 0);
	}
	public Ataque(String nome, int dmg, int type, int acc)
	{
		this.nome = nome;
		dano = dmg;
		tipo = type;
		accuracy = acc;
	}
	public int getDano()
	{
		return dano;
	}
	public int getTipo()
	{
		return tipo;
	}
	public int getAccuracy()
	{
		return accuracy;
	}
	public String getNome() {
		return nome;
	}
}
