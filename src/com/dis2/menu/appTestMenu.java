package com.dis2.menu;

import com.dis2.cards.*;

import javax.swing.JFrame; 
import com.dis2.cards.pandaCard;

public class appTestMenu extends JFrame{

    public static void main(String args[]) {
        MenuWidget menuWidget = new MenuWidget(300, 400);

        pandaCard panda = new pandaCard(0, 0, 160, 240, 10, 10, 0.47, 20);
        menuWidget.addCard(panda);

        snakeCard snake = new snakeCard(0, 0, 160, 240, 10, 10, 0.5, 20);
        menuWidget.addCard(snake);

        fishCard fish = new fishCard(0, 0, 160, 240, 10, 10, 1.2, 20);
        menuWidget.addCard(fish);

        JFrame myFrame = new JFrame("Hello from the other side");
        
        myFrame.setSize(1200, 800);
        myFrame.add(menuWidget);
        myFrame.setVisible(true);  

        myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
