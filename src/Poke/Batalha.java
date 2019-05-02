package Poke;

import java.util.Scanner;

public class Batalha extends Constante{

	public static void executaBatalha(Treinador player1, Treinador player2) {
		
		boolean perdeu = false;
		int prox = 1;		
		Scanner in = new Scanner(System.in);
		System.out.println("----------------------------");
		System.out.println("BEM-VINDO AO POKE-POKE JOGO");
		System.out.println("----------------------------");
		while(player1.getPokeMortos() != 6 && player2.getPokeMortos() != 6 && !perdeu) {

			System.out.println(player1.getNome()+": "+player1.getPokeMortos()+" vs. "+player2.getNome()+": "+player2.getPokeMortos());
			System.out.println("#############################");
			System.out.println("Você: "+player1.getPokeAtual().getNome());
			System.out.println("Vida: "+player1.getPokeAtual().getHp());
			System.out.println("----------------------------");
			System.out.println("Oponente: "+player2.getPokeAtual().getNome());
			System.out.println("Vida: "+player2.getPokeAtual().getHp());
			System.out.println("#############################");
			
			System.out.println("Selecione uma acao:");	
			
			System.out.println("0 - ATACAR|| 1 - ITEM || 2 - TROCAR || 3 - FUGIR");
			int e1 = in.nextInt();
			Acao a1 = null;
			Acao a2 = null;
			Pokemon[] festinha;
			switch(e1) {
				case 0:
					System.out.println("Escolha seu ataque:");
					for(int i = 0; i < 4; i++)
						System.out.print("|| ("+i+") "+player1.getPokeAtual().getAtaque(i).getNome()+" ");
					System.out.println(" ");
					int atk = in.nextInt();
					a1 = new Acao(player1, ATACAR, atk);
					break;
				case 1:
					System.out.println("Selecione o pokemon que deseja curar:");
					festinha = player1.getFesta();
					for(int i = 0; i < 6; i++)
						System.out.print("|| ("+i+") "+festinha[i].getNome()+" ");
					System.out.println(" ");
					int idx = in.nextInt();
					a1 = new Acao(player1, ITEM, 0, idx);
					break;
				case 2:
					System.out.println("Selecione o pokemon que deseja trocar:");
					festinha = player1.getFesta();
					for(int i = 0; i < 6; i++)
						System.out.print("|| ("+i+") "+festinha[i].getNome()+" ");
					System.out.println(" ");
					int id = in.nextInt();
					a1 = new Acao(player1, TROCAR, id);
					break;
				case 3:
					a1 = new Acao(player1, FUGIR);
					break;
			}
			if(player2.getPokeAtual().estaVivo())
				a2 = new Acao(player2, ATACAR, 1);
			else {
				a2 = new Acao(player2, TROCAR, prox);
				prox++;
			}
			ControladorPokemon.executaRound(a1, a2);
			
			
			if(a1.getTipoEvento() == FUGIR) {
				System.out.println("#############################");
				System.out.println("Você perdeu!!!");
				System.out.println("#############################");
				perdeu = true;
			}
		}

		if(!perdeu) {
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
		in.close();
	}
	
}
