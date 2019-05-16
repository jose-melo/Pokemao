package Poke;

import java.util.Scanner;

public class Batalha extends Constante{

	public static void executaBatalha(Treinador player1, Treinador player2) {

		boolean continua = true;
		int prox = 1;		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("-----------------------------");
		System.out.println("-------BATALHA POKEMON-------");
		System.out.println("-----------------------------");
		while(player1.getPokeMortos() != player1.getFesta().length && player2.getPokeMortos() != player2.getFesta().length && continua) {

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
			
			if(e1 == 0 && !player1.getPokeAtual().estaVivo()) {
				System.out.println("Você não pode atacar pois seu pokemon atual está morto.");	
				System.out.println("Selecione uma outra acao:");	
				System.out.println("1 - ITEM || 2 - TROCAR || 3 - FUGIR");
				e1 = in.nextInt();
			}			
			
			Acao a1 = null;
			Acao a2 = null;
			Pokemon[] festinha;
			Item[] mochilinha;
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
					System.out.println("Selecione o beat it que deseja usar:");
					mochilinha = player1.getMochila();
					for(int i = 0; i < mochilinha.length; i++)
						System.out.print("|| ("+i+") "+mochilinha[i].getNome()+" ");
					System.out.println(" ");
					int op = in.nextInt();
					
					if(op == 0) {
						System.out.println("Selecione o pokemon que deseja curar:");
						festinha = player1.getFesta();
						for(int i = 0; i < player1.getFesta().length; i++)
							System.out.print("|| ("+i+") "+festinha[i].getNome()+" ");
						System.out.println(" ");
						int idx = in.nextInt();
						a1 = new Acao(player1, ITEM, 0, idx);
					}
					
					if(op == 1) {
						System.out.println("Vá pegar seu poke manolo:");
						a1 = new Acao(player1, ITEM, 1, player2.getPokeAtual());
					}
					
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
				a2 = new Acao(player2, ATACAR, RNG.rolaPoke(4));
			else {
				a2 = new Acao(player2, TROCAR, prox);
				prox++;
			}
			
			continua = ControladorPokemon.executaRound(a1, a2);
			if(!continua) {	
				if(a1.getTipoEvento() == FUGIR) {   
					System.out.flush();  
					System.out.println("#############################");
					System.out.println("Você perdeu!!!");
					System.out.println("#############################");
					ControladorPokemon.continuaset(true);
					
				}else {    
					System.out.println("#############################");
					System.out.println("A Batalha acabou");
					System.out.println("#############################");
					ControladorPokemon.continuaset(true);
				}
			}
		}

		if(continua) {
			if(player1.getPokeMortos() != player1.getFesta().length) {  
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
	
}
