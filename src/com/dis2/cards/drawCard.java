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
        window.setBounds(30, 30, 180, 280);
        window.setPreferredSize(new Dimension(180, 280));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(lpane, BorderLayout.CENTER);
        
        lpane.setBounds(30, 30, 180, 280);
        content.setBounds(0, 0, 180, 280);
        
        fish = new fishCard(5,5, 160, 240, 10, 10, 1.2, 20);
        simpleCard card= new simpleCard(fish);
        
       //snake = new snakeCard(5,5,160, 240, 10, 10, 0.5, 20);
       // simpleCard card2= new simpleCard(snake);
        
        //panda = new pandaCard(5,5, 160, 240, 10, 10, 0.47, 20);
        //simpleCard card3= new simpleCard(panda);
        content.add(card);
        //content.add(card2);
        //content.add(card3);
        
        /*content.setOpaque(true);
        text.setBackground(p.green());
        text.setBounds(80, 197, 30, 30);
        JTextField forN = new JTextField("0",2);  //Use only with snake card
        text.add(forN);
        text.setOpaque(true);
        lpane.add(content, new Integer(0), 0);
        lpane.add(text, new Integer(1), 0);*/
        
        lpane.add(content, new Integer(0), 0);
        
        window.pack();
        window.setVisible(true);
        
       /* forN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Text=" + forN.getText());  //Use only with snake card
              }
            });*/

        
    }
    
	public static void main(String[] args) {
		
		new drawCard();
	}
       
	
}

