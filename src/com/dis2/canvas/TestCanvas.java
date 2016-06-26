/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.canvas;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.net.URL;

/**
 *
 * @author Idontgiveafuck
 */
public class TestCanvas {

    public static void main(String args[]){
        try {
            System.out.println("Running testing canvas");

            URL url = TestCanvas.class.getResource(
                    "/resources/mockMap.png");
            System.out.println(url.getPath());
            ImageIcon icon = new ImageIcon(url);

            CanvasWidget panel = new CanvasWidget(icon.getImage());
            JFrame frame = new JFrame("Test Canvas");
            frame.setSize(800,800);
            frame.getContentPane().add(panel);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
