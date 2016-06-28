package com.dis2.menu;
import com.dis2.cards.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.List;


public class MenuWidget extends JPanel {
	private JInternalFrame menuFrame;
	private JInternalFrame descFrame;	
	private JLabel descGlobalLabel;
	private JPanel descGlobalPic;
	
	public List<cardWidget> cardContent;
	public int SizeX;
	public int SizeY;
		
	public MenuWidget(int inputX, int inputY)
	{
		cardContent = new ArrayList<cardWidget>();
		this.SizeX = inputX;
		this.SizeY = inputY;		
	}
	
	public MenuWidget()
	{
		this(400,400);
	}
		
	public void redraw()
	{
		setUpDescFrame();
		setUpMenuFrame();
		drawMainFrameGUI();		
	}
	
	public void expandCard(cardWidget newCard)
	{
		cardContent.add(newCard);		
	}	
	
	public void removeCard(cardWidget removedCard)
	{
		cardContent.remove(removedCard);
	}

	private void drawMainFrameGUI()
	{
		this.setSize(SizeX, SizeY);
		this.setLayout(new GridLayout(2,1));
		this.add(menuFrame);
		this.add(descFrame);
	}
	
	private void setUpMenuFrame()
	{
		// For the menu frame
		menuFrame = new JInternalFrame("Menu");
		menuFrame.setVisible(true);		

		JPanel menuMainPanel = new JPanel(new BorderLayout());

		JPanel contentPanel = new JPanel(new GridLayout(0,1));
		for(cardWidget cards : cardContent)
		{
			simpleCard simpC = new simpleCard(cards);
			simpC.addMouseListener(new MouseClickListener(cards));
			contentPanel.add(simpC);
		}			

		menuMainPanel.add(contentPanel, BorderLayout.PAGE_START);

		JScrollPane scrollPane = new JScrollPane(menuMainPanel);
		menuFrame.getContentPane().add(scrollPane);
		menuFrame.setSize(menuFrame.getPreferredSize());
	}
	
	private void setUpDescFrame()
	{		
		descFrame = new JInternalFrame("Description");
		descFrame.setVisible(true);
		
		JPanel descMainPanel = new JPanel(new BorderLayout());
		
		JPanel contentPanel = new JPanel(new GridLayout(0,1));
		descGlobalPic = new JPanel();
		descGlobalPic.add(new simpleCard(cardContent.get(0)));
		descGlobalLabel = new JLabel("Click the animal logo for description!", JLabel.LEFT);
		descGlobalLabel.setHorizontalAlignment(JLabel.CENTER);
		
		contentPanel.add(descGlobalPic);
		contentPanel.add(descGlobalLabel);
		
		descMainPanel.add(contentPanel, BorderLayout.CENTER);
		descFrame.add(descMainPanel);
		descFrame.setSize(descFrame.getPreferredSize());
	}
	
	private class MouseClickListener implements MouseListener
	{
		private cardWidget myCardWidget;
		public MouseClickListener(cardWidget cw)
		{
			myCardWidget = cw;
		}
		
		public void mouseClicked(MouseEvent arg0) {
			descGlobalLabel.setText(myCardWidget.getText());
			
			descGlobalPic.removeAll();			
			simpleCard currentCard = new simpleCard(myCardWidget);
			descGlobalPic.add(currentCard);
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
}
