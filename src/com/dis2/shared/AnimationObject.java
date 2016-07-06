/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.shared;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.net.URL;

/**
 *
 * @author idontgiveashit
 */
public class AnimationObject extends JLabel {

    private ImageIcon image;
    public void setImage(String value) {
        URL url = AnimationObject.class.getResource(value);
        ImageIcon icon = new ImageIcon(url);
        this.image = icon;
        setComponent();
    }

    public void setImage(ImageIcon image){
        this.image = image;
        setComponent();
    }

    private int xPosition;
    public int getX() { return xPosition; }
    public void setX(int value) { xPosition = value; }

    private int yPosition;
    public int getY() { return yPosition; }
    public void setY(int value) { yPosition = value; }

    public AnimationObject(String img) {
        this(new ImageIcon(img));
    }

    public AnimationObject(ImageIcon image) {
        this.image = image;
        setComponent();
    }

    public AnimationObject(int xPosition, int yPosition, ImageIcon imgIcon) {
        setX(xPosition);
        setY(yPosition);
        image = imgIcon;
        setComponent();
    }

    public void moveObject(int xDifference, int yDifference){
        setX(getX() + xDifference);
        setY(getY() + yDifference);
    }

    private void setComponent(){
        System.out.println("Set components");
        try {
            setIcon(image);
            setIconTextGap(0);
            setBorder(null);
            setText(null);
            setSize(image.getImage().getWidth(null), image.getImage().getHeight(null));
            setLocation(getX(), getY());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
