package Poke;

public class Pokemon {
	private String nome;
	private int tipo;
	private boolean vivo;
	private int hpmax;
	private int hp;
	private int ataque;
	private int defesa;
	private Ataque atk[];
	Pokemon(int vidas, int type, int atak, int def, Ataque atk[])
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
		if(value>=0)
		{
			if(vivo)
			{
				hp += value;
				if(hp > hpmax)
					hp = hpmax;				
			}
			else
				return false;
		}
		else
			hp += value;
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
	public int getAtaque()
	{
		return ataque;
	}
	public int getDefesa()
	{
		return defesa;
	}
}
