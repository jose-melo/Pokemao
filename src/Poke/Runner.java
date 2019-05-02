 package Poke;

import java.util.Scanner;

public class Runner extends Constante{

	public static void main(String args[]) {
		
		boolean perdeu = false;
		int prox = 1;
		
		Ataque[] listaAtaques = new Ataque[4];
		
		listaAtaques[0] = new Ataque("Choque do trovão", 35, ELETRICO);
		listaAtaques[1] = new Ataque("Vomito cuspido", 40, GRAMA);
		listaAtaques[2] = new Ataque("Aula do Gomi", 100, VENENO);
		listaAtaques[3] = new Ataque("Politecnico ", 20, TREVAS);
		
		Pokemon[] party1 = new Pokemon[6];
		
		party1[0] = new Pokemon("Pikachu", 100, ELETRICO, 30, listaAtaques);
		party1[1] = new Pokemon("Raichu", 100, FANTASMA, 40, listaAtaques);
		party1[2] = new Pokemon("Digimon", 100, TERRA, 50, listaAtaques);
		party1[3] = new Pokemon("Pegamon", 100, LUTADOR, 10, listaAtaques);
		party1[4] = new Pokemon("Fingermon", 100, ACO, 20, listaAtaques);
		party1[5] = new Pokemon("Topzeramon", 100, GRAMA, 70, listaAtaques);
		
		Pokemon[] party2 = new Pokemon[6];
		
		party2[0] = new Pokemon("Pikachu", 100, ELETRICO, 30, listaAtaques);
		party2[1] = new Pokemon("Raichu", 100, FANTASMA, 40, listaAtaques);
		party2[2] = new Pokemon("Digimon", 100, TERRA, 50, listaAtaques);
		party2[3] = new Pokemon("Pegamon", 100, LUTADOR, 10, listaAtaques);
		party2[4] = new Pokemon("Fingermon", 100, ACO, 20, listaAtaques);
		party2[5] = new Pokemon("Topzeramon", 100, GRAMA, 70, listaAtaques);
		
		
		Item[] itens = new Item[1];
		itens[0] = new Item(45, "gonorreia invertida");
		
		Treinador player2 = new Treinador(2, "Hamlet", party2, itens);
		
		System.out.println("----------------------------");
		System.out.println("BEM-VINDO AO POKE-POKE JOGO");
		System.out.println("----------------------------");
		
		System.out.println("Digite seu nome: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		
		Treinador player1 = new Treinador(1, name, party1, itens);
		Batalha.executaBatalha(player1, player2);
		in.close();
	}	
	
}
