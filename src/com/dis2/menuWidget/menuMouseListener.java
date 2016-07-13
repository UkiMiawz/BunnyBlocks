package com.dis2.menuWidget;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import com.dis2.cards.cardWidget;
import com.dis2.cards.complexCard;

public class menuMouseListener implements MouseInputListener{

	MenuWidget menuWidget;
	cardWidget myCard;
	
	public menuMouseListener(MenuWidget mw, complexCard cc)
	{
		menuWidget = mw; 
		myCard = cc.getCardWidget();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		menuWidget.descGlobalLabel.setFont(new Font("Arial Black", Font.ITALIC, 14));
		menuWidget.descGlobalLabel.setForeground(myCard.getFillColor());
		menuWidget.descGlobalLabel.setText("<html>" + myCard.getText() + "</html>");
		menuWidget.descGlobalLabel.setPreferredSize(new Dimension(menuWidget.getWidth(), 100));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		menuWidget.descGlobalLabel.setText("");
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
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
