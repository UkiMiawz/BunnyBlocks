package com.dis2.app;
  
import com.dis2.canvasExtended.CanvasExtendedWidget;
import com.dis2.codeBlocks.CodeBlocks;
import com.dis2.cards.complexCard;
import com.dis2.cards.fishCard;
import com.dis2.cards.snakeCard;
import com.dis2.menuWidget.MenuWidget;
import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.*;


public class app extends JFrame{
    
    MenuWidget menuWidget; 
    CodeBlocks codeBlocks;
    CanvasExtendedWidget canvas;
    
    public app(){ 
        this.setLayout(new BorderLayout());   
        this.add(initCodeBlocks(),BorderLayout.CENTER);
        this.add(initMenu(),BorderLayout.LINE_START);
        this.add(initCanvas(), BorderLayout.LINE_END);
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

    public CanvasExtendedWidget initCanvas(){

        URL url = app.class.getResource(
                "/resources/mockMap.png");
        System.out.println(url.getPath());
        ImageIcon map = new ImageIcon(url);

        System.out.println("Testing add bunny character");
        URL urlChar = app.class.getResource(
                "/resources/bunny1_stand.png");
        System.out.println(urlChar.getPath());
        ImageIcon iconChar = new ImageIcon(urlChar);

        System.out.println("Testing add coin");
        URL urlCoin = app.class.getResource(
                "/resources/coin.gif");
        System.out.println(urlCoin.getPath());
        ImageIcon iconCoin = new ImageIcon(urlCoin);

        System.out.println("Testing add bunny walk");
        URL urlWalk = app.class.getResource(
                "/resources/bunny_walk.gif");
        System.out.println(urlWalk.getPath());
        ImageIcon iconWalk = new ImageIcon(urlWalk);

        canvas = new CanvasExtendedWidget(map.getImage(), iconChar, iconWalk, iconCoin, 80, 30, 340, 275);
        canvas.setCodeBlocks(codeBlocks);

        return canvas;
    }
    
    public static void main(String args[]){
        new app();
    }
    
}