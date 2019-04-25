package Poke;

public class Pokemon {
	String nome;
	//tipo?
	boolean vivo;
	int hpmax;
	int hp;
	int tipo;
	double ataque;
	double defesa;
	Ataque atk[];
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
}
