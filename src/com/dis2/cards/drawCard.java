import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class drawCard extends cardWidget{

	private JFrame window = new JFrame("Cards");
    private JLayeredPane lpane = new JLayeredPane();
    private JPanel content = new JPanel();
    private JPanel text = new JPanel();
    private JPanel combo = new JPanel();
    private Palette p = new Palette();
    private JTextField forN = new JTextField("0",2);  //Use only with snake card
    private JComboBox<String> ifCombo = new JComboBox<String>();
    
    static fishCard fish;
    static snakeCard snake;
    static pandaCard panda;
    
    public drawCard(cardWidget c){
        
        window.setBounds(30, 30, 180, 280);
        window.setPreferredSize(new Dimension(180, 280));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(lpane, BorderLayout.CENTER);
        
        lpane.setBounds(30, 30, 180, 280);
        content.setBounds(0, 0, 180, 280);
        
        simpleCard card= new simpleCard(c);
        
        content.add(card);
        
        if(c.getTextBox()==1){
        
        content.setOpaque(true);
        text.setBackground(p.green());
        text.setBounds(80, 197, 30, 30);
        text.add(forN);
        text.setOpaque(true);
        lpane.add(content, new Integer(0), 0);
        lpane.add(text, new Integer(1), 0);
        
        } else if(c.getTextBox()==2){
        	
        	//ifCombo.addItem("Red Apple");
        	ifCombo = new JComboBox<String>(c.getOptions());
        	ifCombo.setEditable(false);
        	
        	content.setOpaque(true);
            combo.setBackground(p.purple());
            combo.setBounds(25, 200, 120, 30);
            combo.add(ifCombo);
            text.setOpaque(true);
            lpane.add(content, new Integer(0), 0);
            lpane.add(combo, new Integer(1), 0);
        	
        }else{
        	
        lpane.add(content, new Integer(0), 0);
        
        }
        
        window.pack();
        window.setVisible(true);
        
        /**
         * Action event for Snake card
         * Take number input by user and set it in snakeCard
         */
        forN.addActionListener(new ActionListener() { //Use only with snake card
            public void actionPerformed(ActionEvent e) {
            	
                System.out.println("Text=" + forN.getText());  
                ((snakeCard) c).setNtimes(Integer.valueOf(forN.getText()));
              }
            });
        
        /**
         * Action event for Panda card
         * Take selection by user and set it in pandaCard
         */
        ifCombo.addActionListener(new ActionListener() { //Use only with panda card
            public void actionPerformed(ActionEvent e) {
            	
              System.out.println("Selected index=" + ifCombo.getSelectedIndex()
                  + " Selected item=" + ifCombo.getSelectedItem());
              //Set SelectedItem to match condition of class Conditions
              //Perfom action according
            }
          });

        
    }
    
	public static void main(String[] args) {
		
		fish = new fishCard(5,5, 160, 240, 10, 10, 1.2, 20);
		//snake = new snakeCard(5,5,160, 240, 10, 10, 0.5, 20);
		//panda = new pandaCard(5,5, 160, 240, 10, 10, 0.47, 20);
		//panda.setOptions(new String[] {"Red Apple", "Green Apple", "Blue Apple"});
		new drawCard(fish);
		//new drawCard(snake);
		//new drawCard(panda);
	}
       
	
}

