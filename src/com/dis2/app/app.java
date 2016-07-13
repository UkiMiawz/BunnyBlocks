package com.dis2.app;
  
import com.dis2.canvasExtended.CanvasExtendedWidget;
import com.dis2.codeBlocks.CodeBlocks;
import com.dis2.cards.complexCard;
import com.dis2.cards.fishCard;
import com.dis2.cards.snakeCard;
import com.dis2.menuWidget.MenuWidget;
import java.awt.BorderLayout;
import java.awt.Dimension;
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

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        container.setPreferredSize(new Dimension(350, 357));

        menuWidgetBase.setLayout(new java.awt.BorderLayout());

        menuWidget.setLayout(null);
        menuWidgetBase.add(initMenu(), BorderLayout.CENTER);

        GroupLayout menuWidgetContainerLayout = new GroupLayout(menuWidgetContainer);
        menuWidgetContainer.setLayout(menuWidgetContainerLayout);
        menuWidgetContainerLayout.setHorizontalGroup(
            menuWidgetContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(menuWidgetBase, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );
        menuWidgetContainerLayout.setVerticalGroup(
            menuWidgetContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(menuWidgetBase, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout codeBlocksLayout = new GroupLayout(codeBlocks);
        codeBlocks.setLayout(codeBlocksLayout);
        codeBlocksLayout.setHorizontalGroup(
            codeBlocksLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 733, Short.MAX_VALUE)
        );
        codeBlocksLayout.setVerticalGroup(
            codeBlocksLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );

        scrollpane.setViewportView(initCodeBlocks());

        javax.swing.GroupLayout containerLayout = new GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollpane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(menuWidgetContainer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(scrollpane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(menuWidgetContainer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        canvasBase.setLayout(new BorderLayout());

        javax.swing.GroupLayout canvasLayout = new GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
            canvasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        canvasLayout.setVerticalGroup(
            canvasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        canvasBase.add(initCanvas(), java.awt.BorderLayout.CENTER);

       GroupLayout canvasContainerLayout = new javax.swing.GroupLayout(canvasContainer);
        canvasContainer.setLayout(canvasContainerLayout);
        canvasContainerLayout.setHorizontalGroup(
            canvasContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(canvasBase, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        canvasContainerLayout.setVerticalGroup(
            canvasContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(canvasBase, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(canvasContainer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(container, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
            .addComponent(canvasContainer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        
        menuWidget.addCard(new complexCard(snake));
        menuWidget.addCard(new complexCard(fishR));
        menuWidget.addCard(new complexCard(fishU));
        menuWidget.addCard(new complexCard(fishD));
        menuWidget.addCard(new complexCard(fishL));
        
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