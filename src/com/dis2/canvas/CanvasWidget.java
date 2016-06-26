/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.canvas;
import java.net.URL;
import java.util.ArrayList;

import java.awt.Image;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author whothefuckcare
 * Canvas widget for drawing level
 */
public class CanvasWidget extends JPanel {

    private Image backgroundImage;
    private ArrayList<AnimationObject> animationObjects = new ArrayList<AnimationObject>();
    private AnimationObject bunny;

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

            System.out.println("Testing add bunny character");
            URL url = TestCanvas.class.getResource(
                    "/resources/bunny1_stand.png");
            System.out.println(url.getPath());
            ImageIcon icon = new ImageIcon(url);
            AnimationObject bunny = new AnimationObject(150, 70, icon);

            System.out.println("Add objects");
            animationObjects.add(bunny);
            redrawCanvas();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private void redrawCanvas() {
        System.out.println("Redraw canvas");
        this.removeAll();
        for(AnimationObject animationObject: animationObjects) {
            this.add(animationObject);
        }
        this.revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        System.out.println("Painting component");
        g.drawImage(backgroundImage, 0, 0, null);
    }
}
