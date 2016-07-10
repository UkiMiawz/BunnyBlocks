
package com.dis2.codeBlocks; 
import com.dis2.card.LoopCard;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JFrame;
import javax.swing.SwingConstants;


public class appTest extends JFrame{
    
    CodeBlocks cb = new CodeBlocks(600,300);
     
    
    appTest(int w, int h){
        this.setLayout(new BorderLayout()); 
        
        LoopCard one = new LoopCard(0,0,70,100);
        one.setName("1");
        one.setDefaultColor(Color.ORANGE);
        one.setDragColor(Color.gray);
        one.setDropColor(Color.black);
        one.setSelectedColor(Color.yellow);
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
        
        LoopCard three = new LoopCard(150,0,70,100);
        three.setName("3"); 
        three.setDefaultColor(Color.GREEN);
        three.setDragColor(Color.gray);
        three.setDropColor(Color.black);
        three.setSelectedColor(Color.yellow);
        Label oL3 =  new Label("3",SwingConstants.CENTER);
        oL3.setBounds(0, 0, 70, 20);  
        three.add(oL3);
        
         LoopCard four = new LoopCard(225,0,70,100);
        four.setName("4"); 
        four.setDefaultColor(Color.PINK);
        four.setDragColor(Color.gray);
        four.setDropColor(Color.black);
        four.setSelectedColor(Color.yellow);
        Label oL4 =  new Label("4",SwingConstants.CENTER);
        oL4.setBounds(0, 0, 70, 20);  
        four.add(oL4);
        
        cb.addCard(one); 
        cb.addCard(two); 
        cb.addCard(three);
        cb.addCard(four);
        
        this.add(cb);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }
    
    public static void main(String args[]){
        new appTest(600,300);
    }
    
}
