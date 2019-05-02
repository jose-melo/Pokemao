package Poke;

import java.util.Scanner;

public class Runner extends Constante{

	public static void main(String[] args) {
	
		Ataque[] listaAtaques = new Ataque[4];
		
		listaAtaques[0] = new Ataque("Choque do trovão", 35, ELETRICO);
		listaAtaques[1] = new Ataque("Vomito cosmido", 40, GRAMA);
		listaAtaques[2] = new Ataque("Aula do Gomi", 100, VENENO);
		listaAtaques[3] = new Ataque("Politecnico ", 20, TREVAS);
		
		Pokemon[] party = new Pokemon[6];
		
		party[0] = new Pokemon("Pikachu", 100, ELETRICO, 30, listaAtaques);
		party[1] = new Pokemon("Raichu", 100, FANTASMA, 40, listaAtaques);
		party[2] = new Pokemon("Digimon", 100, TERRA, 50, listaAtaques);
		party[3] = new Pokemon("Pegamon", 100, LUTADOR, 10, listaAtaques);
		party[4] = new Pokemon("Fingermon", 100, ACO, 20, listaAtaques);
		party[5] = new Pokemon("Topzeramon", 100, GRAMA, 70, listaAtaques);
		
		Item[] itens = new Item[1];
		itens[0] = new Item(45, "gonorreia invertida");
		
		Treinador player2 = new Treinador(2, "Hamlet", party, itens);
		
		System.out.println("----------------------------");
		System.out.println("BEM-VINDO AO POKE-POKE JOGO");
		System.out.println("----------------------------");
		
		System.out.println("Digite seu nome: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		
		Treinador player1 = new Treinador(1, name, party, itens);
		
		while(player1.getPokeMortos() != 6 && player2.getPokeMortos() != 6) {

			System.out.println("#############################");
			System.out.println("Pokemons mortos: "+player1.getPokeMortos());
			System.out.println("Seu pokemon atual: "+player1.getPokeAtual());
			System.out.println("Vida: "+player1.getPokeAtual().getHp());
			System.out.println("----------------------------");
			System.out.println("Pokemons mortos do "+player2.getNome()+": "+player2.getPokeMortos());
			System.out.println("Pokemon oponente: "+player2.getPokeAtual());
			System.out.println("Vida: "+player2.getPokeAtual().getHp());
			System.out.println("#############################");
			
			System.out.println("Selecione uma acao:");	
			
			System.out.println("0 - ATACAR|| 1 - ITEM || 2 - TROCAR || 3 - FUGIR");
			int e1 = in.nextInt();
			Acao a1 = null;
			switch(e1) {
				case 0:
					System.out.println("Escolha seu ataque:");
					for(int i = 0; i < 4; i++)
						System.out.print("|| "+player1.getPokeAtual().getAtaque(i)+" ");
					System.out.println(" ");
					int atk = in.nextInt();
					a1 = new Acao(player1, ATACAR, atk);
					break;
				case 1:
					System.out.println("Selecione o pokemon que deseja curar:");
					for(int i = 0; i < 6; i++)
						System.out.print("|| ("+i+") "+player1.getPokeAtual().getNome()+" ");
					System.out.println(" ");
					int idx = in.nextInt();
					a1 = new Acao(player1, ITEM, 0, idx);
					break;
				case 2:
					System.out.println("Selecione o pokemon que deseja trocar:");
					for(int i = 0; i < 6; i++)
						System.out.print("|| ("+i+") "+player1.getPokeAtual().getNome()+" ");
					System.out.println(" ");
					int id = in.nextInt();
					a1 = new Acao(player1, TROCAR, id);
				case 3:
					a1 = new Acao(player1, FUGIR);
			}
			
			Acao a2 = new Acao(player2, ATACAR, 1);
			ControladorPokemon.executaRound(a1, a2);
		}
		
		if(player1.getPokeMortos() != 6) {
			System.out.println("#############################");
			System.out.println("Você ganhou!!!");
			System.out.println("#############################");
		}else {
			System.out.println("#############################");
			System.out.println("Você perdeu!!!");
			System.out.println("#############################");
		}
		
		
	}	
	
}
