package com.dis2.menuWidget;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;  
import javax.swing.JPanel;

import com.dis2.cards.complexCard;
import com.dis2.cards.fishCard;
import com.dis2.cards.snakeCard;

public class appTestMenu extends JFrame{
 
    public static void main(String args[]) { 
    	MenuWidget menuWidget = new MenuWidget(200, 400);
        snakeCard snake = new snakeCard(3,3,110, 150, 10, 10, 0.3, 15);
        fishCard fishR = new fishCard(3,3, 110, 150, 10, 10, 0.3, 15 ,5);
        fishCard fishU = new fishCard(3,3, 110, 150, 10, 10, 0.3, 15 ,2);
        fishCard fishD = new fishCard(3,3, 110, 150, 10, 10, 0.3, 15 ,3);
        fishCard fishL = new fishCard(3,3, 110, 150, 10, 10, 0.3, 15 ,4);
        
        menuWidget.addCard(new complexCard(snake));
        menuWidget.addCard(new complexCard(fishR));
        menuWidget.addCard(new complexCard(fishU));
        menuWidget.addCard(new complexCard(fishD));
        menuWidget.addCard(new complexCard(fishL));
        
    	JFrame myFrame = new JFrame("Hello from the other side");
        
        myFrame.setSize(600, 600);
        myFrame.add(menuWidget);
        myFrame.setVisible(true);  

        myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
