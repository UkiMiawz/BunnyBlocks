package com.dis2.menuWidget;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.dis2.app.app;
import com.dis2.cards.fishCard;

public class DescriptionPanel extends JPanel{

	private String defaultText = "Please help me reach the coin.";
	private Color defaultColor = Color.blue;
	private Font defaultFont = new Font("Arial Black", Font.ITALIC, 14);
	public JLabel descText;
	
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
        
    	// Bunny Image
    	URL imageUrl = fishCard.class.getResource("/resources/bunny_purple.png");
    	Image bunnyImg = Toolkit.getDefaultToolkit().getImage(imageUrl);
        g.drawImage(bunnyImg, 0, 0, this);
        
        // Dialog box
        int bunnyWidth = bunnyImg.getWidth(this);
        g.drawRect(bunnyWidth + 20, 3, 200, 100); 
        g.drawLine(bunnyWidth - 3, 103, bunnyWidth + 20, 50);
        
        // The content
        g.setColor(descText.getForeground());
        g.setFont(descText.getFont());
        String printedLabel = descText.getText();
        drawString(g, printedLabel, bunnyWidth + 25, 10, descText.getPreferredSize().width);
    }
    
    private void drawString(Graphics g, String text, int x, int y, int widthLimit) {
    	int textWidth = g.getFontMetrics().stringWidth(text);
        
    	String newText = "";
    	if(textWidth > widthLimit)
        {
    		// Iterate each member. Add '\n' every time its exceed widthLimit.
        	int currentWidthLimit = widthLimit;
        	for(char c: text.toCharArray())
        	{
        		newText += c;
        		int currentTextWidth = g.getFontMetrics().stringWidth(newText);
        		if (currentTextWidth > currentWidthLimit)
        		{
        			newText += "\n";
        			currentWidthLimit += widthLimit;
        		}
        	}        	
        }
    	else
    	{
    		newText = text;
    	}
        
    	for (String line : newText.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }
	
	public DescriptionPanel()
	{
		descText = new JLabel(defaultText);
		descText.setForeground(defaultColor);
		descText.setFont(defaultFont);
		descText.setPreferredSize(new Dimension(190, 90));
	}
	
	public void ChangeText(String newText, Color newColor, Font newFont)
	{
		//this.removeAll();
		descText.setText(newText);
		descText.setForeground(newColor);
		descText.setFont(newFont);
		this.revalidate();
		this.repaint();
	}
	
	public void ChangeTextOnly(String newText)
	{
		//this.removeAll();
		if (newText == "")
		{
			descText.setText(defaultText);
			descText.setForeground(defaultColor);
			descText.setFont(defaultFont);
		}
		else
		{
			descText.setText(newText);
		}
		this.revalidate();
		this.repaint();
	}
	 
	public static void main(String args[]){
        JFrame myPanel = new JFrame();
        myPanel.setSize(500, 500);
		DescriptionPanel bunbun = new DescriptionPanel();
		myPanel.add(bunbun);
		myPanel.setVisible(true);
    }
}
