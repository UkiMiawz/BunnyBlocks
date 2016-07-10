package com.dis2.app;
  
import com.dis2.codeBlocks.CodeBlocks;
import com.dis2.cards2.LoopCard;
import com.dis2.menuWidget.MenuWidget;
import java.awt.BorderLayout;
import java.awt.Color;  
import java.awt.Label; 
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
        
        LoopCard one = new LoopCard(0,0,70,100);
        one.setName("1");
        one.setDefaultColor(Color.ORANGE);
        one.setDragColor(Color.gray);
        one.setDropColor(Color.black);
        one.setSelectedColor(Color.yellow);
        one.setDefaultState();
        Label oL1 =  new Label("1",SwingConstants.CENTER);
        oL1.setBounds(0, 0, 70, 20); 
        one.add(oL1);
        
        LoopCard two = new LoopCard(75,0,70,100);
        two.setName("2");
        two.setDefaultColor(Color.BLUE);
        two.setDragColor(Color.gray);
        two.setDropColor(Color.black);
        two.setSelectedColor(Color.yellow);
        Label oL2 = new Label("2",SwingConstants.CENTER);
        oL2.setBounds(0, 0, 70, 20);  
        two.add(oL2);
        two.setDefaultState();
        
        LoopCard three = new LoopCard(150,0,70,100);
        three.setName("3"); 
        three.setDefaultColor(Color.GREEN);
        three.setDragColor(Color.gray);
        three.setDropColor(Color.black);
        three.setSelectedColor(Color.yellow);
        Label oL3 =  new Label("3",SwingConstants.CENTER);
        oL3.setBounds(0, 0, 70, 20);  
        three.add(oL3);
        three.setDefaultState();
        
        LoopCard four = new LoopCard(225,0,70,100);
        four.setName("4"); 
        four.setDefaultColor(Color.PINK);
        four.setDragColor(Color.gray);
        four.setDropColor(Color.black);
        four.setSelectedColor(Color.yellow);
        Label oL4 =  new Label("4",SwingConstants.CENTER);
        oL4.setBounds(0, 0, 70, 20);  
        four.add(oL4);
        four.setDefaultState(); 
        
        menuWidget.addCard(one); 
        menuWidget.addCard(two); 
        menuWidget.addCard(three);
        menuWidget.addCard(four); 
        
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