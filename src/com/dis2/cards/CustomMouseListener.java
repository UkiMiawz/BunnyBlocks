package com.dis2.cards;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CustomMouseListener implements MouseListener{
	
	public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked");;
     }

     public void mousePressed(MouseEvent e) {
     }

     public void mouseReleased(MouseEvent e) {
     }

     public void mouseEntered(MouseEvent e) {
    	 System.out.println("Mouse Entered Space");
     }

     public void mouseExited(MouseEvent e) {
     }

}
