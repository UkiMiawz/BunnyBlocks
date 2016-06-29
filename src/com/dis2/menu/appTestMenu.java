package com.dis2.menu;
import com.dis2.cards.*;

import javax.swing.JFrame;

import com.dis2.cards.pandaCard;

public class appTestMenu {
    public static void main(String args[]){
        System.out.println("hello menu");     
        MenuWidget menuWidget = new MenuWidget(900, 600);
        
        pandaCard panda = new pandaCard(5,5, 160, 240, 10, 10, 0.47, 20);
		menuWidget.expandCard(panda);
		
		snakeCard snake = new snakeCard(5,5, 160, 240, 10, 10, 0.5, 20);
		menuWidget.expandCard(snake);
		
		fishCard fish = new fishCard(5,5, 160, 240, 10, 10, 1.2, 20);
        menuWidget.expandCard(fish);
        
		menuWidget.redraw();        
        
        JFrame myFrame = new JFrame("Hello from the other side");
		myFrame.setSize(1200, 800);
		myFrame.add(menuWidget);
		myFrame.setVisible(true);		
    }
}
