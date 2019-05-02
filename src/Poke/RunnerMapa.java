package Poke;

import java.util.*;


public class RunnerMapa {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Mapa mapa = new Mapa();
		mapa.geraMapa();
		while(true) 
		{
		System.out.println("Selecione uma direcao para andar:");
		System.out.println("0 - CIMA|| 1 - BAIXO || 2 - ESQUERDA || 3 - DIREITA");
		int e1 = in.nextInt();
		ControladorPoke.Anda(e1,mapa);
		}
		in.close();
	}
	
}
