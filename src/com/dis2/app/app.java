package com.dis2.app;

import javax.swing.JButton;

public class app {
    public static void main(String args[]){
        System.out.println("hello");
        MenuWidget menuWidget = new MenuWidget(600, 600);
        menuWidget.expandList(new JButton("Hell"), "Hell1");
        menuWidget.expandList(new JButton("Hell level 2"), "Hell2");
        menuWidget.expandList(new JButton("Hell level 3"), "Hell3");
        menuWidget.redraw();
    }
}
