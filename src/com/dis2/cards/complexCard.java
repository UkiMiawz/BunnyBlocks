package com.dis2.cards;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.dis2.shared.Palette;

public class complexCard extends JPanel{
	
	private static final long serialVersionUID = 2L;

	private JLayeredPane lpane = new JLayeredPane();
	private JPanel content = new JPanel();
	private JPanel text = new JPanel();
	private JPanel combo = new JPanel();
	private Palette p = new Palette();
	private JTextField forN = new JTextField("0",2);  //Use only with snake card
	private JComboBox<String> ifCombo = new JComboBox<String>();
	    
	public complexCard(cardWidget c){
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
		lpane.setBounds(30, 30, 180, 280);
		lpane.setPreferredSize(new Dimension(180, 280));
        content.setBounds(0, 0, 180, 280);
        
        simpleCard card= new simpleCard(c);
        
        content.add(card);
        content.addMouseListener(new CustomMouseListener());
        
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
			c.setFillColor(p.brightGreen());
			simpleCard card= new simpleCard(c);
			text.setBackground(p.brightGreen());
			
		} else if(c.getTextBox()==2){
			c.setFillColor(p.brightPurple());
			simpleCard card= new simpleCard(c);
			combo.setBackground(p.brightPurple());
			
		}else{
			c.setFillColor(p.brightRed());
			simpleCard card= new simpleCard(c);
	    }
	    
	}
	
	/**
     * Get back original color of card 
     */
	public void stateBack(cardWidget c) {
		
		if(c.getTextBox()==1){
			c.setFillColor(p.green());
			simpleCard card= new simpleCard(c);
			text.setBackground(p.green());
			
		} else if(c.getTextBox()==2){
			c.setFillColor(p.purple());
			simpleCard card= new simpleCard(c);
			combo.setBackground(p.purple());
			
		}else{
			c.setFillColor(p.red());
			simpleCard card= new simpleCard(c);
	    }
	    
	}

}
