/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.colorPicker;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class WheelSlider extends JPanel{
    
    
     @Override
    protected void paintComponent(Graphics g) {
       g.drawOval(0, 0, 80,80);
       
         
    }
    
    public static void main(String args[]) {
        try {
            JFrame frame = new JFrame("Test");
            frame.setSize(600, 400);
            frame.getContentPane().add(new WheelSlider());

            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
