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
	double dano;
	int tipo;
	Ataque(double dmg, int type)
	{
		dano = dmg;
		tipo = type;
	}
}
