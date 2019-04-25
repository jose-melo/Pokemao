package Poke;

public class Pokemon {
	String nome;
	//tipo?
	double hp;
	int tipo;
	double ataque;
	double defesa;
	Ataque atk[];
	Pokemon(double vidas, int type, double atak, double def, Ataque atk[])
	{
		hp = vidas;
		tipo = type;
		ataque = atak;
		defesa = def;
		this.atk=atk;
	}
}
