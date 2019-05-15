package Poke;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

@SuppressWarnings("serial")
public class PanelTest extends JPanel
	{
	  private JButton startButton, quitButton;
	  private JRadioButton pokemon1, pokemon2, pokemon3; // The starter Pokemon choices
	  private JLabel charmander, squirtle, bulbasaur, label;
	  private JFrame pokemonWindow;
	  private ImageIcon charmanderImage, squirtleImage, bulbasaurImage;
	  private JPanel choices, buttons; // Separate panels for the radiobuttons/images and the start and quit buttons
	  private ButtonGroup bg; // For the radiobuttons
	  
	  //-----------------------------------------------------------------
	  //  Constructor: Sets up the main GUI components.
	  //-----------------------------------------------------------------
	  public PanelTest() {

	      GridLayout g1 = new GridLayout(3, 2);
	      g1.setHgap(200);
	      choices = new JPanel(g1);
	      GridLayout g2 = new GridLayout(1, 2);
	      g2.setHgap(300);
	      buttons = new JPanel(g2);
	      
	      charmanderImage = new ImageIcon("img/MauricioTrielli.jpg", "Charmander");
	      squirtleImage = new ImageIcon("img/gauss.jpg", "Squirtle");
 
	      charmander = new JLabel(charmanderImage);
	      squirtle = new JLabel(squirtleImage);
      
	      pokemon1 = new JRadioButton("<html><font size = 8>Charmander</font></html>", true);
	      pokemon2 = new JRadioButton("<html><font size = 8>Squirtle</font></html>");
	    
	      bg = new ButtonGroup();
	      bg.add(pokemon1);
	      bg.add(pokemon2);
	      

	      startButton = new JButton("<html>START</html>");
	     // startButton.setFont(myFont);
	      startButton.setBackground(Color.RED);
	     quitButton = new JButton("<html>QUIT</html>");
	     // quitButton.setFont(myFont);
	      quitButton.setBackground(Color.BLUE);
	      
	      ButtonListener listener = new ButtonListener();
	      startButton.addActionListener(listener);
	      quitButton.addActionListener(listener);

	      choices.add(charmander);
	      choices.add(squirtle);
	      choices.add(pokemon1);
	      choices.add(pokemon2);
	      
	      add(choices);
	      buttons.add(startButton);
	      buttons.add(quitButton);           
	      add(buttons);
	      
	      //buttons.setPreferredSize(new Dimension(1000, 100)); // Changes sizes of buttons
	      setPreferredSize (new Dimension(2100, 1200));
	      
	      //pokemonWindow = null;  // Until user presses start, there is no maze window.
	  }
	  
	  //*****************************************************************
	  //  Represents an action listener for the buttons.
	  //*****************************************************************
	  private class ButtonListener implements ActionListener
	  {
	    //--------------------------------------------------------------
	    //  Determines which button was pressed and creates the map.
	    public void actionPerformed (ActionEvent event)
	    {
	      if (pokemonWindow != null) pokemonWindow.dispose();  // Close existing map window, if it exists.
	      
	      // Quit button was pressed
	      if (event.getSource() == quitButton) 
	        System.exit(0); 
	      
	      String pokemonName = ""; // Used to store the name of the selected Pokemon
	      String type = ""; // Used to store the type of the selected Pokemon
	      // Start button was pressed
	      if (event.getSource() == startButton){
	        // Determines the name and type of the Pokemon selected by the user
	        if (pokemon1.isSelected()){
	          pokemonName = charmanderImage.getDescription();
	          type = "Fire";
	        }
	        else if (pokemon2.isSelected()){
	          pokemonName = squirtleImage.getDescription();
	          type = "Water";
	        }
	        else {
	          pokemonName = bulbasaurImage.getDescription();
	          type = "Grass";
	        }
	      }
	      
	      Mapa mapa = new Mapa();
	      mapa.geraMapa();
	      // Create new Pokemon game with selected starter Pokemon
	      pokemonWindow = new JFrame("Map");
	      pokemonWindow.getContentPane().add (new MapPanel(10, 10, mapa));  // 10x10 map
	      pokemonWindow.pack();
	      pokemonWindow.setVisible(true);
	    }
	  }
	  
	  public static void main(String args[]) {
		
		  JFrame frame = new JFrame("Pokemon startup");
		  frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		  frame.getContentPane().add(new PanelTest());

		 frame.pack();
		 frame.setVisible(true);
	  }	  
	  
}
