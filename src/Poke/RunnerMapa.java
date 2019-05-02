package Poke;

import java.util.*;


public class RunnerMapa extends Constante{
	public static void main(String args[]) {
		
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
		
		Pokemon[][] selvagens = new Pokemon[7][1];
		
		selvagens[0][0] = new Pokemon("Pikachu", 100, ELETRICO, 30, listaAtaques);
		selvagens[1][0] = new Pokemon("Raichu", 100, FANTASMA, 40, listaAtaques);
		selvagens[2][0]= new Pokemon("Digimon", 100, TERRA, 50, listaAtaques);
		selvagens[3][0] = new Pokemon("Pegamon", 100, LUTADOR, 10, listaAtaques);
		selvagens[4][0] = new Pokemon("Fingermon", 100, ACO, 20, listaAtaques);
		selvagens[5][0] = new Pokemon("Topzeramon", 100, GRAMA, 70, listaAtaques);
		
		Treinador selvagem;
		
		System.out.println("----------------------------");
		System.out.println("BEM-VINDO AO POKE-POKE JOGO");
		System.out.println("----------------------------");
		
		System.out.println("Digite seu nome: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		
		Item[] itens = new Item[2];
		itens[0] = new Item(45, "gonorreia invertida");
		itens[1] = new Item("pokesfera");
		
		Treinador player1 = new Treinador(1, name, party1, itens);
		Mapa mapa = new Mapa();
		mapa.geraMapa();
		int poke;
		while(true){
			System.out.println("Selecione uma direcao para andar:");
			System.out.println("0 - CIMA|| 1 - BAIXO || 2 - ESQUERDA || 3 - DIREITA");
			mapa.imprimeMapa();			
			int e1 = in.nextInt();
			poke = ControladorPokemon.anda(e1,mapa);
			if(poke != -1) {
				selvagem = new Treinador(2, name, selvagens[poke], itens);
				Batalha.executaBatalha(player1, selvagem);
			}
			
			
		}
	}
	
}






















