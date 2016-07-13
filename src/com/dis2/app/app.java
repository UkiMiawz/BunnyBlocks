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
    
    public static MenuWidget menuWidget; 
    CodeBlocks codeBlocks;
    CanvasExtendedWidget canvas;
    JPanel container = new JPanel();
    JPanel containerMenuWidget = new JPanel();
    private JPanel canvasBase;
    private JPanel canvasContainer;
    private JPanel menuWidgetBase;
    private JPanel menuWidgetContainer;
    private JScrollPane scrollpane;
    
    public app(){ 
      
        container = new JPanel();
        menuWidgetContainer = new JPanel();
        menuWidgetBase = new JPanel();
        menuWidget = initMenu();
        codeBlocks = new CodeBlocks(300,300);
        JScrollPane scrollpane = new JScrollPane();
        canvasContainer = new JPanel();
        canvasBase = new JPanel();
        canvas = initCanvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        container.setPreferredSize(new java.awt.Dimension(350, 357));

        menuWidgetBase.setLayout(new java.awt.BorderLayout());

        menuWidget.setLayout(null);
        menuWidgetBase.add(initMenu(), java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout menuWidgetContainerLayout = new javax.swing.GroupLayout(menuWidgetContainer);
        menuWidgetContainer.setLayout(menuWidgetContainerLayout);
        menuWidgetContainerLayout.setHorizontalGroup(
            menuWidgetContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuWidgetBase, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );
        menuWidgetContainerLayout.setVerticalGroup(
            menuWidgetContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuWidgetBase, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout codeBlocksLayout = new javax.swing.GroupLayout(codeBlocks);
        codeBlocks.setLayout(codeBlocksLayout);
        codeBlocksLayout.setHorizontalGroup(
            codeBlocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 733, Short.MAX_VALUE)
        );
        codeBlocksLayout.setVerticalGroup(
            codeBlocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );

        scrollpane.setViewportView(initCodeBlocks());

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(menuWidgetContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(menuWidgetContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        canvasBase.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout canvasLayout = new javax.swing.GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        canvasLayout.setVerticalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        canvasBase.add(initCanvas(), java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout canvasContainerLayout = new javax.swing.GroupLayout(canvasContainer);
        canvasContainer.setLayout(canvasContainerLayout);
        canvasContainerLayout.setHorizontalGroup(
            canvasContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvasBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        canvasContainerLayout.setVerticalGroup(
            canvasContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvasBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(canvasContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
            .addComponent(canvasContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack(); 
    }
    
    public MenuWidget initMenu(){
        menuWidget = new MenuWidget(400, 200);
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
        codeBlocks = new CodeBlocks(500,500);
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