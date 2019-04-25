package Poke;

public class Pokemon {
	private String nome;
	private int tipo;
	private boolean vivo;
	private int hpmax;
	private int hp;
	private double ataque;
	private double defesa;
	private Ataque atk[];
	Pokemon(int vidas, int type, double atak, double def, Ataque atk[])
	{
		vivo = true;
		hpmax = vidas;
		hp = hpmax;
		tipo = type;
		ataque = atak;
		defesa = def;
		this.atk=atk;
	}
	public boolean atualizaVida(int value)
	{
		hp += value;
		if(hp > hpmax)
			hp = hpmax;
		if(hp <=0)
		{
			hp = 0;
			vivo = false;
		}		
		return vivo;
	}
	public Ataque getAtaque(int index)
	{
		return atk[index];
	}
	public boolean getVivo()
	{
		return vivo;
	}
	public int getTipo()
	{
		return tipo;
	}
	public int getHp()
	{
		return hp;
	}
	public int getHpMax()
	{
		return hpmax;
	}
	public String getNome()
	{
		return nome;
	}
}
