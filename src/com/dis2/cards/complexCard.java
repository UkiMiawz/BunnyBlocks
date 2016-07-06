package com.dis2.cards;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.dis2.shared.Palette;

public class complexCard extends JPanel implements MouseListener{
	
	private static final long serialVersionUID = 2L;

	JLayeredPane lpane = new JLayeredPane();
	JPanel content = new JPanel();
	JPanel text = new JPanel();
	JPanel combo = new JPanel();
	JPanel animate = new JPanel();
	JTextField forN = new JTextField("0",2);  //Use only with snake card
	JComboBox<String> ifCombo = new JComboBox<String>(); //Use only with panda card
	Boolean flagAnim = false;
	cardWidget c;
	
	public complexCard(cardWidget c){
		this.c = c;
	}
	    
	public void paintComponent(Graphics g){
    	super.paintComponent(g);
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
		lpane.setBounds(0, 0, 180, 280);
		lpane.setPreferredSize(new Dimension(180, 280));
        content.setBounds(0, 0, 180, 280);
        
        simpleCard card= new simpleCard(c);
        
        content.add(card);
        content.addMouseListener(this);
        
        if(c.getTextBox()==1){
        
        content.setOpaque(true);
        text.setBackground(c.getFillColor());
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
            combo.setBackground(c.getFillColor());
            combo.setBounds(25, 200, 120, 30);
            combo.add(ifCombo);
            combo.setOpaque(true);
            lpane.add(content, new Integer(0), 0);
            lpane.add(combo, new Integer(1), 0);
        	
        }else{
        	
        lpane.add(content, new Integer(0), 0);
        
        }
        
        /**
         * Animation in card for MenuWidget
         */
        if(flagAnim){
        	content.setOpaque(true);
        	animate = new cardAnimation(c, c.getGif());
            animate.setBounds(15,25, 140, 160);
            animate.setOpaque(true);
            lpane.add(content, new Integer(0), 0);
        	lpane.add(animate, new Integer(1), 0);
        }
        
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

        add(lpane); 
        
	}
	
	 /**
     * Change color of card when the code is running
     */
	public void stateChanged(cardWidget c) {
		
		if(c.getTextBox()==1){
			c.setFillColor(Palette.brightGreen());
			simpleCard card= new simpleCard(c);
			text.setBackground(Palette.brightGreen());
			
		} else if(c.getTextBox()==2){
			c.setFillColor(Palette.brightPurple());
			simpleCard card= new simpleCard(c);
			combo.setBackground(Palette.brightPurple());
			
		}else{
			c.setFillColor(Palette.brightViolet());
			simpleCard card= new simpleCard(c);
	    }
	    
	}
	
	/**
     * Get back original color of card 
     */
	public void stateBack(cardWidget c) {
		
		if(c.getTextBox()==1){
			c.setFillColor(Palette.green());
			simpleCard card= new simpleCard(c);
			text.setBackground(Palette.green());
			
		} else if(c.getTextBox()==2){
			c.setFillColor(Palette.purple());
			simpleCard card= new simpleCard(c);
			combo.setBackground(Palette.purple());
			
		}else{
			c.setFillColor(Palette.violet());
			simpleCard card= new simpleCard(c);
	    }
	    
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Click");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse Entered Space");
		flagAnim = true; //this starts the animation of the gif
		//stateChanged(c); //test for highlight color in cards
		revalidate();
		repaint();

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse Exit Space");
		flagAnim = false; //this ends the animation of the gif and repaint regular img
		//stateBack(c); // //test for highlight color in cards
		revalidate();
		repaint();
		
	}
	
	public Dimension getPreferredSize() {
	    return new Dimension(180, 280); // appropriate constants
	  }

}
