package com.dis2.cards;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class cardAnimation extends JPanel{
	
	private static final long serialVersionUID = 3L;
	
	cardWidget cw;
	Image image;
	double w;
	double h;
	
	public cardAnimation(cardWidget cw, Image i){
		this.cw = cw;
		this.image = i;
	}
	
	 public void paintComponent(Graphics g) {
		  double w = (cw.getGifScale())/2.3 * image.getWidth(this);
		  double h = (cw.getGifScale())/2.3 * image.getHeight(this);
		  
	    super.paintComponent(g);
	    if (image != null) {
	    	g.drawImage(image, 0, 0, (int)w, (int)h, this);
	    }
	  }
	

}


