package Poke;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MapPanel extends JPanel{

	
	private final int TAM_CELULA_MAPA = 70;  
	private final Color COR_DO_MAPA = new Color(105, 196, 155); 
	private final ImageIcon IMAGEM_JOGADOR = new ImageIcon("img/dedo.png");
	private final ImageIcon IMAGEM_MATINHO = new ImageIcon("img/matopiba.png");
	private final ImageIcon CERCA = new ImageIcon("img/gate.gif");
	  
	private int linhas;  
	private int colunas;   
	private Mapa oMapa;  
	private JLabel[][] mapLabels; 
	private JLabel texto;  
	public JFrame batalha;
	private static final long serialVersionUID = 1L;
	public static JFrame pokemonWindow;
	private JPanel tela, buttons, aux, mapPanel;
	private JButton cima, baixo, esquerda, direita;
	private ButtonGroup bg;
	
	Ataque[] listaAtaques = new Ataque[4];
	Pokemon[] party1 = new Pokemon[6];
	Pokemon[][] selvagens = new Pokemon[7][1];
	Treinador selvagem;
	Item[] itens = new Item[2];
	Treinador player1;
		
	public MapPanel (int linhas, int colunas, Mapa mapa){
		
		
		batalha = new JFrame();
		tela = new JPanel(new GridLayout(1, 2));
		
		aux = new JPanel(new GridLayout(2, 1));
		GridLayout g2 = new GridLayout(2, 2);
	    buttons = new JPanel(g2);	    
		this.linhas = linhas;
	    this.colunas = colunas;
		oMapa = mapa;
		
		texto = new JLabel("Selecione a direcao");
	    cima = new JButton("<html>Cima</html>");
	    baixo = new JButton("<html>Baixo</html>");
	    esquerda = new JButton("<html>Esquerda</html>");
	    direita = new JButton("<html>Direita</html>");
	    
	    bg = new ButtonGroup();
	  
		bg.add(cima);
		bg.add(baixo);
		bg.add(esquerda);
		bg.add(direita);
		
		aux.add(texto);
		buttons.add(cima);
		buttons.add(baixo);
		buttons.add(esquerda);
		buttons.add(direita);
		aux.add(buttons);
		tela.add(aux);
		addMapComponents();
		add(tela);		
		
	    ButtonListener listener = new ButtonListener();
	    cima.addActionListener(listener);
	    baixo.addActionListener(listener);
	    esquerda.addActionListener(listener);
	    direita.addActionListener(listener);
	    
	    texto = new JLabel("texto2");
	    revalidate();
	    
		setPreferredSize(new Dimension(colunas*TAM_CELULA_MAPA, linhas*TAM_CELULA_MAPA + 80));
		setFocusable(true);
		
		player1 = new Treinador(1, "zehzin", party1, itens);
	    
	}
	
	
	private void addMapComponents() {     
	    mapPanel = new JPanel();
	    mapPanel.setLayout(new GridLayout(linhas+1, colunas+1));
	    mapLabels = new JLabel[linhas+1][colunas+1];
	    for (int r=0; r<=linhas; r++) {
	      for (int c=0; c<=colunas; c++) {
	        mapLabels[r][c] = new JLabel();
	        mapLabels[r][c].setPreferredSize(new Dimension(TAM_CELULA_MAPA, TAM_CELULA_MAPA));
	        mapLabels[r][c].setMinimumSize(new Dimension(TAM_CELULA_MAPA, TAM_CELULA_MAPA));
	        Color clr = COR_DO_MAPA;
	        if (oMapa.getPos(r, c) == '#') 
	          mapLabels[r][c].setIcon(IMAGEM_MATINHO);
	        if (oMapa.getPos(r, c) == 'X') 
		          mapLabels[r][c].setIcon(CERCA);
	        mapLabels[r][c].setBackground(clr);
	        mapLabels[r][c].setOpaque(true);
	        mapPanel.add(mapLabels[r][c]);
	      }
	    }
	    mapLabels[oMapa.getX()][oMapa.getY()].setIcon(IMAGEM_JOGADOR);  
	   tela.add(mapPanel);  
	
	   listaAtaques[0] = new Ataque("Choque do trovão", 35, 1);
		listaAtaques[1] = new Ataque("Vomito cuspido", 40, 1);
		listaAtaques[2] = new Ataque("Aula na poli", 100, 1);
		listaAtaques[3] = new Ataque("Politecnico", 20, 1);
		
		party1[0] = new Pokemon("Pikachu", 100, 1, 30, listaAtaques);
		party1[1] = new Pokemon("Raichu", 100, 1, 40, listaAtaques);
		party1[2] = new Pokemon("Digimon", 100, 1, 50, listaAtaques);
		party1[3] = new Pokemon("Pegamon", 100, 1, 10, listaAtaques);
		party1[4] = new Pokemon("Fingermon", 100, 1, 20, listaAtaques);
		party1[5] = new Pokemon("Topzeramon", 100, 1, 70, listaAtaques);
		
		selvagens[0][0] = new Pokemon("Pikachu", 100, 1, 30, listaAtaques);
		selvagens[1][0] = new Pokemon("Raichu", 100, 1, 40, listaAtaques);
		selvagens[2][0]= new Pokemon("Digimon", 100, 1, 50, listaAtaques);
		selvagens[3][0] = new Pokemon("Pegamon", 100,1, 10, listaAtaques);
		selvagens[4][0] = new Pokemon("Fingermon", 100, 1, 20, listaAtaques);
		selvagens[5][0] = new Pokemon("Topzeramon", 100, 1, 70, listaAtaques);
	
		itens[0] = new Item(45, "Potion");
		itens[1] = new Item("Pokesfera");
		
	}

	private class ButtonListener implements ActionListener
	  {
	    //--------------------------------------------------------------
	    //  Determines which button was pressed and creates the map.
	    public void actionPerformed (ActionEvent event)
	    {

		int poke = -1;
	      // Quit button was pressed
	      if (event.getSource() == cima) { 
	        poke = ControladorPokemon.anda(0,oMapa);
	        tela.remove(mapPanel);
	        addMapComponents();
			tela.revalidate();
			mapPanel.repaint();
			
			if(oMapa.getTile() == '#' && RNG.rolaDado(50))poke = RNG.rolaPoke(6);
			if(poke != -1) {

				mapPanel.setVisible(false);
				selvagem = new Treinador(2, selvagens[poke][0].getNome(), selvagens[poke], itens);
				Batalha.executaBatalha(player1, selvagem);
				poke = -1;
				mapPanel.setVisible(true);
			}
			
			
	      }
	       if (event.getSource() == baixo) { 
		        ControladorPokemon.anda(1,oMapa);
		        tela.remove(mapPanel);
		        addMapComponents();
				tela.revalidate();
				mapPanel.repaint();
				
				if(oMapa.getTile() == '#' && RNG.rolaDado(50))poke = RNG.rolaPoke(6);
				if(poke != -1) {

					mapPanel.setVisible(false);
					selvagem = new Treinador(2, selvagens[poke][0].getNome(), selvagens[poke], itens);
					Batalha.executaBatalha(player1, selvagem);
					poke = -1;
					mapPanel.setVisible(true);
				}
		      }
	    
	       if (event.getSource() == esquerda) { 
		        ControladorPokemon.anda(2,oMapa);
		        tela.remove(mapPanel);
		        addMapComponents();
				tela.revalidate();
				mapPanel.repaint();
				
				if(oMapa.getTile() == '#' && RNG.rolaDado(50))poke = RNG.rolaPoke(6);
				if(poke != -1) {

					selvagem = new Treinador(2, selvagens[poke][0].getNome(), selvagens[poke], itens);
					Batalha.executaBatalha(player1, selvagem);
					poke = -1;
					selvagem.getPokeAtual().setaHP(100);
				}
				
		      }
	       
	       if (event.getSource() == direita) { 
		        ControladorPokemon.anda(3,oMapa);
		        tela.remove(mapPanel);
		        addMapComponents();
				tela.revalidate();
				mapPanel.repaint();
				
				if(oMapa.getTile() == '#' && RNG.rolaDado(50))poke = RNG.rolaPoke(6);
				if(poke != -1) {

					mapPanel.setVisible(false);
					selvagem = new Treinador(2, selvagens[poke][0].getNome(), selvagens[poke], itens);
					Batalha.executaBatalha(player1, selvagem);
					poke = -1;
					mapPanel.setVisible(true);
				}
				
		      }
	            
	    }
	  }
	
	public static void main(String args[]) {
		
		Mapa mapa = new Mapa();
		mapa.geraMapa();
		
		System.out.println("----------------------------");
		System.out.println("BEM-VINDO AO POKE-POKE JOGO");
		System.out.println("----------------------------");
		
		pokemonWindow = new JFrame("Map");
	    pokemonWindow.getContentPane().add (new MapPanel(8, 8, mapa));  // 10x10 map
	    pokemonWindow.pack();
	    pokemonWindow.setVisible(true);
	}
	
	
}
