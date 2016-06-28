package com.dis2.menu;

import javax.swing.JButton;
import javax.swing.JFrame;

public class appTestMenu {
    public static void main(String args[]){
        System.out.println("hello menu");     
        MenuWidget menuWidget = new MenuWidget(600, 600);
        menuWidget.expandList(new JButton("Hell"), "Hell1");
        menuWidget.expandList(new JButton("Hell level 2"), "Hell2");
        menuWidget.expandList(new JButton("Hell level 3"), "Hell3");
        menuWidget.redraw();        
        
        JFrame myFrame = new JFrame("Hello from the other side");
		myFrame.setSize(500, 600);
		myFrame.add(menuWidget);
		myFrame.setVisible(true);
		
    }
}
