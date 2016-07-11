package com.dis2.cards;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class drawCard extends JPanel{
	
	private static final long serialVersionUID = 3L;
	
	static fishCard fish;
	static snakeCard snake;
	static pandaCard panda;
	
    
	public static void main(String[] args) {

		fish = new fishCard(5,5, 160, 240, 10, 10, 1.2, 20 ,5);
		snake = new snakeCard(5,5,160, 240, 10, 10, 0.5, 20);
		panda = new pandaCard(5,5, 160, 240, 10, 10, 0.47, 20);
		panda.setOptions(new String[] {"Red Apple", "Green Apple", "Blue Apple"});
		
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
		
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Cards Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new complexCard(fish);//test fish, snake or panda
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}

