/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.canvas;
import java.io.File;

import java.awt.Image;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author whothefuckcare
 * Canvas widget for drawing level
 */
public class CanvasWidget extends JPanel {

    private Image backgroundImage;

    public CanvasWidget(String imgPath) {
        this(new ImageIcon(imgPath).getImage());
    }

    public CanvasWidget(Image backgroundImage) {
        try{
            System.out.println("Initiating canvas widget with image");
            this.backgroundImage = backgroundImage;
            Dimension size = new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            setLayout(null);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        System.out.println("Painting component");
        g.drawImage(backgroundImage, 0, 0, null);
    }
}
