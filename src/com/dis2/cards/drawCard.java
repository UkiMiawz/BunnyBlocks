//test class to draw cards
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class drawCard extends cardWidget{

	private JFrame window = new JFrame("Cards");
    private JLayeredPane lpane = new JLayeredPane();
    private JPanel content = new JPanel();
    private JPanel text = new JPanel();
    private Palette p = new Palette();
    fishCard fish;
    snakeCard snake;
    pandaCard panda;
    
    public drawCard(){
        
        //window.setContentPane(content);
        window.setBounds(30, 30, 800, 600);
        window.setPreferredSize(new Dimension(800, 600));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(lpane, BorderLayout.CENTER);
        
        lpane.setBounds(30, 30, 800, 600);
        content.setBounds(0, 0, 800, 600);
        fish = new fishCard(600, 10, 160, 240, 10, 10, 1.2, 1); //create card
        simpleCard card= new simpleCard();
        content.add(card);
        content.setOpaque(true);
        text.setBackground(p.green());
        text.setBounds(90, 200, 30, 30);
        JTextField forN = new JTextField("0",2);  
        text.add(forN);
        text.setOpaque(true);
        lpane.add(content, new Integer(0), 0);
        lpane.add(text, new Integer(1), 0);
        
        window.pack();
        window.setVisible(true);
        
        forN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Text=" + forN.getText());
              }
            });

        
    }
    
	public static void main(String[] args) {
		
		new drawCard();
	}
       
	
}

