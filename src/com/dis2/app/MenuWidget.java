package com.dis2.app;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.List;


public class MenuWidget {
	//private JFrame mainFrame;
	private JPanel mainFrame;
	private JInternalFrame menuFrame;
	private JInternalFrame descFrame;	
	private JLabel descGlobalLabel;
	
	public List<JButton> MenuContent;
	public int SizeX;
	public int SizeY;
		
	public MenuWidget(int inputX, int inputY)
	{
		MenuContent = new ArrayList<JButton>();
		this.SizeX = inputX;
		this.SizeY = inputY;		
	}
	
	public MenuWidget()
	{
		this(400,400);
	}
	
	/*
	public static void main(String[] args)
	{
		MenuWidget menuWidget = new MenuWidget();
	}*/
	
	public void redraw()
	{
		setUpDescFrame();
		setUpMenuFrame();
		drawMainFrameGUI();		
	}
	
	public void expandList(JButton newButton, String actionCommand)
	{
		newButton.setActionCommand(actionCommand);
		newButton.addActionListener(new ButtonClickListener());
		MenuContent.add(newButton);
	}
	
	public void reduceList(JButton removedButton)
	{
		MenuContent.remove(removedButton);
	}

	private void drawMainFrameGUI()
	{
		//mainFrame = new JFrame("Hello GUI");
		mainFrame = new JPanel();
		mainFrame.setSize(SizeX, SizeY);
		mainFrame.setLayout(new GridLayout(2,1));
		//mainFrame.setLocationRelativeTo(null);
		mainFrame.add(menuFrame);
		mainFrame.add(descFrame);
		
		mainFrame.setVisible(true);
		//mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JFrame myFrame = new JFrame("Hello from the other side");
		myFrame.setSize(500, 600);
		myFrame.add(mainFrame);
		myFrame.setVisible(true);
	}
	
	private void setUpMenuFrame()
	{
		// For the menu frame
		menuFrame = new JInternalFrame("Menu");
		menuFrame.setVisible(true);		
				
		JPanel menuMainPanel = new JPanel(new BorderLayout());
		
		JPanel contentPanel = new JPanel(new GridLayout(0,1));
		for(JButton button : MenuContent)
		{
			button.setPreferredSize(new Dimension(90, 25));
			contentPanel.add(button);
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
		
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout gbl = new GridBagLayout();
		
		// For the content
		gbc.fill= GridBagConstraints.FIRST_LINE_END;
		descFrame.setLayout(gbl);
		
		JButton myButton = new JButton("Heaven");
		myButton.setPreferredSize(new Dimension(90, 25));
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth= 1;
		gbl.setConstraints(myButton, gbc);
		myButton.setActionCommand("heavenClick");
		myButton.addActionListener(new ButtonClickListener());
		
		descGlobalLabel = new JLabel("I'm in Heaven", JLabel.LEFT);
		descGlobalLabel.setHorizontalAlignment(JLabel.LEFT);
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbl.setConstraints(descGlobalLabel, gbc);
		
		descFrame.add(myButton);
		descFrame.add(descGlobalLabel);
	}
	
	private class ButtonClickListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			switch(command)
			{
				case "Hell1":
					descGlobalLabel.setText("Now I'm in Hell level 1");
					break;
					
				case "Hell2":
					descGlobalLabel.setText("Aaargghh!!! Now I'm in Hell level 2");
					break;
				
				case "Hell3":
					descGlobalLabel.setText("Great, Now I'm in Hell level 3");
					break;
					
				case "heavenClick":
					descGlobalLabel.setText("Fuck, Now I'm in Heaven");
					break;
			}
		}
	}
}
