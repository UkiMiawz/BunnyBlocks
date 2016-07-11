package com.dis2.app;
  
import com.dis2.codeblocks.CodeBlocks;
import com.dis2.cards.complexCard;
import com.dis2.cards.fishCard;
import com.dis2.cards.snakeCard;
import com.dis2.menuWidget.MenuWidget;
import java.awt.BorderLayout;
import java.awt.Color;  
import java.awt.Label;

import javax.swing.JComponent;
import javax.swing.JFrame;  
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;


public class app extends JFrame{
    
    MenuWidget menuWidget; 
    CodeBlocks codeBlocks; 
    
    
    public app(){ 
        this.setLayout(new BorderLayout());   
        this.add(initCodeBlocks(),BorderLayout.LINE_END);
        this.add(initMenu(),BorderLayout.LINE_START); 
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack(); 
    }
    
    public MenuWidget initMenu(){
        menuWidget = new MenuWidget(200, 400);
        snakeCard snake = new snakeCard(3,3,110, 150, 10, 10, 0.3, 15);
        fishCard fishR = new fishCard(3,3, 110, 150, 10, 10, 0.3, 15 ,5);
        fishCard fishU = new fishCard(3,3, 110, 150, 10, 10, 0.3, 15 ,2);
        fishCard fishD = new fishCard(3,3, 110, 150, 10, 10, 0.3, 15 ,3);
        fishCard fishL = new fishCard(3,3, 110, 150, 10, 10, 0.3, 15 ,4);
        
        JComponent snakeC = new complexCard(snake);
        JComponent fishRC = new complexCard(fishR);
        JComponent fishUC = new complexCard(fishU);
        JComponent fishDC = new complexCard(fishD);
        JComponent fishLC = new complexCard(fishL);
       
        menuWidget.addCard(snakeC);
        menuWidget.addCard(fishRC);
        menuWidget.addCard(fishUC);
        menuWidget.addCard(fishDC);
        menuWidget.addCard(fishLC);
        return menuWidget;
    }
    
    public JScrollPane initCodeBlocks(){
        codeBlocks = new CodeBlocks(500,400);
        JScrollPane scrollPane = new JScrollPane(codeBlocks);
        
        return scrollPane;
    }   
    
    public static void main(String args[]){
        new app();
    }
    
}