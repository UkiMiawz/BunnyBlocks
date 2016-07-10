package com.dis2.menuWidget;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;  
import javax.swing.JPanel;

public class appTestMenu extends JFrame{
 
    public static void main(String args[]) { 
        MenuWidget menuWidget = new MenuWidget(300, 400);

        JPanel a = new JPanel();
        a.setPreferredSize(new Dimension(80,100));
        a.setBounds(0, 0, 80,100);
        a.setBackground(Color.red);
        menuWidget.addCard(a);

        JPanel b = new JPanel();
        b.setPreferredSize(new Dimension(80,100));
        b.setBounds(85, 0, 80,100);
        b.setBackground(Color.green);
        menuWidget.addCard(b);

        JPanel c = new JPanel();
        c.setPreferredSize(new Dimension(80,100));
        c.setBounds(170, 0, 80,100);
        c.setBackground(Color.blue);
        menuWidget.addCard(c);

        JFrame myFrame = new JFrame("Hello from the other side");
        
        myFrame.setSize(600, 600);
        myFrame.add(menuWidget);
        myFrame.setVisible(true);  

        myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
