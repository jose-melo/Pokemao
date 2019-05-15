package Poke;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.*;

public class MapPanel extends JPanel{

	private final int SIZE_OF_MAP_CELL = 70;  // Size of each map cell
	private final Color MAP_COLOR = new Color(115, 206, 165);  // Color of map
	private final ImageIcon PLAYER_IMAGE = new ImageIcon("img/player.gif");
	private final ImageIcon BRUSH_IMAGE = new ImageIcon("img/brush.gif");
	private final String STATUS_MESSAGE = "I have to escape from this place!";
	  
	private int rows;  // Number of rows in map
	private int cols;  // Number of cols in map
	private Pokemon pokemon;  // Charmander, Squirtle, or Bulbasaur
	private Mapa oMapa;  // We separate "the map" from the GUI map label components.
	private JLabel[][] mapLabels;  // We separate the map from the "GUI map label components".
	private int playerRow;  // Player's current row
	private int playerCol;  // Player's current column
	private JLabel statusLabel, texto;  // Displays all information for player
	public JFrame battle;
	private JPanel tela, buttons, aux;
	private JButton cima, baixo, esquerda, direita;
	private ButtonGroup bg;
	
	private int userOption;
	
	public MapPanel(int rows, int cols, Mapa mapa){
		battle = new JFrame();
		tela = new JPanel(new GridLayout(1, 2));
		aux = new JPanel(new GridLayout(2, 1));
		GridLayout g2 = new GridLayout(2, 2);
	    buttons = new JPanel(g2);
			    
		this.rows = rows;
	    this.cols = cols;
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
		
		addMapComponents();
		aux.add(texto);
		buttons.add(cima);
		buttons.add(baixo);
		buttons.add(esquerda);
		buttons.add(direita);
		aux.add(buttons);
		tela.add(aux);
		add(tela);
		
	    ButtonListener listener = new ButtonListener();
	    cima.addActionListener(listener);
	    baixo.addActionListener(listener);
	    esquerda.addActionListener(listener);
	    direita.addActionListener(listener);
		
	}
	
	public int InterfaceMapa() {
		
		userOption = -1;
		
	    while(userOption == -1);    
	    
		setPreferredSize(new Dimension(cols*SIZE_OF_MAP_CELL, rows*SIZE_OF_MAP_CELL + 80)); // Add 80 to account for status label
		setFocusable(true);

		return userOption;
	}
	
	private void addMapComponents() {     
	    JPanel mapPanel = new JPanel();
	    mapPanel.setLayout(new GridLayout(rows, cols));  // Use GridLayout for map labels
	    mapLabels = new JLabel[rows][cols];
	    for (int r=0; r<rows; r++) {
	      for (int c=0; c<cols; c++) {
	        mapLabels[r][c] = new JLabel();
	        mapLabels[r][c].setPreferredSize(new Dimension(SIZE_OF_MAP_CELL, SIZE_OF_MAP_CELL));
	        mapLabels[r][c].setMinimumSize(new Dimension(SIZE_OF_MAP_CELL, SIZE_OF_MAP_CELL));
	        Color clr = MAP_COLOR;
	        if (oMapa.getPos(r, c) == '#') 
	          mapLabels[r][c].setIcon(BRUSH_IMAGE);
	        mapLabels[r][c].setBackground(clr);
	        mapLabels[r][c].setOpaque(true);
	        mapPanel.add(mapLabels[r][c]);  // Add label components to GUI
	      }
	    }
	    mapLabels[oMapa.getX()][oMapa.getY()].setIcon(PLAYER_IMAGE);  // Add player image
	   tela.add(mapPanel);  // Add map panel to GUI
	}

	private class ButtonListener implements ActionListener
	  {
	    //--------------------------------------------------------------
	    //  Determines which button was pressed and creates the map.
	    public void actionPerformed (ActionEvent event)
	    {
	       
	      // Quit button was pressed
	      if (event.getSource() == cima) 
	        userOption = 0; 
	      
	       if (event.getSource() == baixo)
		        userOption = 1; 

	       if (event.getSource() == esquerda)
		        userOption = 2; 
	       
	       if (event.getSource() == direita)
		        userOption = 3; 
	            
	    }
	  }
	
}
