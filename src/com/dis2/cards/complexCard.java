package com.dis2.cards;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.dis2.cards2.Card;
import com.dis2.shared.Palette;

public class complexCard extends JPanel implements Cloneable{
	
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
	Palette p = new Palette();
	
	public complexCard(){}
	
	public complexCard(cardWidget c){
		this.c = c;
		this.setBounds(new Rectangle(c.getX(), c.getY(), c.getRectWidth(), c.getRectHeight()));
		this.setLayout(null);
		
	}
	
	public cardWidget getCardWidget(){
		return this.c;
	}
	    
	public void paintComponent(Graphics g){
    	super.paintComponent(g);
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
		lpane.setBounds(0, 0, c.getRectWidth(), c.getRectHeight());
		lpane.setPreferredSize(new Dimension(c.getRectWidth(), c.getRectHeight()));
        content.setBounds(0, 0, c.getRectWidth(), c.getRectHeight());
        
        simpleCard card= new simpleCard(c);
        
        content.add(card);
        //content.addMouseListener(this);
        
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
        g.setColor(p.black());
        g.drawRect(0,0, this.getWidth(), this.getHeight());
        g.fillRect(0,0, this.getWidth(), this.getHeight());
       
	}
	
	public void setBounds(int width, int height) {
        this.setBounds(this.getX(), this.getY(), width, height);
    }
	
	public void addChild(complexCard child) {
        this.add(child); 
        int w = this.getWidth() <= child.getWidth() ? child.getWidth()+20 : this.getWidth();
        int h =0; 
        if(this.getChildren().size()==1){
            h=child.getHeight()+40;
            child.setLocation(10, 20);
        }else{
            h=this.getHeight()+child.getHeight()+20;
            child.setLocation(10, this.getHeight());
        } 
        this.setBounds(w, h); 
    }
	
	public ArrayList<complexCard> getChildren() {
        ArrayList<complexCard> children = new ArrayList<complexCard>();
        for (Component c : this.getComponents()) {
            if (c.getClass().getSuperclass().getSimpleName().equals("Card")) {
                children.add((complexCard) c);
            }
        }
        return children;
    }
	
	public boolean hasChildren() {
        return getChildren().size() == 0 ? false : true;
    }
	
	public Point getMidPoint() {
        return new Point(this.getX() + this.getWidth() / 2, this.getY() + this.getHeight() / 2);
    }
	
	 /**
     * Change color of card when the code is running
     */
	public void setHighlight() {
		
		if(c.getTextBox()==1){
			c.setFillColor(p.brightGreen());
			simpleCard card= new simpleCard(c);
			text.setBackground(p.brightGreen());
			
		} else if(c.getTextBox()==2){
			c.setFillColor(p.brightPurple());
			simpleCard card= new simpleCard(c);
			combo.setBackground(p.brightPurple());
			
		}else{
			c.setFillColor(p.brightViolet());
			simpleCard card= new simpleCard(c);
	    }
	    
	}
	
	/**
     * Get back original color of card 
     */
	public void setDefaultState() {
		
		if(c.getTextBox()==1){
			c.setFillColor(p.green());
			simpleCard card= new simpleCard(c);
			text.setBackground(p.green());
			
		} else if(c.getTextBox()==2){
			c.setFillColor(p.purple());
			simpleCard card= new simpleCard(c);
			combo.setBackground(p.purple());
			
		}else{
			c.setFillColor(p.violet());
			simpleCard card= new simpleCard(c);
	    }
	    
	}
	
	public void setDefaultBounds() {
        this.setBounds(c.getX(), c.getY(), c.getDefaultWidth(), c.getDefaultHeight());
    }

/*	@Override
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
		/*System.out.println("Mouse Entered Space");
		flagAnim = true; //this starts the animation of the gif
		//stateChanged(c); //test for highlight color in cards
		revalidate();
		repaint();*/

	/*}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		/*System.out.println("Mouse Exit Space");
		flagAnim = false; //this ends the animation of the gif and repaint regular img
		//stateBack(c); // //test for highlight color in cards
		revalidate();
		repaint();*/
		
	//}
	
	 @Override public complexCard clone() {
	        try {
	            final complexCard result = (complexCard) super.clone();
	            return result;
	        } catch (final CloneNotSupportedException ex) {
	            throw new AssertionError();
	        }
	     }
	
	public Dimension getPreferredSize() {
	    return new Dimension(180, 280); // appropriate constants
	  }

}
